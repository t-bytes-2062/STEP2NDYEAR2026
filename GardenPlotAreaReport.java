abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double getArea();

    abstract String getShape();
}

class Circle extends Plot {
    private double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    private double length;
    private double width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    double getArea() {
        return length * width;
    }

    @Override
    String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    private double base;
    private double height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    double getArea() {
        return 0.5 * base * height;
    }

    @Override
    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {

        Plot[] plots = {
            new Circle("Asha", 5),
            new Rectangle("Ravi", 4, 6),
            new Triangle("Neha", 10, 3)
        };

        double total = 0;

        for (Plot plot : plots) {
            double area = plot.getArea();

            System.out.printf("%s (%s): %.2f%n",
                    plot.owner, plot.getShape(), area);

            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
    }
}
