/*
 */

package snakegame;

import java.util.ArrayList;

/**
 * @author Alfredo Jose Flores Vargas
 */
public class Snake {

    public ArrayList<Body> bodies = new ArrayList<Body>(); 
    
    private Body head;
    
    public Snake(int initialLength, Camp c){
        int initialPX = c.getPane_w() / 2; // calculating center
        int initialPY = c.getPane_h() / 2;
        
        head = new Body(initialPX, initialPY, null, c); // head doesn't have prev..
        bodies.add(head);
        
        Body previous = head;
        
        for(int i = 1; i < initialLength; i++){
            Body b = new Body(initialPX + i, initialPY, previous, c); // every time a body get big is from the right
            bodies.add(b);
            previous = b;
        }
        
    }
    
}
