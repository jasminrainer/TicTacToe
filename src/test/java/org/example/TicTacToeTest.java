package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TicTacToeTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testPlaceMarker() {

        game.board.place(0, 0, 'X');

        char cellValue = game.board.getCells()[0][0];

        assertEquals('X', cellValue);
    }

    @Test
    public void testPlaceMarkerIncorrect() {

        game.board.place(0, 0, 'X');

        char cellValue = game.board.getCells()[0][0];

        assertNotEquals('O', cellValue);
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
}



