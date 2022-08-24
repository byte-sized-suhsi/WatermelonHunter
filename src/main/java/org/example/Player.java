package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class Player extends Movable
{
    // Ändra oldX och oldY, kan egentligen bara initieras till x och y
    public Player(int x, int y, char symbol)
    {
        super(x, y, symbol);
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
            case "ArrowUp" -> this.y--;           // y - 1
            case "ArrowDown" -> this.y++;         // y + 1
            case "ArrowRight" -> this.x++;        // x + 1
            case "ArrowLeft" -> this.x--;         // x - 1
        }

        // Skriver ut den nya karaktären
        Main.terminal.setCursorPosition(x,y);
        Main.terminal.putCharacter(symbol);

        // Tar bort den gamla karaktären
        Main.terminal.setCursorPosition(oldX,oldY);
        Main.terminal.putCharacter(' ');

        Main.terminal.flush();
    }
}