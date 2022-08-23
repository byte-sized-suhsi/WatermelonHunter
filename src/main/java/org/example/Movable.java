package org.example;

import java.io.IOException;

public abstract class Movable
{
    protected int x;
    protected int y;

    public abstract void move() throws IOException, InterruptedException;
}
