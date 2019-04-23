import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class MouseTrackerCanvas extends Canvas {

    private final GraphicsContext gc;

    private GraphicsContext getGc() {
        return gc;
    }

    MouseTrackerCanvas(double canvas_width, double canvas_height) {
        super(canvas_width, canvas_height);
        gc = getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
        this.setOnMouseDragged(event -> {
            this.getGc().setFill(Color.BLACK);
            this.getGc().fillOval(event.getX(), event.getY(), 10, 10);
        });
    }

    void clear() {
        gc.clearRect(0,0, this.getWidth(), this.getHeight());
    }
}
