package org.example;

public abstract class PositionObject
{
    protected int x;
    protected int y;
    protected char symbol;


    public PositionObject(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public abstract void interact();
}
