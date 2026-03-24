package academy.tochkavhoda.figures.v1;

public class ColoredCircle extends Circle {
    private int color;

    public ColoredCircle(Point center, int radius, int color) {
        super(center, radius);
        this.color = color;
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, int color) {
        super(xCenter, yCenter, radius);
        this.color = color;
    }

    public ColoredCircle(int radius, int color) {
        super(radius);
        this.color = color;
    }

    public ColoredCircle(int color) {
        super(1);
        this.color = color;
    }

    public ColoredCircle() {
        super(1);
        this.color = 1;
    }

    public int getColor() { return color; }
    public void setColor(int color) { this.color = color; }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        ColoredCircle that = (ColoredCircle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + color;
    }
}