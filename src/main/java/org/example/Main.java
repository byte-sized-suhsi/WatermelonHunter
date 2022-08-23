package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
    public static DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
    public static Terminal terminal = null;

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO: Terminalinitiering
        terminal = defaultTerminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        // TODO: do while för game loop
        //      läs input, rör spelare och monster

        Player player = new Player(10,10,10,10,'X');

        do {
            player.move();
        } while(true);
    }

    // TODO: Metod för att läsa input
    public static KeyStroke readUserInputType() throws IOException, InterruptedException {
        KeyStroke keyStroke = null;

        do {
            Thread.sleep(5);
            keyStroke = terminal.pollInput();
        } while(keyStroke == null);

        return keyStroke;
    }
}