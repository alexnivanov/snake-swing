package com.company;

import java.awt.*;

import static com.company.GraphicsPanel.FIELD_PARTS_NUM;
import static com.company.GraphicsPanel.OFFSET;

public class GameField {
    private final int partSize;

    GameField(int fieldSize) {
        partSize = fieldSize / FIELD_PARTS_NUM;
    }

    void drawPart(Graphics2D graphics2D, SnakePart snakePart) {
        graphics2D.drawRect(OFFSET + snakePart.x * partSize, OFFSET + snakePart.y * partSize, partSize, partSize);
    }

}
