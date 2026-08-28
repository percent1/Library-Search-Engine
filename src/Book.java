import java.io.Serializable;

/**
 * Represents a book in the library.
 *
 * A Book stores the title, author, and publication year.
 * The class implements Serializable so Book objects can
 * be saved to and loaded from a file.
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private int publicationYear;

    /**
     * Creates a new Book.
     *
     * @param title the title of the book
     * @param author the author of the book
     * @param publicationYear the year the book was published
     */
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    /**
     * Returns the book title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the book author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the publication year.
     *
     * @return the publication year
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Returns a readable representation of the book.
     *
     * @return book details
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
