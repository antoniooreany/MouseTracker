import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class MouseTrackerController extends VBox {
	
	private Button btnClear = null;

	private Slider sliderPenWidthHight = null;

	public Button getBtnClear() {
		return btnClear;
	}

	public Slider getSliderPenWidthHight() {
		return sliderPenWidthHight;
	}

	public MouseTrackerController(Button btnClear, Slider sliderPenWidthHight) {
		this.btnClear = btnClear;
		this.sliderPenWidthHight = sliderPenWidthHight;
		this.getChildren().addAll(btnClear);
	}
}
