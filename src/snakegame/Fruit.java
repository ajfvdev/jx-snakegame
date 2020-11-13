/*
 */

package snakegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Fruit extends Rectangle{
    
    int posX, posY;
    
    public Fruit(int x, int y) {
        super(JxSnakegame.BLOCK_SIZE, JxSnakegame.BLOCK_SIZE);
        posX = x;
        posY = y;
        setTranslateX(posX * JxSnakegame.BLOCK_SIZE);
        setTranslateY(posY * JxSnakegame.BLOCK_SIZE);

        setFill(Color.LIGHTBLUE);
        setStroke(Color.BLUE);
        
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    

}
