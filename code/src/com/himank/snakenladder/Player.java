package com.himank.snakenladder;

public class Player {

    String name;

    int currentPosition;

    public Player(String name, int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public Player(String name) {
        this(name, 0);
    }
}
