/*
 */
package snakegame;

import javafx.scene.shape.Rectangle;

/**
 * @author Alfredo Jose Flores Vargas
 */
public class Body extends Rectangle {

    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

    private int posX, posY, oldPosX, oldPosY;

    private Body previous;

    int direction = LEFT; // move
    int maxX, maxY;

    public Body(int x, int y, Body prev, Camp c) {
        super(JxSnakegame.BLOCK_SIZE, JxSnakegame.BLOCK_SIZE);
        posX = x;
        posY = y;
        setTranslateX(posX * JxSnakegame.BLOCK_SIZE);
        setTranslateY(posY * JxSnakegame.BLOCK_SIZE);
        previous = prev;
        maxX = c.getPane_w();
        maxY = c.getPane_h();
    }

    public void update() {
        
        oldPosX = posX; // This way it just move right.
        oldPosY = posY;
        
        if (previous == null) { // if we are in head.
            switch (direction) {
                case UP:
                    moveUP();
                    break;
                case RIGHT:
                    moveRIGHT();
                    break;
                case DOWN:
                    moveDOWN();
                    break;
                case LEFT:
                    moveLEFT();
                    break;
            }
        } else { // we will use the prev blocks
            posX = previous.oldPosX;
            posY = previous.oldPosY;
        }

        updateVisualPosition();
        
    }

    // Logical position.
    public void moveUP() {
        posY--;
        if(posY < 0){ // would be lose if want it.
            posY = maxY - 1;
        }
    }
    
    public void moveRIGHT() {
        posX++;
        if(posX >= maxX){
            posX = 0;
        }
    }
    
    public void moveDOWN() {
        posY++;
        if(posY >= maxY){
            posY = 0;
        }
    }
    
    public void moveLEFT() {
        posX--;
        if(posX < 0){ 
            posX = maxX - 1;
        }
    }
    
    // Visual position: just apply the movement's
    public void updateVisualPosition(){
        setTranslateX(posX * JxSnakegame.BLOCK_SIZE);
        setTranslateY(posY * JxSnakegame.BLOCK_SIZE);
    }

}
