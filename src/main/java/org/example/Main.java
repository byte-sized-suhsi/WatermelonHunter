package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
    public static DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
    public static Terminal terminal = null;
    public static Player player;

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO: Terminalinitiering
        terminal = defaultTerminalFactory.createTerminal();
        terminal.setCursorVisible(false);


        char c = '☕';

        player = new Player(30,10,'☕');
        Enemy enemy = new Enemy(30+20,10, Symbols.TRIANGLE_UP_POINTING_BLACK);
        Enemy enemy2 = new Enemy(30-20,10, Symbols.TRIANGLE_UP_POINTING_BLACK);
        Enemy enemy3 = new Enemy(30,10+8, Symbols.TRIANGLE_UP_POINTING_BLACK);
        Enemy enemy4 = new Enemy(30,10-8, Symbols.TRIANGLE_UP_POINTING_BLACK);


        // TODO: do while för game loop
        //      läs input, rör spelare och monster
        do {
            terminal.enableSGR(SGR.BOLD);
            player.move();
            terminal.setForegroundColor(TextColor.ANSI.BLUE);
            enemy.move();
            enemy2.move();
            enemy3.move();
            enemy4.move();
            terminal.resetColorAndSGR();
        } while(true);
    }

    public static KeyStroke readUserInputType() throws IOException, InterruptedException {
        KeyStroke keyStroke = null;

        do {
            Thread.sleep(5);
            keyStroke = terminal.pollInput();
        } while(keyStroke == null);

        return keyStroke;
    }
}