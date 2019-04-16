import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MouseTracker extends Application {

    private static MouseTrackerCanvas mtCanvas;
    private static MouseTrackerController mtController;
    private HBox rootNode;

    public void start(Stage myStage) {
        // Give the stage a title.
        myStage.setTitle("Mouse Tracker");

        // Create the GridPane.
        rootNode = new HBox(10);
        rootNode.setPadding(new Insets(10, 10, 10, 10)); // Gaps at the outside borders

        // Put the button "Clear" into the mtController
        mtController = getMouseTrackerController();

        // Create mtCanvas
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
        mtController.getBtnClear().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO Clear the MouseTrackerCanvas
                System.out.println("mtController.getBtnClear().setOnAction");
                rootNode.getChildren().remove(mtCanvas);
                mtCanvas = getMouseTrackerCanvas();
                rootNode.getChildren().add(mtCanvas);
            }
        });
        return mtController;
    }

    private MouseTrackerCanvas getMouseTrackerCanvas() {
        mtCanvas = new MouseTrackerCanvas();
        mtCanvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mtCanvas.getGc().setFill(Color.BLACK);
                mtCanvas.getGc().fillRect(event.getX(), event.getY(), 10, 10);
            }
        });
        return mtCanvas;
    }

    public static void main(String[] args) {
        // Start the JavaFX application by calling launch().
        launch(args);
    }
}
