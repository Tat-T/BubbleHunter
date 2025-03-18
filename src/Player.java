import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private static final int SIZE = 30;
    private static final Color COLOR = Color.RED;
    private int x, y, speed;

    Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 5;
    }

    public void draw(Graphics g) {
        g.setColor(COLOR);
//        int[] xPoints = {x, x + SIZE / 2, x + SIZE};
//        int[] yPoints = {y + SIZE, y, y + SIZE};
        int[] xPoints = {x, x - SIZE / 2, x + SIZE / 2};
        int[] yPoints = {y - SIZE / 2, y + SIZE / 2, y + SIZE / 2};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    public void move(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT && x > SIZE / 2) {
            x -= speed;
        } else if (keyCode == KeyEvent.VK_RIGHT && x < BubbleHunter.WIDTH - SIZE / 2) {
            x += speed;
        } else if (keyCode == KeyEvent.VK_UP && y > SIZE / 2) {
            y -= speed;
        } else if (keyCode == KeyEvent.VK_DOWN && y < BubbleHunter.WIDTH - SIZE / 2) {
            y += speed;
        }
    }
}
