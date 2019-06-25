package com.syf.snake;

public enum Dir {
    U(1),D(2),L(3),R(4);
    private int index;
    private Dir(int num) {
        this.index=num;
    }
}
