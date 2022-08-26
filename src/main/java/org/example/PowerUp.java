package org.example;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class PowerUp extends Movable
{
    public PowerUp(int x, int y, char symbol) {
        super(x, y, symbol);
    }

    @Override
    public void move()
    {
        int boundedRandomValueX = ThreadLocalRandom.current().nextInt(-1, 1);
        int boundedRandomValueY = ThreadLocalRandom.current().nextInt(-1, 1);

        oldX = x;
        oldY = y;

        this.x += boundedRandomValueX;
        this.y += boundedRandomValueY;

        // Draw player
        try {
            TerminalHandler.terminal.setCursorPosition(this.oldX, this.oldY);
            TerminalHandler.terminal.putCharacter(' ');
            TerminalHandler.terminal.setCursorPosition(x, y);
            TerminalHandler.terminal.putCharacter('\u263a');
            TerminalHandler.terminal.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void interact(Movable object) {
        //System.out.println("Did something!");
    }
}
