package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCar {

    @Test
    public void testCarConstructor() {
        Car car = new Car("BMW", 2, 10, 20);
        assertAll(
                () -> assertEquals("BMW", car.getName()),
                () -> assertEquals(2, car.getColor()),
                () -> assertEquals(10, car.getPosition().getX()),
                () -> assertEquals(20, car.getPosition().getY())
        );
    }

    @Test
    public void testCarDefault() {
        Car car = new Car();
        assertAll(
                () -> assertEquals("Car", car.getName()),
                () -> assertEquals(1, car.getColor()),
                () -> assertEquals(0, car.getPosition().getX()),
                () -> assertEquals(0, car.getPosition().getY())
        );
    }

    @Test
    public void testCarMove() {
        Car car = new Car("BMW", 1, 0, 0);
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
    public void testCarSetColor() {
        Car car = new Car("BMW", 1);
        car.setColor(3);
        assertEquals(3, car.getColor());
    }

    @Test
    public void testCarSetName() {
        Car car = new Car("BMW", 1);
        car.setName("Audi");
        assertEquals("Audi", car.getName());
    }

    @Test
    public void testCarEquals() {
        Car car1 = new Car("BMW", 1, 0, 0);
        Car car2 = new Car("BMW", 1, 0, 0);
        Car car3 = new Car("Audi", 1, 0, 0);
        assertEquals(car1, car2);
        assertNotEquals(car1, car3);
    }
}