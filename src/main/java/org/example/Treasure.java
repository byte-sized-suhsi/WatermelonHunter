package org.example;

public class Treasure extends Movable
{

    public Treasure(int oldX, int oldY, int x, int y, char symbol) {
        super(oldX, oldY, x, y, symbol);
    }

    @Override
    public void move()
    {
        // TODO: Fly från spelaren.
        // Om treasure.x > player.x
        //        så treasure.x + 1
        // Annars: treasure.y -1

        // TODO: Check för att se om man stöter på en vägg eller ett hörn
    }
}
