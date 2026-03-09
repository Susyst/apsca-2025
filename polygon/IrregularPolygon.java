package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // TODO: Calculate the perimeter.
        if (myPolygon.size() < 2) {
            return 0.0;
        }
        double sum = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());
            sum += current.distance(next);
        }
        return sum;
    }

    public double area() {
        //done
        int n = myPolygon.size();
        if (n < 3) {
            return 0.0;
        }
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % n);
            sum += current.x * next.y - next.x * current.y;
        }
        return Math.abs(sum) / 2.0;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
            if (myPolygon.size() < 2) {
                return;
            }
            DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            Point2D.Double first = myPolygon.get(0);
            myDrawingTool.up();
            myDrawingTool.move(first.x, first.y);
            myDrawingTool.down();
            for (int i = 1; i < myPolygon.size(); i++) {
                Point2D.Double current = myPolygon.get(i);
                myDrawingTool.move(current.x, current.y);
            }
            myDrawingTool.move(first.x, first.y); // Close the polygon
            
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
