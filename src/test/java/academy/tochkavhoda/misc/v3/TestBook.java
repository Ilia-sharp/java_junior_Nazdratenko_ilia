package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBook {

    @Test
    public void testBookWithColor() throws ColorException {
        Book book = new Book("Java", "Gosling", Color.GREEN);
        assertAll(
                () -> assertEquals("Java", book.getTitle()),
                () -> assertEquals("Gosling", book.getAuthor()),
                () -> assertEquals(Color.GREEN, book.getColor())
        );
    }

    @Test
    public void testBookWithString() throws ColorException {
        Book book = new Book("Java", "Gosling", "BLUE");
        assertEquals(Color.BLUE, book.getColor());
    }

    @Test
    public void testBookDefault() {
        Book book = new Book();
        assertAll(
                () -> assertEquals("Book", book.getTitle()),
                () -> assertEquals("Author", book.getAuthor()),
                () -> assertEquals(Color.RED, book.getColor())
        );
    }

    @Test
    public void testSetColor() throws ColorException {
        Book book = new Book("Java", "Gosling", Color.RED);
        book.setColor(Color.BLUE);
        assertEquals(Color.BLUE, book.getColor());

        book.setColor("GREEN");
        assertEquals(Color.GREEN, book.getColor());
    }

    @Test
    public void testNullColorThrows() throws ColorException {
        Book book = new Book("Java", "Gosling", Color.RED);
        assertThrows(ColorException.class, () -> book.setColor((Color) null));
        assertThrows(ColorException.class, () -> book.setColor((String) null));
        assertThrows(ColorException.class, () -> new Book("Java", "Gosling", (Color) null));
    }

    @Test
    public void testWrongColorStringThrows() {
        assertThrows(ColorException.class, () -> new Book("Java", "Gosling", "YELLOW"));
    }

    @Test
    public void testBookSetters() throws ColorException {
        Book book = new Book();
        book.setTitle("Python");
        book.setAuthor("Guido");
        assertEquals("Python", book.getTitle());
        assertEquals("Guido", book.getAuthor());
    }

    @Test
    public void testBookEquals() throws ColorException {
        Book b1 = new Book("Java", "Gosling", Color.RED);
        Book b2 = new Book("Java", "Gosling", Color.RED);
        Book b3 = new Book("Python", "Guido", Color.RED);
        Book b4 = new Book("Java", "Gosling", Color.BLUE);
        assertEquals(b1, b2);
        assertNotEquals(b1, b3);
        assertNotEquals(b1, b4);
    }
}