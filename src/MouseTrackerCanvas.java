import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

class MouseTrackerCanvas extends Canvas {

    private final GraphicsContext gc;
    private double previousX = -1;
    private double previousY = -1;

    private GraphicsContext getGc() {
        return gc;
    }

    MouseTrackerCanvas(double canvas_width, double canvas_height) {
        super(canvas_width, canvas_height);
        gc = getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
        setOnMouseDragged(event -> {
            getGc().setFill(Color.BLACK);
            if (previousX >= 0 || previousY >= 0) {
                getGc().strokeLine(previousX, previousY, event.getX(), event.getY());
            }
            previousX = event.getX();
            previousY = event.getY();
        });

        setOnMouseMoved(event -> {
            previousX = event.getX();
            previousY = event.getY();
        });
    }

    void clear() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        previousX = -1;
        previousY = -1;
    }
}
