package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;


public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
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
    public void testSwitchCurrentPlayer() {

        assertEquals('X', game.currentPlayer.getMarker());

        game.switchCurrentPlayer();
        assertEquals('O', game.currentPlayer.getMarker());

        game.switchCurrentPlayer();
        assertEquals('X', game.currentPlayer.getMarker());
    }

    @Test
    public void testHasWinner() {

        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');

        assertTrue(game.hasWinner());

        game.board.clear();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');

        assertFalse(game.hasWinner());
    }


}



