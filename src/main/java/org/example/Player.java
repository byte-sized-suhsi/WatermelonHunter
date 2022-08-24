package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class Player extends Movable
{


    private int lifeCounter;

    // Ändra oldX och oldY, kan egentligen bara initieras till x och y
    public Player(int x, int y, char symbol)
    {
        super(x, y, symbol);

        lifeCounter = 0;
    }

    public int getLifeCounter() {
        return lifeCounter;
    }

    public void  changeLife(int numberOfLifes)
    {
        lifeCounter += numberOfLifes;
    }

    public void setLifeCounter(int lifeCounter) {
        this.lifeCounter = lifeCounter;
    }

    @Override
    public void interact() {
        // do nothing
    }

    @Override
    public void move() throws IOException, InterruptedException
    {
        // TODO: förflytta spelaren
        KeyStroke keyStroke = Main.readUserInputType();
        KeyType type = keyStroke.getKeyType();
        String typeString = type.name();



        // Spara dom gamla x koordinaterna
        oldX = x;
        oldY = y;

        //
        switch(typeString)
        {
            case "ArrowUp" -> this.y-=2;           // y - 1
            case "ArrowDown" -> this.y+=2;         // y + 1
            case "ArrowRight" -> this.x+=2;        // x + 1
            case "ArrowLeft" -> this.x-=2;         // x - 1
        }

        // Skriver ut den nya karaktären
        TerminalHandler.terminal.setCursorPosition(x,y);
        TerminalHandler.terminal.putCharacter(symbol);

        // Tar bort den gamla karaktären
        TerminalHandler.terminal.setCursorPosition(oldX,oldY);
        TerminalHandler.terminal.putCharacter(' ');

        TerminalHandler.terminal.flush();
    }
}