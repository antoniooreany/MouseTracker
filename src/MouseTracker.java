import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MouseTracker extends Application {

    public void start(Stage myStage) {
        // Give the stage a title.
        myStage.setTitle("Mouse Tracker");

        // Create the GridPane.
        HBox rootNode = new HBox(10);
        rootNode.setPadding(new Insets(10, 10, 10, 10)); // Gaps at the outside borders

        // mtCanvas initialization
        MouseTrackerCanvas mtCanvas = new MouseTrackerCanvas(600, 600);

        // mtController initialization
        MouseTrackerController mtController = new MouseTrackerController(mtCanvas);

        // Create a scene.
        Scene myScene = new Scene(rootNode, rootNode.getMinWidth(), rootNode.getMinHeight());
        rootNode.getChildren().addAll(mtController, mtCanvas);

        // Set the scene on the stage.
        myStage.setScene(myScene);

        // Parametrize and show the stage and its scene.
        myStage.setResizable(false);
        myStage.show();
    }

    public static void main(String[] args) {
        // Start the JavaFX application by calling launch().
        launch(args);
    }
}
