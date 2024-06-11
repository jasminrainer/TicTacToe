package org.example;
import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    public Board board;

    public TicTacToe() {
        this.board = new Board();
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
    }

    public void start() {
        boolean playing = true;
        while (playing == true) {
            System.out.println("Player " + currentPlayer.getMarker() + "'s turn");

            int row = getInput("Enter row (0, 1 or 2) ");
            int col = getInput("Enter column (0, 1 or 2) ");

            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());
                switchCurrentPlayer();

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

}
