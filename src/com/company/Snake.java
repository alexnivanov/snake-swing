package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.GraphicsPanel.FIELD_PARTS_NUM;

public class Snake {

    // Our snake starts with 3 parts
    private static final int INIT_SIZE = 3;

    private final List<SnakePart> parts = new ArrayList<>();
    private boolean crashed = false;
    private SnakeDirection direction = SnakeDirection.RIGHT;

    public Snake() {
        for (int i = 0; i < INIT_SIZE; ++i) {
            parts.add(new SnakePart(FIELD_PARTS_NUM / 2 + i, FIELD_PARTS_NUM / 2));
        }
    }

    public synchronized void tick() {
        for (int i = 0; i < parts.size(); ++i) {
            // FIXME it will only move snake horizontally!
            SnakePart snakePart = parts.get(i);

            snakePart.x += 1;

            if (snakePart.x == FIELD_PARTS_NUM) {
                System.out.println("Snake crashed!");
                crashed = true;
                break;
            }
        }
    }

    public synchronized void moveLeft() {
        for (int i = 0; i < parts.size(); ++i) {
            // FIXME implement correct movement
            SnakePart snakePart = parts.get(i);

            snakePart.x -= 1;
        }
    }

    public synchronized void moveUp() {
        for (int i = 0; i < parts.size(); ++i) {
            // FIXME implement correct movement
            SnakePart snakePart = parts.get(i);

            snakePart.y -= 1;
        }
    }

    public synchronized List<SnakePart> getParts() {
        return parts;
    }

    public synchronized boolean isCrashed() {
        return crashed;
    }

}

class SnakePart {
    int x;
    int y;

    SnakePart(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

enum SnakeDirection {
    LEFT, RIGHT, UP, DOWN;
}