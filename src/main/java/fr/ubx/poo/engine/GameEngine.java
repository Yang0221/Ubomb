package fr.ubx.poo.engine;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.view.sprite.Sprite;
import fr.ubx.poo.view.sprite.SpriteFactory;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.World;
import fr.ubx.poo.model.go.character.Player;
import fr.ubx.poo.model.go.character.Monster;
import fr.ubx.poo.view.sprite.SpriteMonster;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public final class GameEngine {

    private static AnimationTimer gameLoop;
    private final String windowTitle;
    private final Game game;
    private final Player player;
    private final List<Sprite> sprites = new ArrayList<>();
    private final List<Monster> monsters;
    private final List<Sprite> spritesM = new ArrayList<>();
    private StatusBar statusBar;
    private Pane layer;
    private Input input;
    private Stage stage;
    private Sprite spritePlayer;
    Position position;
    //private Sprite spriteMonster;

    public GameEngine(final String windowTitle, Game game, final Stage stage) {
        this.windowTitle = windowTitle;
        this.game = game;
        this.monsters = game.getMonsters();
        this.player = game.getPlayer();
        initialize(stage, game);
        buildAndSetGameLoop();
    }

    private void initialize(Stage stage, Game game) {
        this.stage = stage;
        Group root = new Group();
        layer = new Pane();

        int height = game.getWorld().dimension.height;
        int width = game.getWorld().dimension.width;
        int sceneWidth = width * Sprite.size;
        int sceneHeight = height * Sprite.size;
        Scene scene = new Scene(root, sceneWidth, sceneHeight + StatusBar.height);
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

        stage.setTitle(windowTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        input = new Input(scene);
        root.getChildren().add(layer);
        statusBar = new StatusBar(root, sceneWidth, sceneHeight, game);
        // Create decor sprites
        game.getWorld().forEach((pos, d) -> sprites.add(SpriteFactory.createDecor(layer, pos, d)));
        spritePlayer = SpriteFactory.createPlayer(layer, player);
        /***
         * Tenatative de création de plusieurs monstres
         */


        monsters.forEach(monster -> spritesM.add(SpriteFactory.createMonster(layer,monster)));

    }

    /***
     * Ajout d'un timer pour réduire la vitesse de déplacment des monstres
     */
    java.util.Timer Timer = new java.util.Timer();
    java.util.TimerTask task = new java.util.TimerTask(){
        public void run(){
            monsters.forEach(monster -> monster.update());
        }

    };

    protected final void buildAndSetGameLoop() {
        gameLoop = new AnimationTimer() {
            public void handle(long now) {
                // Check keyboard actions
                processInput(now);

                // Do actions
                update(now);

                // Graphic update
                render();
                statusBar.update(game);
            }
        };
    }

    private void processInput(long now) {
        if (input.isExit()) {
            gameLoop.stop();
            Platform.exit();
            System.exit(0);
        }
        if (input.isMoveDown()) {
            player.requestMove(Direction.S);
        }
        if (input.isMoveLeft()) {
            player.requestMove(Direction.W);
        }
        if (input.isMoveRight()) {
            player.requestMove(Direction.E);
        }
        if (input.isMoveUp()) {
            player.requestMove(Direction.N);
        }
        if (input.isKey()){
            player.open_Door();
        }
        if (input.isBomb()){
            player.put_Bomb();
        }
        input.clear();
    }

    private void showMessage(String msg, Color color) {
        Text waitingForKey = new Text(msg);
        waitingForKey.setTextAlignment(TextAlignment.CENTER);
        waitingForKey.setFont(new Font(60));
        waitingForKey.setFill(color);
        StackPane root = new StackPane();
        root.getChildren().add(waitingForKey);
        Scene scene = new Scene(root, 400, 200, Color.WHITE);
        stage.setTitle(windowTitle);
        stage.setScene(scene);
        input = new Input(scene);
        stage.show();
        new AnimationTimer() {
            public void handle(long now) {
                processInput(now);
            }
        }.start();
    }


    private void update(long now) {
        player.update(now);
        //monsters.forEach(monster -> monster.update());
        //si Changed=true
        if(game.getWorld().hasChanged()){
            sprites.forEach(Sprite::render);
            sprites.clear();
            initialize(stage,game);//creer un nouveau world
            game.getWorld().setchanged(false);  // changed = false
        }
        if (player.isAlive() == false) {
            gameLoop.stop();
            showMessage("Perdu!", Color.RED);
        }
        if (player.isWinner()) {
            gameLoop.stop();
            showMessage("Gagné", Color.BLUE);
        }
    }

    private void render() {
        sprites.forEach(Sprite::render);
        // last rendering to have player in the foreground
        spritesM.forEach(Sprite::render);
        spritePlayer.render();

    }

    public void start() {
        Timer.scheduleAtFixedRate(task,1000,1000);
        gameLoop.start();
    }
}
