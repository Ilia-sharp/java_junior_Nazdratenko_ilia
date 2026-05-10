package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;
import java.util.Objects;

public class Book implements Colored {
    private String title;
    private String author;
    private Color color;

    public Book(String title, String author, Color color) throws ColorException {
        this.title = title;
        this.author = author;
        setColor(color);
    }
    public Book(String title, String author, String colorString) throws ColorException {
        this(title, author, Color.colorFromString(colorString));
    }
    public Book() {
        this.title = "Book";
        this.author = "Author";
        this.color = Color.RED;
    }

    public String getTitle()              { return title; }
    public void setTitle(String title)    { this.title = title; }
    public String getAuthor()             { return author; }
    public void setAuthor(String author)  { this.author = author; }

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