/*
 */
package snakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class JxSnakegame extends Application {

    static int BLOCK_SIZE = 20; // every body size.

    private int width = 30, height = 20;

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
                if (now - then > 1000000000 / 4) {
                    camp.update();
                    then = now;
                }
            }

        };

        timer.start();

        root.getChildren().add(camp);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.UP) && camp.getSnakeDirection() != Body.DOWN) {
                camp.setSnakeDirection(Body.UP);
            }
            if (e.getCode().equals(KeyCode.DOWN) && camp.getSnakeDirection() != Body.UP) {
                camp.setSnakeDirection(Body.DOWN);

            }
            if (e.getCode().equals(KeyCode.LEFT) && camp.getSnakeDirection() != Body.RIGHT) {
                camp.setSnakeDirection(Body.LEFT);

            }
            if (e.getCode().equals(KeyCode.RIGHT) && camp.getSnakeDirection() != Body.LEFT) {
                camp.setSnakeDirection(Body.RIGHT);

            }
        });

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
