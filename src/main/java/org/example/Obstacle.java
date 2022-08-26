package org.example;

import java.io.IOException;

public abstract class Obstacle extends PositionObject
{
    public Obstacle(int x, int y, char symbol)
    {
        super(x, y, symbol);

        try {
            TerminalHandler.terminal.setCursorPosition(this.x,this.y);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}