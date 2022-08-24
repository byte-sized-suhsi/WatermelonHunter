package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    //public static DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
    //public static Terminal terminal = null;
    public static Player player;

    public static void main(String[] args) throws IOException, InterruptedException {

        //region För testning
        player = new Player(30,10,'☕');
        Enemy enemy = new Enemy(29,11, Symbols.TRIANGLE_UP_POINTING_BLACK);
        Enemy enemy2 = new Enemy(30,10, Symbols.TRIANGLE_UP_POINTING_BLACK);
        Treasure treasure0 = new Treasure(31,11,'c');
        Treasure treasure1 = new Treasure(29,9,'c');
        ArrayList<PositionObject> positionObjects = new ArrayList<>();
        positionObjects.add(enemy);
        positionObjects.add(enemy2);
        positionObjects.add(treasure0);
        positionObjects.add(treasure1);
        //endregion

        TerminalHandler.terminal.setCursorPosition(0,0);
        TerminalHandler.printBox(5, 5, 40, 30, TextColor.ANSI.CYAN);
        TerminalHandler.printBox(70,5,25,40, TextColor.ANSI.GREEN);
        TerminalHandler.printBox(5,40,50,5, TextColor.ANSI.MAGENTA);
        TerminalHandler.printCircle(10,20,20, TextColor.ANSI.RED);

        // TODO: do while för game loop
        //      läs input, rör spelare och monster
        do {
            player.move();

            enemy.move();
            enemy2.move();
            treasure0.move();
            treasure1.move();

            // Checka om spelaren har stött på ett annat objekt
            for (int i = 0; i < positionObjects.size(); i++) {
                    if(player.x == positionObjects.get(i).x && player.y == positionObjects.get(i).y)
                    {
                        positionObjects.get(i).interact();
                        // TODO: om treasure, flytta till annan position

                        // TODO: om enemy, flytta enemy bort spelare
                    }
            }
        } while(true);
    }



    public static KeyStroke readUserInputType() throws IOException, InterruptedException {
        KeyStroke keyStroke = null;

        do {
            Thread.sleep(5);
            keyStroke = TerminalHandler.terminal.pollInput();
        } while(keyStroke == null);

        return keyStroke;
    }
}