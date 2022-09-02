package src.test.java;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import src.main.java.Coordinates;
import src.main.java.Direction;
import src.main.java.Point;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinatesTest {
    private static Coordinates coordinates;
    private static final Point x = new Point(2, 10);
    private static final Point y = new Point(5, 10);

    @BeforeAll
    public static void createCoordinates() {
        coordinates = new Coordinates(x, y, new ArrayList<>());
    }

    @Test
    public void testCoordinatesValue() {
        assertEquals(x.getValue(), coordinates.getX().getValue());
        assertEquals(y.getValue(), coordinates.getY().getValue());
    }

    @Test
    public void testCoordinatesMaxValues() {
        assertEquals(x.getMaxValue(), coordinates.getX().getMaxValue());
        assertEquals(y.getMaxValue(), coordinates.getY().getMaxValue());
    }

    @Test
    public void testCoordinatesMove() {
        coordinates.move(Direction.EAST);
        assertEquals(3, coordinates.getX().getValue());
        coordinates.move(Direction.NORTH);
        assertEquals(6, coordinates.getY().getValue());
        coordinates.move(Direction.SOUTH);
        assertEquals(5, coordinates.getY().getValue());
        coordinates.move(Direction.WEST);
        assertEquals(2, coordinates.getX().getValue());
    }
    @Test
    public void testCoordinatesMoveToLedge() {
        coordinates.getX().setValue(0);
        coordinates.getY().setValue(0);
        coordinates.move(Direction.SOUTH);
        assertEquals(coordinates.getY().getMaxValue(), coordinates.getY().getValue());
        coordinates.move(Direction.WEST);
        assertEquals(coordinates.getX().getMaxValue(), coordinates.getX().getValue());
    }
}