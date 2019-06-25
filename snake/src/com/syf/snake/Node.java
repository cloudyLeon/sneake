package com.syf.snake;

import java.awt.*;

/**
 * @ Author :cloudy
 * @ Date   :Created in 16:23 2019/6/18
 * @ Description:
 */
public class Node {
    private int row;
    private int col;
    private Node next, prev;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
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

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void paint(Graphics g, Color color) {
        int x = Yard.x + this.col * Yard.NODE_SIZE;
        int y = Yard.y + this.row * Yard.NODE_SIZE;
        Color c = g.getColor();
        g.setColor(color);
        g.fillRect(x, y, Yard.NODE_SIZE, Yard.NODE_SIZE);
        g.setColor(c);
    }
}
