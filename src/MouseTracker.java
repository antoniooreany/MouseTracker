import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MouseTracker extends Application {

    private static MouseTrackerCanvas mtCanvas;
    private static MouseTrackerController mtController;
    private static HBox rootNode;

    public void start(Stage myStage) {
        // Give the stage a title.
        myStage.setTitle("Mouse Tracker");

        // Create the GridPane.
        rootNode = new HBox(10);
        rootNode.setPadding(new Insets(10, 10, 10, 10)); // Gaps at the outside borders

        // mtController initialization
        mtController = getMouseTrackerController();

        // mtCanvas initialization
        mtCanvas = getMouseTrackerCanvas();

        // Create a scene.
        Scene myScene = new Scene(rootNode, rootNode.getMinWidth(), rootNode.getMinHeight());
        rootNode.getChildren().addAll(mtController, mtCanvas);

        // Set the scene on the stage.
        myStage.setScene(myScene);

        // Parametrize and show the stage and its scene.
        myStage.setResizable(false);
        myStage.show();
    }

    private MouseTrackerController getMouseTrackerController() {
        // Create a button "Clear"
        Button btnClear = new Button("Clear");
        mtController = new MouseTrackerController(btnClear);
        mtController.getBtnClear().setOnAction(event -> {
            rootNode.getChildren().remove(mtCanvas);
            mtCanvas = getMouseTrackerCanvas();
            rootNode.getChildren().add(mtCanvas);
        });
        return mtController;
    }

    private MouseTrackerCanvas getMouseTrackerCanvas() {
        mtCanvas = new MouseTrackerCanvas(600, 600);
        mtCanvas.setOnMouseDragged(event -> {
            mtCanvas.getGc().setFill(Color.BLACK);
            mtCanvas.getGc().fillRect(event.getX(), event.getY(), 10, 10);
        });
        return mtCanvas;
    }

    public static void main(String[] args) {
        // Start the JavaFX application by calling launch().
        launch(args);
    }
}
