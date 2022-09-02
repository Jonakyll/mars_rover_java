package src.main.java;

import java.util.List;

public class Coordinates {
    private Point x;
    private Point y;

    private List<Obstacle> obstacles;

    public Coordinates(Point x, Point y, List<Obstacle> obstacles) {
        this.x = x;
        this.y = y;
        this.obstacles = obstacles;
    }

    public void move(Direction direction) {
        int dx = x.getValue();
        int dy = y.getValue();
        switch (direction) {
            case NORTH:
                dy = y.moveForward();
                break;
            case EAST:
                dx = x.moveForward();
                break;
            case SOUTH:
                dy = y.moveBackward();
                break;
            case WEST:
                dx = x.moveBackward();
                break;
        }
        if (!hasObstacle(dx, dy)) {
            x.setValue(dx);
            y.setValue(dy);
        }
    }

    private boolean hasObstacle(int dx, int dy) {
        for (Obstacle obstacle: obstacles) {
            if (obstacle.getX() == dx && obstacle.getY() == dy) {
                return true;
            }
        }
        return false;
    }

    public Point getX() {
        return x;
    }

    public Point getY() {
        return y;
    }
}