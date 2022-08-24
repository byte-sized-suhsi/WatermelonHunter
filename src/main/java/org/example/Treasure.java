package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Treasure extends Movable
{
    Player target = Main.player;
    public Treasure(int x, int y, char symbol) {
        super(x, y, symbol);
    }

    @Override
    public void interact()
    {
        // TODO: Lägg till liv för spelaren.


        // TODO: Printa ut på nåt sätt
    }


    @Override
    public void move() throws IOException {
        oldX = x;
        oldY = y;
        if(x > target.x){
            x +=1;
        } else if (x < target.x) {
            x -= 1;
        }if (y > target.y){
            y+=1;
        } else if (y < target.y) {
            y-=1;
        }
        boolean hasTreasure = x == target.x && y == target.y;
        if (hasTreasure){


        }


        TerminalHandler.terminal.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
        TerminalHandler.terminal.enableSGR(SGR.BOLD);
        TerminalHandler.terminal.setCursorPosition(x,y);
        TerminalHandler.terminal.putCharacter(symbol);

        //System.out.println("Current position, y: " + y + ", x: " + x);

        // Tar bort den gamla karaktären
        TerminalHandler.terminal.setCursorPosition(oldX,oldY);
        TerminalHandler.terminal.putCharacter(' ');

        TerminalHandler.terminal.flush();
        TerminalHandler.terminal.resetColorAndSGR();
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

