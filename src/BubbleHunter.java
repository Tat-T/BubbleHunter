import javax.swing.*;
import java.awt.*;

public class BubbleHunter extends JFrame {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    private static final int SIZE = 30;
    private static final Color BACKGROUND_COLOR = new Color(173, 216, 230);
    private Board board;

    private boolean gameOver = false;

    public BubbleHunter() {
        setTitle("BubbleHunter");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initBoard();
//        player = new Player(WIDTH / 2, HEIGHT / 2);
        setVisible(true);
        startGameLoop();
    }

    private void initBoard() {
        board = new Board();
         board.setBackground(BACKGROUND_COLOR);
         add(board);
        }

        private void startGameLoop () {
            new Thread(() -> {
                while (!gameOver) {
                    try {
                        board.repaint();
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

