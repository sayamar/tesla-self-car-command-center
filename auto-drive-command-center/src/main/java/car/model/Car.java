package car.model;

import car.enums.Direction;

public class Car {
    private String name;
    private int x; // x-coordinate on the grid
    private int y; // y-coordinate on the grid
    private Direction direction; // Enum to represent direction (North, South, East, West)

    private String commands;

    public Car(String name, int x, int y, Direction direction, String commands) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.commands = commands;
    }

    public void rotateLeft() {
        switch (direction) {
            case N:
                direction = Direction.W;
                break;
            case S:
                direction = Direction.E;
                break;
            case E:
                direction = Direction.N;
                break;
            case W:
                direction = Direction.S;
                break;
        }
        this.commands = this.commands.substring(1);
    }

    public void rotateRight() {
        switch (direction) {
            case N:
                direction = Direction.E;
                break;
            case S:
                direction = Direction.W;
                break;
            case E:
                direction = Direction.S;
                break;
            case W:
                direction = Direction.N;
                break;
        }
        this.commands = this.commands.substring(1);
    }

    public void moveForward() {
        switch (direction) {
            case N:
                y = Math.min(y + 1, Field.height - 1);
                break;
            case S:
                y = Math.max(y - 1, 0);
                break;
            case E:
                x = Math.min(x + 1, Field.width - 1);
                break;
            case W:
                x = Math.max(x - 1, 0);
                break;
        }
        this.commands = this.commands.substring(1);

    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getCommands() {
        return commands;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "- "+this.name+", ("+this.x+","+this.y+") "+direction;
    }
}
