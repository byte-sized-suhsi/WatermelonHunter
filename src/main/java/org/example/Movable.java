package org.example;

import java.io.IOException;

public abstract class Movable
{
    public Movable(int oldX, int oldY, int x, int y, char symbol) {
        this.oldX = oldX;
        this.oldY = oldY;
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    protected int oldX;
    protected int oldY;
    protected int x;
    protected int y;
    protected char symbol;

    public abstract void move() throws IOException, InterruptedException;
}
