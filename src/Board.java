import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;

public class Board extends JPanel {
    private final Player player;
    private final List<Bubble> bubbles;
    private static final int BUBBLE_COUNT = 10;
    private int score = 0;

    Board() {
        this.player = new Player(
                BubbleHunter.WIDTH / 2,
                BubbleHunter.HEIGHT / 2);
        this.bubbles = new ArrayList<>();

        for (int i = 0; i < BUBBLE_COUNT; i++) {
            bubbles.add(new Bubble(BubbleHunter.WIDTH, BubbleHunter.HEIGHT));
        }

        setFocusable(true); // Делаем панель активной для клавиатуры
        requestFocusInWindow(); // Запрашиваем фокус

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                player.move(e.getKeyCode());
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        Timer timer = new Timer(10, e -> update());
        timer.start();
    }

    private void update() {

        Iterator<Bubble> iter = bubbles.iterator();
        while (iter.hasNext()) {
            Bubble bubble = iter.next();
            bubble.move();
            // Проверяем столкновение с игроком
            if (player.intersects(bubble)) {
                iter.remove(); // Удаляем пузырь
                score++;
                continue; // Переходим к следующему
            }
            if (bubble.isOffScreen()) {
                iter.remove();
                bubbles.add(new Bubble(BubbleHunter.WIDTH, BubbleHunter.HEIGHT));
            }
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        for (Bubble bubble : bubbles) {
            bubble.draw(g);
        }

         // Рисуем счёт
         drawScore(g);
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Счёт: " + score, 20, 40); // Позиция счёта на экране
    }
}
