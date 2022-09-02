package src.main.java;

public class Point {
    private int value;
    private int maxValue;

    public Point(int value, int maxValue) {
        this.value = value;
        this.maxValue = maxValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int moveForward() {
        return (value + 1) % (maxValue + 1);
    }

    public int moveBackward() {
        return value > 0 ? value - 1 : maxValue;
    }
}