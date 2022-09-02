package src.main.java;

public enum Direction {
    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');

    private int value;
    private char name;

    Direction(int value, char name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public char getName() {
        return name;
    }

    public Direction getBackwardDirection() {
        return values()[(this.getValue() + 2) % 4];
    }
}