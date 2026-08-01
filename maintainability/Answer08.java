package maintainability;

import java.util.List;

/**
 * Answer 08: Refactoring for Open/Closed Principle (OCP)
 * 
 * Key Improvements:
 * 1. Introduced `Shape` interface defining `calculateArea()`.
 * 2. Classes `Rectangle` and `Circle` encapsulate their own area calculation logic.
 * 3. `CalculateService` depends on `Shape` abstraction; adding new shapes (e.g. `Triangle`) requires zero modifications to `CalculateService`.
 */
public class Answer08 {

    // Abstraction
    public interface Shape {
        double calculateArea();
    }

    // Rectangle implementation
    public static class Rectangle implements Shape {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() { return width; }
        public double getHeight() { return height; }

        @Override
        public double calculateArea() {
            return width * height;
        }
    }

    // Circle implementation
    public static class Circle implements Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() { return radius; }

        @Override
        public double calculateArea() {
            return Math.PI * Math.pow(radius, 2);
        }
    }

    // Service closed for modification, open for extension via Shape interface
    public static class CalculateService {
        public double calculateArea(Shape shape) {
            return shape.calculateArea();
        }

        public double calculateTotalArea(List<Shape> shapes) {
            double totalArea = 0;
            for (Shape shape : shapes) {
                totalArea += shape.calculateArea();
            }
            return totalArea;
        }
    }

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5.5, 8);
        Shape circle = new Circle(4);

        CalculateService service = new CalculateService();
        System.out.println("Rectangle Area: " + service.calculateArea(rectangle));
        System.out.println("Circle Area: " + service.calculateArea(circle));
    }
}
