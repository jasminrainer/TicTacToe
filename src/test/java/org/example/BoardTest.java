package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        TicTacToe game = new TicTacToe();

    }

    @Test
    public void testIsCellEmpty() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlaceMarker() {
        Board board = new Board();
        board.place(1, 1, 'O');
        assertEquals('O', board.getCells()[1][1]);
    }

    @Test
    public void testIsFull() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsNotFull() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 2 && j == 2)) { // Leave the last cell empty
                    board.place(i, j, 'X');
                }
            }
        }
        assertFalse(board.isFull());
    }

    @Test
    public void testIsFullWithOneEmptyCell() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) { // Leave one cell in the middle empty
                    board.place(i, j, 'X');
                }
            }
        }
        assertFalse(board.isFull());
    }

    @Test
    public void testClear() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPrintBoard() {

        Board board = new Board();
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));

        board.print();
        String expectedOutput =
                "-----\n" +
                        " | | \n" +
                        " | | \n" +
                        " | | \n" +
                        "-----\n";

        assertEquals(expectedOutput, actualOutput.toString());

        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');

        actualOutput.reset();

        board.print();
        expectedOutput =
                "-----\n" +
                        "X| | \n" +

                        " |O| \n" +
                        " | |X\n" +
                        "-----\n";

        assertEquals(expectedOutput, actualOutput.toString());

        System.setOut(System.out);
    }

    @Test
    public void testPrintBoardNotEquals() {
        Board board = new Board();
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));

        board.print();
        String notExpectedOutput =
                "-----\n" +
                        "X|O|X\n" +
                        "X|O|X\n" +
                        "X|O|X\n" +
                        "-----\n";

        assertNotEquals(notExpectedOutput, actualOutput.toString());

        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');

        actualOutput.reset();

        board.print();
        notExpectedOutput =
                "-----\n" +
                        "O| | \n" +
                        " |X| \n" +
                        " | |O\n" +
                        "-----\n";

        assertNotEquals(notExpectedOutput, actualOutput.toString());

        System.setOut(System.out);
    }


}


