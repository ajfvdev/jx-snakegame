/*
 */

package snakegame;

import javafx.scene.shape.Rectangle;

/**
 * @author Alfredo Jose Flores Vargas
 */
public class Body extends Rectangle{
    
    private int posX, posY, oldPosX, oldPosY;
    
    private Body previous;
    
    public Body(int x, int y, Body prev){
        super(JxSnakegame.block_size, JxSnakegame.block_size);
        posX = x;
        posY = y;
        
        setTranslateX(posX * JxSnakegame.block_size);
        setTranslateY(posY * JxSnakegame.block_size);
        
    }

}
