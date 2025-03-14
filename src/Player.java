import java.awt.*;

public class Player {
    private static final int SIZE = 30;
    private static final Color COLOR = Color.RED;
    private int x, y;

    Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(COLOR);
//        int[] xPoints = {x, x + SIZE / 2, x + SIZE};
//        int[] yPoints = {y + SIZE, y, y + SIZE};
        int[] xPoints = {x, x - SIZE / 2, x + SIZE / 2};
        int[] yPoints = {y - SIZE / 2, y + SIZE / 2, y + SIZE / 2};
        g.fillPolygon(xPoints, yPoints, 3);
        }
    }
