package src.main.java;

public class Rover {
    private Coordinates location;
    private Direction direction;

    public Rover(Coordinates location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public void receiveCommands(String commands) {
        for (char command: commands.toCharArray()) {
            executeCommand(command);
        }
    }

    private void executeCommand(char command) {
        switch (command) {
            case 'f':
                location.move(direction);
                return;
            case 'b':
                location.move(direction.getBackwardDirection());
                return;
            case 'l':
                changeDirectionLeft();
                return;
            case 'r':
                changeDirectionRight();
                return;
            default:
                throw new IllegalArgumentException("command unrecognized");
        }
    }

    private void changeDirectionRight() {
        changeDirection(1);
    }

    private void changeDirectionLeft() {
        changeDirection(-1);
    }

    private void changeDirection(int i) {
        int len = Direction.values().length;
        direction = Direction.values()[(len + direction.getValue() + i) % len];
    }

    public Coordinates getLocation() {
        return location;
    }

    public Direction getDirection() {
        return direction;
    }
}