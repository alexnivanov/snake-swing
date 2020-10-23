package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/start/HelloWorldSwingProject/src/start/HelloWorldSwing.java
 */
public class Launcher {

    public static void main(String[] args) {
        // This is our snake!
        final Snake snake = new Snake();

        final JFrame frame = new JFrame("SnakeSwing");

        // Schedule a job for the event-dispatching thread: creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI(frame, snake));

        new Thread(() -> {
            while (!snake.isCrashed()) {
                try {
                    Thread.sleep(300);

                    System.out.println("Tick!");

                    snake.tick();

                    SwingUtilities.invokeLater(() -> {
                        frame.repaint();
                        frame.revalidate();
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI(JFrame frame, Snake snake) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null); // center on the screen
        frame.add(new GraphicsPanel(snake));
        frame.setResizable(false);
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    snake.moveLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    snake.moveUp();
                }
                // TODO implement moveRight and moveDown
                // TODO implement restart on 'R'
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        frame.setVisible(true);
    }

}
