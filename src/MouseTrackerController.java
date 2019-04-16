import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MouseTrackerController extends VBox {
	
	private Button btnClear = null;

	public Button getBtnClear() {
		return btnClear;
	}

	public MouseTrackerController(Button btnClear) {
		this.btnClear = btnClear;
		this.getChildren().addAll(btnClear);

	}
}
