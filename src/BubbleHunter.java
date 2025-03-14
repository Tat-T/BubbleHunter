import javax.swing.*;
import java.awt.*;

public class BubbleHunter extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int SIZE = 30;
    private static final Color BACKGROUND_COLOR = new Color(173, 216, 230);
    private Canvas canvas;
    private  Player player;

    private boolean gameOver = false;

    public BubbleHunter() {
        setTitle("BubbleHunter");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initCanvas();
//        player = new Player(WIDTH / 2, HEIGHT / 2);
        player = new Player(WIDTH / 2 - SIZE / 2, HEIGHT / 2 - SIZE / 2);
        setVisible(true);
        startGameLoop();
    }

    private void initCanvas(){
        canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                player.draw(g);
            }
        };
        canvas.setBackground(BACKGROUND_COLOR);
        add(canvas);
    }

    private void startGameLoop() {
        new Thread(() -> {
            while (!gameOver) {
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

