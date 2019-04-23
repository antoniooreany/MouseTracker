import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

class MouseTrackerController extends VBox {

    MouseTrackerController(MouseTrackerCanvas mtCanvas) {


        Button btnClear = new Button("Clear");
        Button btnPenColorBlack = new Button("Black");
        Button btnPenColorRed = new Button("Red");
        Button btnPenColorGreen = new Button("Green");
        Slider sldrChangeThickness = new Slider(1, 20, 1);
//        sldrChangeThickness.setMinorTickCount(4);
//        sldrChangeThickness.setMajorTickUnit(5);
        sldrChangeThickness.setSnapToTicks(true);

        getChildren().addAll(btnClear, btnPenColorBlack, btnPenColorRed, btnPenColorGreen, sldrChangeThickness);

        btnClear.setOnAction(event -> mtCanvas.clear());

        btnPenColorBlack.setOnAction(event -> {
            mtCanvas.setPenColor(Color.BLACK);
            btnPenColorBlack.setDisable(true);
            btnPenColorRed.setDisable(false);
            btnPenColorGreen.setDisable(false);
        });

        btnPenColorRed.setOnAction(event -> {
            mtCanvas.setPenColor(Color.RED);
            btnPenColorBlack.setDisable(false);
            btnPenColorRed.setDisable(true);
            btnPenColorGreen.setDisable(false);
        });
        btnPenColorGreen.setOnAction(event -> {
            mtCanvas.setPenColor(Color.GREEN);
            btnPenColorBlack.setDisable(false);
            btnPenColorRed.setDisable(false);
            btnPenColorGreen.setDisable(true);
        });

        sldrChangeThickness.valueProperty().addListener((observable, oldValue, newValue) -> mtCanvas.setLineWidth((Double) newValue));
    }
}
