package org.example;

import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public class Wall extends Obstacle
{
    private TextColor color;

    public Wall(int x, int y, char symbol, TextColor color) {
        super(x, y, symbol);

        this.color = color;
        printOutWall();
    }

    @Override
    public void interact(Movable movable)
    {
        //movable.updateOldPosistion();
        movable.setX(movable.oldX);
        movable.setY(movable.oldY);

        movable.printToTerminal();

        printOutWall();
    }

    private void printOutWall()
    {
        try {
            TerminalHandler.terminal.setForegroundColor(color);

            TerminalHandler.terminal.setCursorPosition(x,y);
            TerminalHandler.terminal.putCharacter(symbol);

            TerminalHandler.terminal.resetColorAndSGR();
            TerminalHandler.terminal.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
