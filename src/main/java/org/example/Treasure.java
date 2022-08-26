package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Treasure extends Movable
{
    private int heartCount;
    Player target = Main.player;
    public int getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(int heartCount) {
        this.heartCount = heartCount;
    }

    public Treasure(int x, int y, char symbol) {
        super(x, y, symbol);
    }


    @Override
    public void interact(Movable movable)
    {
        // TODO: Lägg till liv för spelaren.

        if(movable instanceof Player)
            Main.player.changeLife(1);

        // TODO: Printa ut på nåt sätt
        //

    }

    @Override
    public void move() throws IOException {
        oldX = x;
        oldY = y;
        if (x > target.x) {
            x += 1;
        } else if (x < target.x) {
            x -= 1;
        }
        if (y > target.y) {
            y += 1;
        } else if (y < target.y) {
            y -= 1;
        }

        for (int row = 0; row < Main.player.getLifeCounter();row++)
        {
            //uppdatera cursor pos när DU FLYTTAR NÅGOT, Okej jätte bra.
            TerminalHandler.terminal.setCursorPosition(50 + row,50);
            //TerminalHandler.terminal.setCursorPosition(heartCount,70);
            TerminalHandler.terminal.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
            TerminalHandler.terminal.enableSGR(SGR.BOLD);
            TerminalHandler.terminal.putCharacter(Symbols.HEART);
            TerminalHandler.terminal.flush();
        }
        /*
        boolean hasTreasure = x == target.x && y == target.y;
        //när spelaren nått treasure, lägg till hjärtan i heartcount.
        if (hasTreasure) {
            //heartCount++;
            System.out.println("counting" + Main.player.getLifeCounter());
        }if (hasTreasure && Main.player.getLifeCounter() <= 3)

            for (int row = 0; row < Main.player.getLifeCounter();row++)
            {
                //uppdatera cursor pos när DU FLYTTAR NÅGOT, Okej jätte bra.
                TerminalHandler.terminal.setCursorPosition(90 + row,6);
                //TerminalHandler.terminal.setCursorPosition(heartCount,70);
                TerminalHandler.terminal.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
                TerminalHandler.terminal.enableSGR(SGR.BOLD);
                TerminalHandler.terminal.putCharacter(Symbols.HEART);
            }




        TerminalHandler.terminal.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
        TerminalHandler.terminal.enableSGR(SGR.BOLD);
        TerminalHandler.terminal.setCursorPosition(x, y);
        TerminalHandler.terminal.putCharacter(symbol);

            //System.out.println("Current position, y: " + y + ", x: " + x);

            // Tar bort den gamla karaktären
        TerminalHandler.terminal.setCursorPosition(oldX, oldY);
        TerminalHandler.terminal.putCharacter(' ');

        TerminalHandler.terminal.flush();
        TerminalHandler.terminal.resetColorAndSGR();*/
    }
}


//x/y axel obsacle tanken
//implementera en scoreboard
//+1 på "liv"
// TODO: Fly från spelaren.
// Om treasure.x > player.x
//        så treasure.x + 1
// Annars: treasure.y -1

        // TODO: Check för att se om man stöter på en vägg eller ett hörn

