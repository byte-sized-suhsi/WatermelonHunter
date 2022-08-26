package org.example;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Movable
{

    public Enemy(int x, int y, char symbol)
    {
        super(x, y, symbol);
    }

    @Override
    public void interact(Movable movable) {
        // TODO: Ta bort ett liv. I spelaren finns en check för att se ifall livet är slut.
        //Main.player.changeLife(-1);
        if(movable instanceof Player)
        {
            System.out.println("NOM! Loose a life!");
            Main.player.changeLife(-1);
        }
    }

    @Override
    public void move() throws IOException {
        // TODO: Implementera move
        boolean enemyIsRightOfPlayer = this.x > Main.player.x;
        boolean enemyIsAbovePlayer = this.y < Main.player.y;

        // TODO: Ta bort?
        /*
        boolean playerMovedRight = Main.player.x > Main.player.oldX;
        boolean playerMovedUp = Main.player.y > Main.player.oldY;*/

        // Jämför avståndet före och efter att spelaren flyttade sig förra gången
        double distanceToEnemyBefore = Math.sqrt(Math.pow(this.x - Main.player.oldX,2) + Math.pow(this.y - Main.player.oldY,2));
        double distanceToEnemyAfter = Math.sqrt(Math.pow(this.x - Main.player.x,2) + Math.pow(this.y - Main.player.y,2));
        boolean movedCloser = distanceToEnemyAfter < distanceToEnemyBefore;
        //System.out.printf("\nbefore: %f, after: %f, distance moved: %f\n", distanceToEnemyBefore, distanceToEnemyAfter, distanceToEnemyAfter - distanceToEnemyBefore);

        oldX = x;
        oldY = y;

        if (movedCloser) {
            this.x = enemyIsRightOfPlayer ? x+1 : x-1;
            this.y = enemyIsAbovePlayer ? y-1 : y+1;
        } else {
            this.x = enemyIsRightOfPlayer ? x-1 : x+1;
            this.y = enemyIsAbovePlayer ? y+1 : y-1;
        }

        TerminalHandler.terminal.setCursorPosition(x,y);
        TerminalHandler.terminal.putCharacter(symbol);

        TerminalHandler.terminal.setCursorPosition(oldX,oldY);
        TerminalHandler.terminal.putCharacter(' ');


        // TODO: ändra monstrets hastighet beroende på om spelaren minskar eller ökar
    }
}
