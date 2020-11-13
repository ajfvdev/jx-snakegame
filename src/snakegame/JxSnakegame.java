/*
 */
package snakegame;

import javafx.animation.AnimationTimer;
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
public class JxSnakegame extends Application {

    static int BLOCK_SIZE = 10; // every body size.

    private int width = 30, height = 15;

    private int SnakeInitialLength = 5;
    
    private long then = System.nanoTime();


    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Camp camp = new Camp(width, height);
        camp.addSnake(new Snake(SnakeInitialLength, camp));


        // Infinite loop, re-execute that doesn't block the main thread.
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (now - then > 1000000000) {
                    camp.update();
                    then = now;
                }
            }

        };

        timer.start();

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
