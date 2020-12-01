package com.company;

import javax.swing.*;
import java.awt.*;

public class GraphicsPanel extends JPanel {

    public static final int FIELD_PARTS_NUM = 25;
    public static final int OFFSET = 10;

    private final Snake snake;

    public GraphicsPanel(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphic2d = (Graphics2D) g;

        // Black background
        graphic2d.setColor(Color.BLACK);
        graphic2d.fillRect(0, 0, getWidth(), getHeight());

        // Game area
        int fieldSize = getHeight() - 2 * OFFSET;

        graphic2d.setColor(Color.GREEN);
        graphic2d.drawRect(OFFSET, OFFSET, fieldSize, fieldSize);

        GameField gameField = new GameField(fieldSize);

        if (snake.isCrashed()) {
            drawGameOver(graphic2d, fieldSize);
        } else {
            for (SnakePart snakePart : snake.getParts()) {
                gameField.drawPart(graphic2d, snakePart);
            }
        }
    }

    private void drawGameOver(Graphics g, int fieldSize) {
        Font font1 = g.getFont().deriveFont(24f);
        Font font2 = g.getFont().deriveFont(17f);

        String line1 = "GAME OVER!";
        String line2 = "Press 'R' to restart";

        int center = OFFSET + fieldSize / 2;

        FontMetrics metrics1 = g.getFontMetrics(font1);
        FontMetrics metrics2 = g.getFontMetrics(font2);

        g.setFont(font1);
        g.drawString(line1, center - metrics1.stringWidth(line1) / 2, center - metrics1.getHeight() + metrics1.getAscent());
        g.setFont(font2);
        g.drawString(line2, center - metrics2.stringWidth(line2) / 2, center + metrics2.getAscent());
    }

}

