import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MouseTrackerCanvas extends Canvas {

    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 600;

    private final GraphicsContext gc;

    public GraphicsContext getGc() {
        return gc;
    }

    public MouseTrackerCanvas() {
        super(CANVAS_WIDTH, CANVAS_HEIGHT);
        gc = getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
        gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
    }
}
