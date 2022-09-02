package src.test.java;

import org.junit.jupiter.api.Test;
import src.main.java.Obstacle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ObstacleTest {

    @Test
    public void testObstacleLocation() {
        Obstacle obstacle = new Obstacle(2,5);
        assertEquals(2, obstacle.getX());
        assertEquals(5, obstacle.getY());
        assertNotEquals(5, obstacle.getX());
        assertNotEquals(2, obstacle.getY());
    }
}
