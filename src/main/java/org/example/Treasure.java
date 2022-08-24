package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Treasure extends Movable
{


    Player target;
    public Treasure(int oldX, int oldY, int x, int y, char symbol,Player target) {
        super(oldX, oldY, x, y, symbol);
        this.target = target;
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


        Main.terminal.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
        Main.terminal.enableSGR(SGR.BOLD);
        Main.terminal.setCursorPosition(x,y);
        Main.terminal.putCharacter(symbol);

        //System.out.println("Current position, y: " + y + ", x: " + x);

        // Tar bort den gamla karaktären
        Main.terminal.setCursorPosition(oldX,oldY);
        Main.terminal.putCharacter(' ');

        Main.terminal.flush();
        Main.terminal.resetColorAndSGR();
    }

}
//x/y axel obsacle tanken
//implementera en scoreboard
//+1 på "liv"
// TODO: Fly från spelaren.
// Om treasure.x > player.x
//        så treasure.x + 1
// Annars: treasure.y -1

//Randomisera nuvarande lösning?


// TODO: Check för att se om man stöter på en vägg eller ett hörn