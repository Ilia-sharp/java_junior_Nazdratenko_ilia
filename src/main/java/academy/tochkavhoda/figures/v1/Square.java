package academy.tochkavhoda.figures.v1;

public class Square {
    private Point leftTop;
    private int size;

    public Square(Point leftTop, int size) {
        this.leftTop = new Point(leftTop.getX(), leftTop.getY());
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this.leftTop = new Point(xLeft, yTop);
        this.size = size;
    }

    public Square(int size) {
        this.leftTop = new Point(0, -size);
        this.size = size;
    }

    public Square() {
        this.leftTop = new Point(0, -1);
        this.size = 1;
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return new Point(leftTop.getX() + size, leftTop.getY() + size);
    }

    public void setTopLeft(Point topLeft) {
        this.leftTop = topLeft;
    }

    public int getLength() {
        return size;
    }

    public void moveTo(int x, int y) {
        leftTop.moveTo(x, y);
    }

    public void moveTo(Point point) {
        leftTop.moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        size = (int) (size * ratio);
    }

    public double getArea() {
        return size * size;
    }

    public double getPerimeter() {
        return 4 * size;
    }

    public boolean isInside(int x, int y) {
        return x >= leftTop.getX() && x <= leftTop.getX() + size &&
                y >= leftTop.getY() && y <= leftTop.getY() + size;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Square square) {
        int x1 = leftTop.getX();
        int y1 = leftTop.getY();
        int x2 = x1 + size;
        int y2 = y1 + size;

        int ox1 = square.leftTop.getX();
        int oy1 = square.leftTop.getY();
        int ox2 = ox1 + square.size;
        int oy2 = oy1 + square.size;

        return !(ox2 < x1 || ox1 > x2 || oy2 < y1 || oy1 > y2);
    }

    public boolean isInside(Square square) {
        return square.leftTop.getX() >= leftTop.getX() &&
                square.leftTop.getX() + square.size <= leftTop.getX() + size &&
                square.leftTop.getY() >= leftTop.getY() &&
                square.leftTop.getY() + square.size <= leftTop.getY() + size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        if (size != square.size) return false;
        return leftTop.equals(square.leftTop);
    }

    @Override
    public int hashCode() {
        int result = leftTop.hashCode();
        result = 31 * result + size;
        return result;
    }
}