/*
 */

package snakegame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alfredo Jose Flores Vargas
 *
 */
public class JxSnakegame extends Application{

    static int block_size = 10; // every body size.
    
    private int width = 30, height = 15;
    
    private int initialLength = 5;
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox(10);
        root.setPadding(new Insets(10) );
        
        Camp camp = new Camp(width, height);
        camp.addSnake(new Snake(initialLength, camp) );
        root.getChildren().add(camp);
        
        Scene scene = new Scene(root);
        primaryStage.setResizable(false);        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
                
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
