package org.example;

import java.io.IOException;

public abstract class Movable extends PositionObject
{
    protected int oldX;
    protected int oldY;

    public Movable(int x, int y, char symbol)
    {
        super(x, y, symbol);

        oldX = x;
        oldY = y;
    }

    public abstract void move() throws IOException, InterruptedException;
}

