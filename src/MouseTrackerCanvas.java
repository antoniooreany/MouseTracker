import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class MouseTrackerCanvas extends Canvas {

    private GraphicsContext gc;

    private double lineWidth = 1;
    private Color penColor = Color.BLACK;
    private double previousX = -1;
    private double previousY = -1;

    GraphicsContext getGc() {
        return gc;
    }

    void setPenColor(Color penColor) {
        this.penColor = penColor;
    }

    void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    MouseTrackerCanvas(double canvas_width, double canvas_height) {
        super(canvas_width, canvas_height);
        gc = getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
        setOnMouseDragged(event -> {
            if (previousX >= 0 || previousY >= 0) {
                gc.setStroke(penColor);
                gc.setLineWidth(lineWidth);
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
