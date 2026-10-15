import java.util.*;

abstract class Plot {
    protected String owner;
    protected String shape;

    public Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }

    public abstract double calculateArea();

    public String getOwner() { return owner; }
    public String getShape() { return shape; }
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot plot = null;

            if (shape.equalsIgnoreCase("CIRCLE")) {
                double radius = sc.nextDouble();
                plot = new CirclePlot(owner, radius);
            } else if (shape.equalsIgnoreCase("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plot = new RectanglePlot(owner, length, width);
            } else if (shape.equalsIgnoreCase("TRIANGLE")) {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plot = new TrianglePlot(owner, base, height);
            }

            if (plot != null) {
                double area = plot.calculateArea();
                totalArea += area;
                System.out.printf("%s (%s): %.2f%n", plot.getOwner(), plot.getShape(), area);
            }
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}