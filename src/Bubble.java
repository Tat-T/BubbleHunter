import java.awt.*;
import java.util.Random;

public class Bubble {
    private static final Color COLOR = Color.WHITE;
    private int x, y, size, speed;

    Bubble(int boardWidth, int boardHeight) {
        Random rand = new Random();
        this.size = 10 + rand.nextInt(20); // Размер пузыря (от 10 до 30)
        this.x = rand.nextInt(boardWidth); // Случайное положение по X
        this.y = boardHeight + this.size;  // Старт под экраном
        this.speed = 1 + rand.nextInt(4);  // Скорость (1-4 пикселя)
    }

    public void move() {
        this.y -= speed; // Двигаем пузырь вверх

        // Если пузырь выходит за верхнюю границу, перемещаем его вниз
        if (isOffScreen()) {
            resetPosition();
        }
    }

    public void draw(Graphics g) {
        g.setColor(COLOR);
        int r = this.size / 2;
        g.fillOval(x - r, y - r, size, size);
    }

    public boolean isOffScreen() {
        return y + size < 0;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getSize() {
        return size;
    }

    private void resetPosition() {
        this.y = BubbleHunter.HEIGHT + this.size; // Перемещаем под экран
        this.x = new Random().nextInt(BubbleHunter.WIDTH); // Новый X
    }
}