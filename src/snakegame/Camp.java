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

public class Camp extends Pane{
    
    private int pane_w, pane_h;
    
    private ArrayList<Body> bodies = new ArrayList<Body>();
    private int score = 0;
    private  Fruit f;
    private Snake snake;
    
    public Camp(int width, int height) { // size blocks from main class
        pane_w = width;
        pane_h = height;
        
        setMinSize(pane_w * JxSnakegame.BLOCK_SIZE, pane_h * JxSnakegame.BLOCK_SIZE);
        setBackground(new Background(new BackgroundFill(Color.GREY, null, null) ) );
        
        setBorder(new Border(new BorderStroke(Color.RED.brighter(), BorderStrokeStyle.SOLID, null, new BorderWidths(2) ) ));
        addFruit();
    }

    public void addSnake(Snake snake) {
        this.snake = snake;
        for(Body b: snake.bodies) {
            addBody(b);
        }
    }
    
    public void update() {
        for(Body b: bodies){
            b.update();
        }
        
        if(isTouch(f) ){
            score += 50;
            addFruit();
            addNewBody();
        }
        
    }
    
    public void addNewBody() {
        Body b = new Body(snake.getTail().getOldPosX(), snake.getTail().getPosY(), snake.getTail(), this);
        b.setFill(Color.YELLOW.brighter());
        snake.setTail(b);
        addBody(b);
    }
    
    private void addBody(Body b){
        getChildren().add(b);
        bodies.add(b);
    }
    
    public void addFruit() {
        int randomX = (int) (Math.random() * pane_w);
        int randomY = (int) (Math.random() * pane_h);

        Fruit fruit = new Fruit(randomX, randomY);
        getChildren().add(fruit);
        getChildren().remove(f);
        f = fruit;
    }
    
    public boolean isTouch(Fruit frt) {
        if(frt == null)
            return false;
        else
            return frt.getPosX() == snake.getHead().getPosX() && frt.getPosY() == snake.getHead().getPosY();
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
    
    public void setSnakeDirection(int d) {
        this.snake.setDirection(d);
    }
    
    public int getSnakeDirection(){
        return this.snake.getDirection();
    }
    
    

}
