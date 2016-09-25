package Pong;

import java.awt.*;

public class Paddle extends Thread {
    static final int WIDTH = 10;
    static final int HEIGHT = 100;
    
    int score = 0;
    
    int x, y;
    
    char direction = 's';
    
    public Paddle(int start_x, int start_y) {
        x = start_x;
        y = start_y;
    }
    
    @Override
    public void run() {
        while(true) {
            move();
            try {
                sleep(2);
            }
            catch(InterruptedException ex) {}
        }
    }
    
    public void move() {
        // If direction == down and the paddle isn't touching the bottom
        if(direction == 'd' && y + HEIGHT < Pong.HEIGHT) {
            y++;
        }
        // If direction == up and the paddle isn't touching the top
        if(direction == 'u' && y > 0) {
            y--;
        }
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
    
    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
