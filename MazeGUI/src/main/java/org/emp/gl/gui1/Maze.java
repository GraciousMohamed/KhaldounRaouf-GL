package org.emp.gl.gui1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.robot.RebotService;
import org.emp.gl.MazeService.ServiceMaze;
import org.emp.gl.timerservice.Observer;

/**
 *
 * @author raouf
 */
public class Maze extends JFrame implements ServiceMaze {

    private int[][] MazeMatrix
            = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

            };

    public Maze() {

        setTitle("Maze");
        setSize(600, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < MazeMatrix.length; row++) {
            for (int col = 0; col < MazeMatrix[0].length; col++) {

                Color color;
                switch (MazeMatrix[row][col]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    default:
                        color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(50 * col, 50 * row, 50, 50);
                g.setColor(Color.BLACK);
                g.drawRect(50 * col, 50 * row, 50, 50);

            }
        }

        RebotService r = Lookup.getLookup().get(RebotService.class);
        int X = r.geCoordonnée_X();
        int Y = r.geCoordonnée_Y();
        g.setColor(Color.GREEN);
        g.fillRect(X * 50, Y * 50, 48, 48);
        g.drawRect(X * 50, Y * 50, 48, 48);
    }

    @Override
    protected void processKeyEvent(KeyEvent ke) {

        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }

        switch (ke.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                Lookup.getLookup().get(RebotService.class
                ).goRight();
                repaint();
                break;
            case KeyEvent.VK_LEFT:
                Lookup.getLookup().get(RebotService.class
                ).goLeft();
                repaint();
                break;
            case KeyEvent.VK_DOWN:
                Lookup.getLookup().get(RebotService.class
                ).goDown();
                repaint();
                break;
            case KeyEvent.VK_UP:
                Lookup.getLookup().get(RebotService.class
                ).goUP();
                repaint();
                break;
            default:
                break;
        }

    }

    @Override
    public void OneSecondElapsed() {
        repaint();
    }

    @Override
    public boolean isObstacle(int j, int i) {
        if (MazeMatrix[i][j] == 0) {
            return false;
        }

        return true;
    }

}
