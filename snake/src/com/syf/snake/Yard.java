package com.syf.snake;

import java.awt.*;
import java.awt.event.*;

/**
 * @ Author :cloudy
 * @ Date   :Created in 15:17 2019/6/18
 * @ Description: 院墙（边界)
 */
public class Yard extends Frame {
    //格子大小
    public static final int NODE_SIZE = 30;
    //格子数量
    public static final int NODE_COUNT =10;
    public static final int AREA_SIZE = NODE_SIZE*NODE_COUNT;

    public static int x = AREA_SIZE/2;
    public static int y = AREA_SIZE/2;
    private Snake s = new Snake();
    private Egg egg = new Egg(9,9);
    public static void main(String[] args) {
        new Yard();
    }
    public Yard(){
        this.setSize(AREA_SIZE*2,AREA_SIZE*2);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                s.keyPressed(e);
            }
        });
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(c);
        for(int i=0;i<=NODE_COUNT;i++){
            g.drawLine(x, y+i*NODE_SIZE, x+AREA_SIZE, y+i*NODE_SIZE);
            g.drawLine(x+i*NODE_SIZE, y, x+i*NODE_SIZE, y+AREA_SIZE);
        }

        egg.paint(g);
        s.paint(g);
        s.eat(egg);
    }

    // double buffer
    Image offScreemImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreemImage == null){
            offScreemImage = this.createImage(this.getWidth(), this.getHeight());
        }
        Graphics goff = offScreemImage.getGraphics();
        paint(goff);
        g.drawImage(offScreemImage, 0, 0, null);
    }
}
