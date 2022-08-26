package org.example;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

public class TerminalHandler {
    private static DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
    public static Terminal terminal;

    static {
        try {
            int colnumnSize = 100;
            int rowsSize = 50;

            TerminalSize size = new TerminalSize(colnumnSize, rowsSize);
            defaultTerminalFactory.setInitialTerminalSize(size);

            terminal = terminal = defaultTerminalFactory.createTerminal();
            terminal.setCursorVisible(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private TerminalHandler() {}

    /***
     * Printar en rektangel till terminalen som består av Wall objekt vilket
     * blockar rörelsen av spelaren
     * @param columnOffset  x positionen för rektangelns övre vänstra hörn
     * @param rowOffset     y positionen för rektangelns övre vänstra hörn
     * @param width         rektangelns bredd
     * @param height        rektangelns höjd
     * @param textColor     färgen på cirkeln. Anges exempelvis TextColor.ANSI.RED vid metodanrop
     */
    public static ArrayList<Wall> printBox(int columnOffset, int rowOffset, int width, int height, char block, TextColor.ANSI textColor)
    {
        ArrayList<Wall> wallSegments = new ArrayList<>();

        try {
            terminal.setForegroundColor(textColor);

            //tak, horisontel
            for (int column = 0; column < width; column++) {
                wallSegments.add(new Wall(column + columnOffset, rowOffset, block, textColor));

                /*terminal.setCursorPosition(column + columnOffset, rowOffset);
                terminal.putCharacter(block);*/
            }
            terminal.flush();

            //Golvet,horisontel
            for (int column = 0; column < width; column++) {
                wallSegments.add(new Wall(column + columnOffset, height - 1 + rowOffset, block, textColor));

                /*terminal.setCursorPosition(column + columnOffset, height - 1 + rowOffset);
                terminal.putCharacter(block);*/
            }
            terminal.flush();

            // vertical vägg höger
            for (int row = 0; row < height; row++) {
                wallSegments.add(new Wall(columnOffset, row + rowOffset, block, textColor));

                /*terminal.setCursorPosition(columnOffset, row + rowOffset);
                terminal.putCharacter(block);*/
            }
            terminal.flush();

            //vänster
            for (int row = 0; row < height; row++) {
                wallSegments.add(new Wall(columnOffset + width, row + rowOffset, block, textColor));

                /*terminal.setCursorPosition(columnOffset + width, row + rowOffset);
                terminal.putCharacter(block);*/
            }
            terminal.flush();
            terminal.resetColorAndSGR();

            return wallSegments;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * Printar en cirkel till terminalen
     * @param radius    radien på cirkeln
     * @param xCenter   x koordinaten för cikelns mitt
     * @param yCenter   y koordinaten för cirkelns mitt
     * @param textColor färgen på cirkeln. Anges exempelvis TextColor.ANSI.RED vid metodanrop
     */
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

    public static void movingBoxLines(int startX, int startY, int boxLength, int boxHeight, int lineLength, int offset)
    {
        int xPos = 0;
        int yPos = 0;

        int circumference = 2*boxLength + 2*boxHeight;

        for (int i = 0; i < lineLength; i++) {
            int positionPointer = i + offset;
            positionPointer = positionPointer % circumference;

            if(positionPointer > 0 &&positionPointer < boxLength)
            {
                xPos = startX + positionPointer;
                yPos = startY;
            } else if(positionPointer > boxLength && positionPointer < boxLength + boxHeight)
            {
                positionPointer = positionPointer % boxLength;

                xPos = startX + boxLength - 1;
                yPos = startY + positionPointer;
            } else if(positionPointer > boxLength + boxHeight && positionPointer < 2*boxLength + boxHeight)
            {
                positionPointer = positionPointer % (boxLength + boxHeight);

                xPos = startX + boxLength - positionPointer;
                yPos = startY + boxHeight;
            } else if(positionPointer > 2*boxLength + boxHeight && positionPointer < circumference)
            {
                positionPointer = positionPointer % (2 * boxLength + boxHeight);

                xPos = startX + 1;
                yPos = startY + boxHeight - positionPointer;
            }

            try {
                terminal.setCursorPosition(xPos,yPos);
                terminal.putCharacter(Symbols.BLOCK_SOLID);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            terminal.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Under construction
    public static void rotatingCircle(int radius, int xCenter, int yCenter, int tailLength, int startDegree, char block, TextColor.ANSI textColor)
    {
        Wall[] positionArray = new Wall[tailLength];


        for (int i = 0; i < tailLength; i++) {
            positionArray[i] = new Wall((int)(xCenter + radius * Math.cos(startDegree + i*10)),
                                        (int)(yCenter + radius * Math.sin(startDegree + i*10)),
                                        Symbols.BLOCK_SOLID, textColor);
        }

        for (int angle = 0; angle < 360; angle++) {
            if(90 < angle && angle < 180)
                continue;

            //Sätt positionen
            double posX = xCenter + radius * Math.cos(angle);
            double posY = yCenter + radius * Math.sin(angle);

            try {
                terminal.setCursorPosition((int)posX,(int)posY);
                terminal.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            /*
            for (int i = positionArray.length - 1; i =< 0; i--) {

            }*/
        }
        try {
            terminal.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
