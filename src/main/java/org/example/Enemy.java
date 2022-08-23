package org.example;

public class Enemy extends Movable
{

    public Enemy(int oldX, int oldY, int x, int y, char symbol) {
        super(oldX, oldY, x, y, symbol);
    }

    @Override
    public void move() {
        /*
                Spelarens gamla position: x = 10
                Spelarens nya position: x = 12

                Monstrets position: x = 20

                    Röra sig ifrån:

                    randomtal mellan 0 och 1;
                    Om randomtal == 0
                        Om (monster.x - player.oldX > monster.x - player.currentX)
                            rör monstret ifrån spelaren
                            monster.x + 1
                        annars
                            monstret.x - 1
                    Om randomtal == 1
                        Rör sig i y.

         */


        // TODO: ändra monstrets hastighet beroende på om spelaren minskar eller ökar
    }
}
