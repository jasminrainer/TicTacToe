package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;


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


}



