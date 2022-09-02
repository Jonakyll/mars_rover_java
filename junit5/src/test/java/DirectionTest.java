package src.test.java;

import org.junit.jupiter.api.Test;
import src.main.java.Direction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {

    @Test
    public void allDirectionsIndex() {
        assertEquals(0, Direction.NORTH.getValue());
        assertEquals(1, Direction.EAST.getValue());
        assertEquals(2, Direction.SOUTH.getValue());
        assertEquals(3, Direction.WEST.getValue());
    }

    @Test
    public void allDirectionsValue() {
        assertEquals('N', Direction.NORTH.getName());
        assertEquals('E', Direction.EAST.getName());
        assertEquals('S', Direction.SOUTH.getName());
        assertEquals('W', Direction.WEST.getName());
    }

    @Test
    public void allDirectionsBackward() {
        assertEquals('S', Direction.NORTH.getBackwardDirection().getName());
        assertEquals('W', Direction.EAST.getBackwardDirection().getName());
        assertEquals('N', Direction.SOUTH.getBackwardDirection().getName());
        assertEquals('E', Direction.WEST.getBackwardDirection().getName());
    }
}
