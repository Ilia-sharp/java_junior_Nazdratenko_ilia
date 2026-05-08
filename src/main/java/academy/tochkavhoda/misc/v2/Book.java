// academy/tochkavhoda/misc/v2/Book.java
package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.Colored;
import java.util.Objects;

public class Book implements Colored {
    private String title;
    private String author;
    private int color;

    public Book(String title, String author, int color) {
        this.title = title;
        this.author = author;
        this.color = color;
    }
    public Book(String title, String author) { this(title, author, 1); }
    public Book()                            { this("Book", "Author", 1); }

    public String getTitle()           { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor()             { return author; }
    public void setAuthor(String author)  { this.author = author; }

    @Override public int getColor()           { return color; }
    @Override public void setColor(int color) { this.color = color; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return color == b.color
                && Objects.equals(title, b.title)
                && Objects.equals(author, b.author);
    }
    @Override public int hashCode() { return Objects.hash(title, author, color); }
}