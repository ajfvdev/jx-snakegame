/*
 */

package snakegame;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Snake {

    public ArrayList<Body> bodies = new ArrayList<Body>(); 
    
    private Body head;
    private Body tail;
    
    public Snake(int initialLength, Camp c){
        int initialPX = c.getPane_w() / 2; // calculating center
        int initialPY = c.getPane_h() / 2;
        
        head = new Body(initialPX, initialPY, null, c); // head doesn't have prev..
        bodies.add(head);
        
        head.setFill(Color.GREEN.desaturate());
        
        tail = head;
        
        for(int i = 1; i < initialLength; i++){
            Body b = new Body(initialPX + i, initialPY, tail, c); // every time a body get big is from the right
            b.setFill(Color.YELLOW.brighter());
            bodies.add(b);
            tail = b;
        }
        
    }
    
    public void setDirection(int d){
       head.direction = d; 
    }
    
    public int getDirection(){
        return this.head.direction;
    }
    
    public Body getHead(){
        return this.head;
    }
    
    public Body getTail(){
        return this.tail;
    }
    
    public void setTail(Body newTail){
        this.tail = newTail;
    }
    
}
