package src.test.java;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import src.main.java.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    private static Point point;
    private static final int location = 2;
    private static final int maxLocation = 10;

    @BeforeAll
    public static void createPoint() {
        point = new Point(location, maxLocation);
    }

    @Test
    public void testPointValue() {
        assertEquals(location, point.getValue());
        assertEquals(maxLocation, point.getMaxValue());
    }

    @Test
    public void testMovement() {
        assertEquals(3, point.moveForward());
        assertEquals(1, point.moveBackward());
    }

}