package polymorphism.Shapes_02;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculateArea() {
        super.setArea(Math.PI * Math.pow(this.radius, 2));
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
    }
}