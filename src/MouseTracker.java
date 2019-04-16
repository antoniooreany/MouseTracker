import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

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
        
        MouseTrackerController mtController = new MouseTrackerController();
        MouseTrackerCanvas mtCanvas = new MouseTrackerCanvas();

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
