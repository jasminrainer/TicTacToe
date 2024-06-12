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
            // Arrange
            game.board.place(0, 0, 'X');

            // Act
            char cellValue = game.board.getCells()[0][0];

            // Assert (this will fail because the expected value is intentionally wrong)
            assertNotEquals('O', cellValue);
        }
    }

