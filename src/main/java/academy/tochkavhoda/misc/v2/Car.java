package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.figures.v2.Point;
import java.util.Objects;

public class Car implements Movable, Colored {
    private String name;
    private int color;
    private Point position;

    public Car(String name, int color, int x, int y) {
        this.name = name;
        this.color = color;
        this.position = new Point(x, y);
    }
    public Car(String name, int color) { this(name, color, 0, 0); }
    public Car()                       { this("Car", 1, 0, 0); }

    public String getName()          { return name; }
    public void setName(String name) { this.name = name; }
    public Point getPosition()       { return position; }

    @Override public int getColor()           { return color; }
    @Override public void setColor(int color) { this.color = color; }
    @Override public void moveTo(int x, int y)     { position.moveTo(x, y); }
    @Override public void moveRel(int dx, int dy)   { position.moveRel(dx, dy); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car c = (Car) o;
        return color == c.color
                && Objects.equals(name, c.name)
                && Objects.equals(position, c.position);
    }
    @Override public int hashCode() { return Objects.hash(name, color, position); }
}