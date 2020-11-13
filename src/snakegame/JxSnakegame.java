/*
 */

package snakegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alfredo Jose Flores Vargas
 *
 */
public class JxSnakegame extends Application{

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        
        Scene scene = new Scene(root);
        primaryStage.setResizable(false);        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
