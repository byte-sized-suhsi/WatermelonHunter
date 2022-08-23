package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class Player extends Movable
{
    @Override
    public void move() throws IOException, InterruptedException {
        // TODO: förflytta spelaren
        KeyStroke keyStroke = Main.readUserInputType();
        KeyType type = keyStroke.getKeyType();
        String typeString = type.name();

        /*
        switch(type)
        {
            case "ArrowUp":
                break;

        }*/
    }
}