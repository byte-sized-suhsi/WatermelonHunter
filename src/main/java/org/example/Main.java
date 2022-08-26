package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
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
    private static ArrayList<Obstacle> obstacles = new ArrayList<>();
    private  static ArrayList<PositionObject> posObjects = new ArrayList<>();
    private static ArrayList<Movable> movables = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {

        // TODO: Städa upp testningen
        // TODO: Välj en slutgiltig symbol för spelaren
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

        obstacles.addAll(TerminalHandler.printBox(5, 5, 80, 40, Symbols.BLOCK_SOLID, TextColor.ANSI.GREEN));
        obstacles.addAll(TerminalHandler.printBox(87,5,25,5,Symbols.SINGLE_LINE_CROSS,TextColor.ANSI.RED));
        obstacles.addAll(TerminalHandler.printBox(30, 20, 0, 10, Symbols.BOLD_FROM_NORMAL_SINGLE_LINE_VERTICAL, TextColor.ANSI.WHITE_BRIGHT));
        obstacles.addAll(TerminalHandler.printBox(55, 15, 0, 6, Symbols.BOLD_FROM_NORMAL_SINGLE_LINE_VERTICAL, TextColor.ANSI.WHITE_BRIGHT));
        obstacles.addAll(TerminalHandler.printBox(45, 35, 7, 1, Symbols.BOLD_FROM_NORMAL_SINGLE_LINE_HORIZONTAL, TextColor.ANSI.WHITE_BRIGHT));
        obstacles.addAll(TerminalHandler.printBox(8, 30, 6, 1, Symbols.BOLD_FROM_NORMAL_SINGLE_LINE_HORIZONTAL, TextColor.ANSI.WHITE_BRIGHT));
        obstacles.addAll(TerminalHandler.printBox(60, 10, 4, 1, Symbols.BOLD_FROM_NORMAL_SINGLE_LINE_HORIZONTAL, TextColor.ANSI.WHITE_BRIGHT));
        obstacles.addAll(TerminalHandler.printBox(8, 30, 8, 1, Symbols.BOLD_FROM_NORMAL_SINGLE_LINE_HORIZONTAL, TextColor.ANSI.WHITE_BRIGHT));
        obstacles.addAll(TerminalHandler.printBox(11, 13, 8, 1, Symbols.BOLD_FROM_NORMAL_SINGLE_LINE_HORIZONTAL, TextColor.ANSI.WHITE_BRIGHT));
        obstacles.addAll(TerminalHandler.printBox(70, 30, 0, 7, Symbols.BOLD_FROM_NORMAL_SINGLE_LINE_VERTICAL, TextColor.ANSI.WHITE_BRIGHT));

        movables.add(player);
        movables.add(enemy);
        movables.add(enemy2);
        movables.add(treasure0);
        movables.add(treasure1);

        posObjects.addAll(movables);
        posObjects.addAll(obstacles);

        //TerminalHandler.movingBoxLines(10,10,40,10,10,0);

        //TerminalHandler.terminal.setCursorPosition(0,0);


        do {
            for (Movable movable : movables) {
                movable.move();

                for (PositionObject posObject : posObjects) {
                    if (movable.x == posObject.x && movable.y == posObject.y)
                    {
                        posObject.interact(movable);
                    }
                }
            }
        } while(true);
    }


    public static KeyStroke readUserInputType() throws IOException, InterruptedException
    {
        KeyStroke keyStroke = null;

        do {
            Thread.sleep(5);
            keyStroke = TerminalHandler.terminal.pollInput();
        } while(keyStroke == null);

        return keyStroke;
    }

    public static KeyStroke readUserInputParallell() throws IOException, InterruptedException
    {
        int index = 0;
        int boxLineOffset = 0;
        KeyStroke keyStroke = null;

        do {
            index++;
            if (index % 100 == 0) {
                // Pseudoparallell kod här
                TerminalHandler.movingBoxLines(10,10,40,10,20,boxLineOffset);
                TerminalHandler.movingBoxLines(10,10,40,10,20,30 +boxLineOffset);

                movables.get(2).move();

                boxLineOffset++;
                /*if (!continueReadingInput) {
                    terminal.close();
                    break;
                }*/
            }
            Thread.sleep(5); // might throw InterruptedException
            keyStroke = TerminalHandler.terminal.pollInput();
        }
        while (keyStroke == null);

        return keyStroke;


        /*
        int index = 0;
        int offset = 0;
        boolean continueReadingInput = true;

        while(continueReadingInput)
        {
            KeyStroke keyStroke = null;

            do {
                index++;
                if(index % 100 == 0)
                {
                    // Parallell stuff goes here
                    TerminalHandler.movingBoxLines(10,10,40,10,10,offset);
                }
            } while(keyStroke == null);
        }

        KeyStroke keyStroke = null;

        do {
            Thread.sleep(5);
            keyStroke = TerminalHandler.terminal.pollInput();
        } while(keyStroke == null);

        return keyStroke;*/
    }
}