package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player playerX;
    private Player playerO;

    @BeforeEach
    public void setUp() {
        playerX = new Player('X');
        playerO = new Player('O');
    }

    @Test
    public void testGetMarker() {
        assertEquals('X', playerX.getMarker());
        assertEquals('O', playerO.getMarker());
    }

    @Test
    public void testPlayerMarkersNotEqual() {
        assertNotEquals(playerX.getMarker(), playerO.getMarker());
    }
}