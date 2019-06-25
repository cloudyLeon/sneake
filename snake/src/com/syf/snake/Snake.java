package com.syf.snake;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @ Author :cloudy
 * @ Date   :Created in 16:16 2019/6/18
 * @ Description:
 */
public class Snake {
    private Node head, tail;
    Dir dir=Dir.R;
    public Snake() {
        head = new Node(15,15);
        tail = head;
    }

    public void paint(Graphics g) {
        move();
        Node node = head;
        while (node != null) {
            if (node == head) {
                node.paint(g,Color.PINK);
            }else {
                node.paint(g, Color.BLACK);
            }
            node = node.getNext();
        }
    }

    private void move() {
        addToHead();
        removeFromTail();
        boundCheck();
    }

    private void boundCheck() {
        if (this.head.getCol() < 0) head.setCol(Yard.NODE_COUNT-1);
        if (this.head.getRow() < 0) head.setRow(Yard.NODE_COUNT-1);
        if (this.head.getCol() > Yard.NODE_COUNT-1) head.setCol(0);
        if (this.head.getRow() > Yard.NODE_COUNT-1) head.setRow(0);
    }

    public void addToHead() {
        Node node = null;
        switch (dir) {
            case U:
                node = new Node(head.getRow()-1, head.getCol());
                break;
            case D:
                node = new Node(head.getRow()+1, head.getCol());
                break;
            case L:
                node = new Node(head.getRow(), head.getCol()-1);
                break;
            case R:
                node = new Node(head.getRow(), head.getCol()+1);
                break;
        }
        head.setPrev(node);
        node.setNext(head);
        head = node;
    }

    public void removeFromTail() {
        tail = tail.getPrev();
        tail.getNext().setPrev(null);
        tail.setNext(null);
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_UP:
                this.dir=Dir.U;
                break;
            case KeyEvent.VK_DOWN:
                this.dir=Dir.D;
                break;
            case KeyEvent.VK_LEFT:
                this.dir=Dir.L;
                break;
            case KeyEvent.VK_RIGHT:
                this.dir=Dir.R;
                break;
                default:

        }
    }

    public void eat(Egg egg) {
        if (this.head.getRow() == egg.getRow() && this.head.getCol() == egg.getCol()){
            this.addToHead();
            egg.reAppear();
        }
    }
}
