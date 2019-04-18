import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class MouseTrackerCanvas extends Canvas {

    private final GraphicsContext gc;

    GraphicsContext getGc() {
        return gc;
    }

    MouseTrackerCanvas(double canvas_width, double canvas_height) {
        super(canvas_width, canvas_height);
        gc = getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
        gc.fillRect(0, 0, canvas_width, canvas_height);
    }
}
