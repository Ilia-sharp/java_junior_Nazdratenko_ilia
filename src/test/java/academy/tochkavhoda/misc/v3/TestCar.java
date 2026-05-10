package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.figures.v3.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCar {

    @Test
    public void testCarWithColor() throws ColorException {
        Car car = new Car("BMW", Color.RED, 10, 20);
        assertAll(
                () -> assertEquals("BMW", car.getName()),
                () -> assertEquals(Color.RED, car.getColor()),
                () -> assertEquals(10, car.getPosition().getX()),
                () -> assertEquals(20, car.getPosition().getY())
        );
    }

    @Test
    public void testCarWithString() throws ColorException {
        Car car = new Car("BMW", "GREEN", 0, 0);
        assertEquals(Color.GREEN, car.getColor());
    }

    @Test
    public void testCarDefault() {
        Car car = new Car();
        assertAll(
                () -> assertEquals("Car", car.getName()),
                () -> assertEquals(Color.RED, car.getColor()),
                () -> assertEquals(0, car.getPosition().getX()),
                () -> assertEquals(0, car.getPosition().getY())
        );
    }

    @Test
    public void testCarMove() throws ColorException {
        Car car = new Car("BMW", Color.RED);
        car.moveTo(10, 20);
        assertEquals(10, car.getPosition().getX());
        assertEquals(20, car.getPosition().getY());

        car.moveRel(5, 5);
        assertEquals(15, car.getPosition().getX());
        assertEquals(25, car.getPosition().getY());

        car.moveTo(new Point(100, 200));
        assertEquals(100, car.getPosition().getX());
        assertEquals(200, car.getPosition().getY());
    }

    @Test
    public void testSetColor() throws ColorException {
        Car car = new Car("BMW", Color.RED);
        car.setColor(Color.BLUE);
        assertEquals(Color.BLUE, car.getColor());

        car.setColor("GREEN");
        assertEquals(Color.GREEN, car.getColor());
    }

    @Test
    public void testNullColorThrows() throws ColorException {
        Car car = new Car("BMW", Color.RED);
        assertThrows(ColorException.class, () -> car.setColor((Color) null));
        assertThrows(ColorException.class, () -> car.setColor((String) null));
        assertThrows(ColorException.class, () -> new Car("BMW", (Color) null));
    }

    @Test
    public void testWrongColorStringThrows() {
        assertThrows(ColorException.class, () -> new Car("BMW", "YELLOW"));
    }

    @Test
    public void testCarEquals() throws ColorException {
        Car car1 = new Car("BMW", Color.RED, 0, 0);
        Car car2 = new Car("BMW", Color.RED, 0, 0);
        Car car3 = new Car("Audi", Color.RED, 0, 0);
        Car car4 = new Car("BMW", Color.BLUE, 0, 0);
        assertEquals(car1, car2);
        assertNotEquals(car1, car3);
        assertNotEquals(car1, car4);
    }
}