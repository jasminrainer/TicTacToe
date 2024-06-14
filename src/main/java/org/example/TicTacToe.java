package org.example;

import java.util.Scanner;

public class TicTacToe {
    public Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToe() {
        this.board = new Board();
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        board.print();
    }

    public void start() {
        boolean playing = true;
        while (playing == true) {
            System.out.println("Player " + currentPlayer.getMarker() + "'s turn");

            int row = getInput("Enter row (0, 1 or 2) ");
            int col = getInput("Enter column (0, 1 or 2) ");

            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());
                board.print();
                if (hasWinner()) {
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    playing = false;
                } else if (board.isFull()) {
                    System.out.println("The game is a draw!");
                    playing = false;
                } else {
                    switchCurrentPlayer();
                }
            } else {
                System.out.println("This position is already occupied. Choose a different one.");
            }
        }
    }

    private int getInput(String answer) {
        System.out.print(answer);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    protected void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    protected boolean hasWinner() {
        char marker = currentPlayer.getMarker();
        char[][] cells = board.getCells();

        for (int i = 0; i < 3; i++) {

            if ((cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) ||
                    (cells[0][i] == marker && cells[1][i] == marker && cells[2][i] == marker)) {
                return true;
            }
        }

        if ((cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) ||
                (cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker)) {

            return true;
        }
        return false;
    }


}
