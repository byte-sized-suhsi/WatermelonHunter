package org.example;

import java.io.IOException;

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void interact(Movable object) throws IOException;

    public void printToTerminal()
    {
        try {
            TerminalHandler.terminal.setCursorPosition(x,y);
            TerminalHandler.terminal.putCharacter(symbol);

            TerminalHandler.terminal.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
