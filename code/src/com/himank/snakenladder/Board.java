package com.himank.snakenladder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[] cells;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadder) {
        cells = new Cell[boardSize];
        for (int i = 0; i < boardSize; i++) {
            cells[i] = new Cell();
        }
        initializeSnakesAndLadders(numberOfSnakes, numberOfLadder);
    }

    private void initializeSnakesAndLadders(int numberOdSnakes, int numberOfLadder) {
        while (numberOdSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(0, this.cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(0, this.cells.length - 1);
            if (snakeTail >= snakeHead) {
                continue;
            }
            Cell cell = cells[snakeHead];
            cell.setJump(new Jump(snakeHead, snakeTail));
            numberOdSnakes--;
        }

        while (numberOfLadder > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(0, this.cells.length - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(0, this.cells.length - 1);
            if (ladderEnd <= ladderStart) {
                continue;
            }
            Cell cell = cells[ladderStart];
            cell.setJump(new Jump(ladderStart, ladderEnd));
            numberOfLadder--;
        }
    }

    public Cell getCell(int playerPosition) {
        if (playerPosition >= cells.length)
            return cells[cells.length - 1];
        return this.cells[playerPosition];
    }
}
