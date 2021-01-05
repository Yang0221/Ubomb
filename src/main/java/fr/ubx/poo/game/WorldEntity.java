/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.game;

import java.util.Arrays;
import java.util.Optional;

public enum WorldEntity {
    Empty('_'),
    Box('B'),
    Heart('H'),
    Key('K'),
    Monster('M'),
    DoorPrevOpened('V'),
    DoorNextOpened('N'),
    DoorNextClosed('n'),
    Player('P'),
    Stone('S'),
    Tree('T'),
    Princess('W'),
    BombRangeInc('>'),
    BombRangeDec('<'),
    BombNumberInc('+'),
    BombNumberDec('-')
        ;


    private char getCode() {
        return code;
    }

    private final char code;

    WorldEntity(char code) {
        this.code = code;
    }

    public static Optional<WorldEntity> fromCode(char code) {
        return Arrays.stream(values())
                .filter(e->e.acceptCode(code))
                .findFirst();
    }

    private boolean acceptCode(char code) {
        return this.code == code;
    }
    public static WorldEntity creat(char c){
        switch (c){
            case '_':
                return Empty;
            case 'B':
                return Box;
            case 'H':
                return Heart;
            case 'K':
                return Key;
            case 'M':
                return Monster;
            case 'n':
                return DoorNextClosed;
            case 'P':
                return Player;
            case 'S':
                return Stone;
            case 'T':
                return Tree;
            case 'W':
                return Princess;
            default:
                return Empty;
                
        }
    }
    @Override
    public String toString() {
        return ""+code;
    }
}
