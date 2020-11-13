/*
 */

package snakegame;

import java.util.ArrayList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * @author Alfredo Jose Flores Vargas
 */
public class Camp extends Pane{
    
    private int pane_w, pane_h;
    
    private ArrayList<Body> bodies = new ArrayList<Body>();
    private Snake snake;
    
    public Camp(int width, int height) { // size blocks from main class
        pane_w = width;
        pane_h = height;
        
        setMinSize(pane_w * JxSnakegame.block_size, pane_h * JxSnakegame.block_size);
        setBackground(new Background(new BackgroundFill(Color.WHITE, null, null) ) );
        
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1) ) ));
    }

    public void addSnake(Snake snake) {
        this.snake = snake;
        for(Body b: snake.bodies) {
            addBody(b);
        }
    }
    
    private void addBody(Body b){
        getChildren().add(b);
        bodies.add(b);
    }
    
    public int getPane_w() {
        return pane_w;
    }

    public void setPane_w(int pane_w) {
        this.pane_w = pane_w;
    }

    public int getPane_h() {
        return pane_h;
    }

    public void setPane_h(int pane_h) {
        this.pane_h = pane_h;
    }
    
    

}
