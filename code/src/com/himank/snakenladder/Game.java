package com.himank.snakenladder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    private Board board;
    private Dice dice;
    private Deque<Player> players = new LinkedList<>();
    Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(100, 5, 6);
        dice = new Dice(1);
        initializePlayers();
    }

    private void initializePlayers() {
        Player player1 = new Player("Himank");
        Player player2 = new Player("Kumawat");

        players.add(player1);
        players.add(player2);
    }


    public void startGame() {
        while (winner == null) {
            Player playerTurn = findPlayer();
            System.out.println("Player turn is: " + playerTurn.name + " and current position is " + playerTurn.currentPosition);

            int diceOutput = dice.rollDice();
            int playerNewPosition = playerTurn.currentPosition + diceOutput;
            playerNewPosition = checkJump(playerNewPosition);

            System.out.println("Player turn is: " + playerTurn.name + " and new position is " + playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;
            if (playerNewPosition >= board.cells.length) {
                winner = playerTurn;
            }

        }

        System.out.println("Winner is : " + winner.name);
    }

    private int checkJump(int playerNewPosition) {
        Cell cell = board.getCell(playerNewPosition);
        if (cell.getJump() != null && cell.getJump().getStartPosition() == playerNewPosition) {
            Jump jump = cell.getJump();
            String jumper = jump.getStartPosition() < jump.getEndPosition() ? " Ladder " : " Snake ";
            System.out.println("Jump done by: " + jumper);
            return cell.getJump().getEndPosition();
        }
        return playerNewPosition;
    }

    private Player findPlayer() {
        Player currentPlayer = players.removeFirst();
        players.addLast(currentPlayer);
        return currentPlayer;
    }
}
