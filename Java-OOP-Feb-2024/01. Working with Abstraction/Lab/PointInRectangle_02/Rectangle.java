package working_with_abstraction.PointInRectangle_02;

import working_with_abstraction.PointInRectangle_02.Point;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    private Point getBottomLeft() {
        return bottomLeft;
    }

    private Point getTopRight() {
        return topRight;
    }

    public boolean contains(Point point) {
        boolean isInHorizontal = this.getBottomLeft().getX() <= point.getX() &&
                this.getTopRight().getX() >= point.getX();
        boolean isInVertical = this.getBottomLeft().getY() <= point.getY() &&
                this.getTopRight().getY() >= point.getY();

        return isInHorizontal && isInVertical;
    }
}