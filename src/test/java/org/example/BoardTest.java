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
    public void testPrintBoard() {
        Board board = new Board();

        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));

        board.print();
        String expectedOutput =
                " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n";

        assertEquals(expectedOutput, actualOutput.toString());

        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');

        actualOutput.reset();

        board.print();
        expectedOutput =
                "X| | \n" +
                        "-----\n" +
                        " |O| \n" +
                        "-----\n" +
                        " | |X\n";

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
                "X|O|X\n" +
                        "-----\n" +
                        "X|O|X\n" +
                        "-----\n" +
                        "X|O|X\n";

        assertNotEquals(notExpectedOutput, actualOutput.toString());

        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');

        actualOutput.reset();

        board.print();
        notExpectedOutput =
                "O| | \n" +
                        "-----\n" +
                        " |X| \n" +
                        "-----\n" +
                        " | |O\n";

        assertNotEquals(notExpectedOutput, actualOutput.toString());

        System.setOut(System.out);
    }
}


