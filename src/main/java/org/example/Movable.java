package org.example;

import java.io.IOException;

public abstract class Movable extends PositionObject
{
    protected int oldX;
    protected int oldY;

    public Movable(int oldX, int oldY, int x, int y, char symbol)
    {
        super(x, y, symbol);
        this.oldX = oldX;
        this.oldY = oldY;
    }


    public abstract void move() throws IOException, InterruptedException;
}
