package polymorphism.Shapes_02;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    protected void calculateArea() {
        super.setArea(this.height * this.width);
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(this.height * 2 + this.width * 2);
    }
}
