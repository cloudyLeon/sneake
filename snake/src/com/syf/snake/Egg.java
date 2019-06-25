package com.syf.snake;

import java.awt.*;
import java.security.SecureRandom;

/**
 * @ Author :cloudy
 * @ Date   :Created in 17:02 2019/6/22
 * @ Description: 贪吃蛇可以吃的东东
 */
public class Egg {
    private int row;
    private int col;
    private SecureRandom random = new SecureRandom();

    public Egg(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void paint(Graphics g) {
        int x = Yard.x + this.col * Yard.NODE_SIZE;
        int y = Yard.y + this.row * Yard.NODE_SIZE;
        Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.fillOval(x, y, Yard.NODE_SIZE, Yard.NODE_SIZE);
        g.setColor(c);
    }

    public void reAppear() {
        this.row = random.nextInt(Yard.NODE_COUNT-1);
        this.col = random.nextInt(Yard.NODE_COUNT-1);
    }
}
