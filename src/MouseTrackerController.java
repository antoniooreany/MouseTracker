import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

class MouseTrackerController extends VBox {

    private Button btnClear;

    Button getBtnClear() {
        return btnClear;
    }

    MouseTrackerController(Button btnClear) {
        this.btnClear = btnClear;
        this.getChildren().addAll(btnClear);
    }
}
