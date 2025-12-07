package academy.tochkavhoda.figures.v1;

public class Rectangle {
    private Point leftTop;
    private Point rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = new Point(leftTop.getX(), leftTop.getY());
        this.rightBottom = new Point(rightBottom.getX(), rightBottom.getY());
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.leftTop = new Point(xLeft, yTop);
        this.rightBottom = new Point(xRight, yBottom);
    }

    public Rectangle(int length, int width) {
        this.leftTop = new Point(0, -width);
        this.rightBottom = new Point(length, 0);
    }

    public Rectangle() {
        this(1, 1);
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point topLeft) {
        this.leftTop = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.rightBottom = bottomRight;
    }

    public int getLength() {
        return rightBottom.getX() - leftTop.getX();
    }

    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    public void moveTo(int x, int y) {
        int len = getLength();
        int wid = getWidth();
        leftTop.moveTo(x, y);
        rightBottom.moveTo(x + len, y + wid);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
        rightBottom.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        int newLen = (int) (getLength() * ratio);
        int newWid = (int) (getWidth() * ratio);
        rightBottom.moveTo(leftTop.getX() + newLen, leftTop.getY() + newWid);
    }

    public void stretch(double xRatio, double yRatio) {
        int newLen = (int) (getLength() * xRatio);
        int newWid = (int) (getWidth() * yRatio);
        rightBottom.moveTo(leftTop.getX() + newLen, leftTop.getY() + newWid);
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        return x >= leftTop.getX() && x <= rightBottom.getX() &&
                y >= leftTop.getY() && y <= rightBottom.getY();
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Rectangle other) {
        boolean intersectX =
                rightBottom.getX() >= other.leftTop.getX() &&
                        leftTop.getX() <= other.rightBottom.getX();
        boolean intersectY =
                rightBottom.getY() >= other.leftTop.getY() &&
                        leftTop.getY() <= other.rightBottom.getY();

        return intersectX && intersectY;
    }

    public boolean isInside(Rectangle rectangle) {
        return rectangle.leftTop.getX() >= leftTop.getX() &&
                rectangle.rightBottom.getX() <= rightBottom.getX() &&
                rectangle.leftTop.getY() >= leftTop.getY() &&
                rectangle.rightBottom.getY() <= rightBottom.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        if (!leftTop.equals(rectangle.leftTop)) return false;
        return rightBottom.equals(rectangle.rightBottom);
    }

    @Override
    public int hashCode() {
        int result = leftTop.hashCode();
        result = 31 * result + rightBottom.hashCode();
        return result;
    }
}