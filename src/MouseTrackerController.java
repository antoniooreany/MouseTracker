import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

class MouseTrackerController extends VBox {

    MouseTrackerController(MouseTrackerCanvas mtCanvas) {
        Button btnClear = new Button("Clear");
        btnClear.setOnAction(event -> {
            mtCanvas.clear();
        });
        getChildren().addAll(btnClear);
    }
}
