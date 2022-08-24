package org.example;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

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

    public void sendToAnotherQuadrant()
    {
        try {
            int xLength = TerminalHandler.terminal.getTerminalSize().getColumns();
            int yLength = TerminalHandler.terminal.getTerminalSize().getRows();

            /*  Kvadranter
                  1 | 2
                 -------
                  4 | 3
             */

            if(xLength/2 < this.x && yLength/2 < this.y)        // Första kvadranten
                ;//this.movePos(ThreadLocalRandom.current().nextInt(0, xLength/2);
            else if(xLength/2 > this.x && yLength/2 < this.y)    // Andra kvadranten
                ;
            else if(xLength/2 > this.x && yLength/2 > this.y)    // Tredje kvadranten
                ;
            else if(xLength/2 < this.x && yLength/2 > this.y)    // Fjärde kvadranten
                ;



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void movePos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    public abstract void move() throws IOException, InterruptedException;
}

