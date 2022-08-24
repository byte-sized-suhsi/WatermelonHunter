package org.example;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.w3c.dom.Text;

import java.io.IOException;

public class TerminalHandler {
    private static DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
    public static Terminal terminal;

    static {
        try {
            int colnumnsSize = 100;
            int rowsSize = 50;

            TerminalSize size = new TerminalSize(colnumnsSize, rowsSize);
            defaultTerminalFactory.setInitialTerminalSize(size);

            terminal = terminal = defaultTerminalFactory.createTerminal();
            terminal.setCursorVisible(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private TerminalHandler() {
    }

    ;


    public static void printBox(int columnOffset, int rowOffset, int width, int height, TextColor.ANSI textColor) {

        try {
            final char block = Symbols.BLOCK_SOLID;
            terminal.setForegroundColor(textColor);

            //tak, horisontel
            for (int column = 0; column < width; column++) {
                terminal.setCursorPosition(column + columnOffset, rowOffset);
                terminal.putCharacter(block);
            }
            terminal.flush();

            //Golvet,horisontel
            for (int column = 0; column < width; column++) {
                terminal.setCursorPosition(column + columnOffset, height - 1 + rowOffset);
                terminal.putCharacter(block);
            }
            terminal.flush();

            // vertical vägg höger
            for (int row = 0; row < height; row++) {
                terminal.setCursorPosition(columnOffset, row + rowOffset);
                terminal.putCharacter(block);
            }
            terminal.flush();

            //vänster
            for (int row = 0; row < height; row++) {
                terminal.setCursorPosition(columnOffset + width, row + rowOffset);
                terminal.putCharacter(block);
            }
            terminal.flush();
            terminal.resetColorAndSGR();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printCircle(int radius, int xCenter, int yCenter, TextColor.ANSI textColor) {
        try {
            final char block = Symbols.BLOCK_SOLID;
            terminal.setForegroundColor(textColor);

            for (int angle = 0; angle <= 360; angle++) {
                double posX = xCenter + radius * Math.cos(angle);
                double posY = yCenter + radius * Math.sin(angle);

                System.out.println("Circle x: " + posX + ", circle y: " + posY);

                terminal.setCursorPosition((int) posX, (int) posY);
                terminal.putCharacter(block);
            }
            terminal.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
