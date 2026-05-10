package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;
import academy.tochkavhoda.iface.v3.Movable;
import academy.tochkavhoda.figures.v3.Point;
import java.util.Objects;

public class Car implements Movable, Colored {
    private String name;
    private Color color;
    private Point position;

    public Car(String name, Color color, int x, int y) throws ColorException {
        this.name = name;
        this.position = new Point(x, y);
        setColor(color);
    }
    public Car(String name, Color color) throws ColorException {
        this(name, color, 0, 0);
    }
    public Car(String name, String colorString, int x, int y) throws ColorException {
        this(name, Color.colorFromString(colorString), x, y);
    }
    public Car(String name, String colorString) throws ColorException {
        this(name, Color.colorFromString(colorString), 0, 0);
    }
    public Car() {
        this.name = "Car";
        this.color = Color.RED;
        this.position = new Point(0, 0);
    }

    public String getName()          { return name; }
    public void setName(String name) { this.name = name; }
    public Point getPosition()       { return position; }

    @Override public Color getColor() { return color; }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) throw new ColorException(ColorErrorCode.NULL_COLOR);
        this.color = color;
    }
    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
    }

    @Override public void moveTo(int x, int y)   { position.moveTo(x, y); }
    @Override public void moveRel(int dx, int dy) { position.moveRel(dx, dy); }

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