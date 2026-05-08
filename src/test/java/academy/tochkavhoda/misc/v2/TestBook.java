// test/academy/tochkavhoda/misc/v2/TestBook.java
package academy.tochkavhoda.misc.v2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBook {

    @Test
    public void testBookConstructor() {
        Book book = new Book("Java", "Gosling", 2);
        assertAll(
                () -> assertEquals("Java", book.getTitle()),
                () -> assertEquals("Gosling", book.getAuthor()),
                () -> assertEquals(2, book.getColor())
        );
    }

    @Test
    public void testBookDefault() {
        Book book = new Book();
        assertAll(
                () -> assertEquals("Book", book.getTitle()),
                () -> assertEquals("Author", book.getAuthor()),
                () -> assertEquals(1, book.getColor())
        );
    }

    @Test
    public void testBookSetColor() {
        Book book = new Book("Java", "Gosling");
        book.setColor(3);
        assertEquals(3, book.getColor());
    }

    @Test
    public void testBookSetTitleAndAuthor() {
        Book book = new Book();
        book.setTitle("Python");
        book.setAuthor("Guido");
        assertEquals("Python", book.getTitle());
        assertEquals("Guido", book.getAuthor());
    }

    @Test
    public void testBookEquals() {
        Book book1 = new Book("Java", "Gosling", 1);
        Book book2 = new Book("Java", "Gosling", 1);
        Book book3 = new Book("Python", "Guido", 1);
        assertEquals(book1, book2);
        assertNotEquals(book1, book3);
    }
}