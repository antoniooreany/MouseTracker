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

    public static void main(String[] args) {
        // Start the JavaFX application by calling launch().  
        launch(args);
    }

    public void start(Stage myStage) {
        // Give the stage a title.  
        myStage.setTitle("Mouse Tracker");

        // Create the GridPane. 
        HBox rootNode = new HBox(10);
        rootNode.setPadding(new Insets(10, 10, 10, 10)); // Gaps at the outside borders

        // Create a button "Clear"
        Button btnClear = new Button("Clear");

        MouseTrackerCanvas mtCanvas = new MouseTrackerCanvas();
        mtCanvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mtCanvas.getGc().setFill(Color.BLACK);
                mtCanvas.getGc().fillRect(event.getX(), event.getY(), 10, 10);
//                mtCanvas.getGc().clearRect(0, 0, 300, 200);
            }
        });

        // Put the button "Clear" into the mtController
        MouseTrackerController mtController = new MouseTrackerController(btnClear);
        mtController.getBtnClear().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO Clear the MouseTrackerCanvas
//                mtCanvas.getGc().setFill(Color.TRANSPARENT);
                mtCanvas.getGc().setFill(Color.WHITE);
            }
        });


        // Create a scene.  
        Scene myScene = new Scene(rootNode, rootNode.getMinWidth(), rootNode.getMinHeight());
        rootNode.getChildren().addAll(mtController, mtCanvas);

        // Set the scene on the stage.  
        myStage.setScene(myScene);

        // Parametrize and show the stage and its scene.
        myStage.setResizable(false);
        myStage.show();
    }
}
