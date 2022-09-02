package src.test.java;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import src.main.java.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    private static Rover rover;
    private static Point x;
    private static Point y;
    private static Coordinates location;
    private static final Direction direction = Direction.NORTH;

    @BeforeAll
    public static void createRover() {
        x = new Point(2, 10);
        y = new Point(5, 10);
        location = new Coordinates(x, y, new ArrayList<>());
        rover = new Rover(location, direction);
    }

    @Test
    public void testRoverValues() {
        assertEquals(location.getX().getValue(), rover.getLocation().getX().getValue());
        assertEquals(location.getY().getValue(), rover.getLocation().getY().getValue());
        assertEquals(direction.getName(), rover.getDirection().getName());
        assertEquals(x.getMaxValue(), rover.getLocation().getX().getMaxValue());
        assertEquals(y.getMaxValue(), rover.getLocation().getY().getMaxValue());
    }

    @Test
    public void testRoverMove() {
        assertEquals(2, rover.getLocation().getX().getValue());
        assertEquals(5, rover.getLocation().getY().getValue());
        rover.receiveCommands("ffrflfflbb");
        assertEquals(5, rover.getLocation().getX().getValue());
        assertEquals(9, rover.getLocation().getY().getValue());
    }

    @Test
    public void testRoverMoveLedge() {
        assertEquals(5, rover.getLocation().getX().getValue());
        assertEquals(9, rover.getLocation().getY().getValue());
        rover.receiveCommands("fffrfflfffflbb");
        assertEquals(9, rover.getLocation().getX().getValue());
        assertEquals(2, rover.getLocation().getY().getValue());
    }

    @Test
    public void testRoverMoveObstacles() {
        Point newX = new Point(2, 10);
        Point newY = new Point(5, 10);
        Obstacle ob1 = new Obstacle(5, 5);
        Obstacle ob2 = new Obstacle(10,  5);
        Coordinates newCoord = new Coordinates(newX, newY, List.of(ob1, ob2));
        Rover newRover = new Rover(newCoord, Direction.NORTH);
        assertEquals(2, newRover.getLocation().getX().getValue());
        assertEquals(5, newRover.getLocation().getY().getValue());
        newRover.receiveCommands("rffffffrflfflfrffffffff");
        assertEquals(9, newRover.getLocation().getX().getValue());
        assertEquals(5, newRover.getLocation().getY().getValue());
    }
}