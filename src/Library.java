
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a library containing a collection of books.
 *
 * The Library class can load book information from a text file,
 * store the information as Book objects, display books, and
 * search for books by title, author, or publication year.
 */
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Book> books;

    /**
     * Creates an empty library.
     */
    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Returns the list of books in the library.
     *
     * @return the library books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Reads book information from a text file.
     *
     * Each line must follow this format:
     *
     * title|author|publicationYear
     *
     * @param filename the file containing the book data
     */
    public void loadBooksFromFile(String filename) {

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // Ignore empty lines.
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\|");

                // Make sure the line contains all required fields.
                if (parts.length != 3) {
                    System.out.println(
                            "Skipping invalid book record: " + line
                    );
                    continue;
                }

                String title = parts[0].trim();
                String author = parts[1].trim();
                int publicationYear;

                try {
                    publicationYear = Integer.parseInt(parts[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println(
                            "Skipping book with invalid year: " + line
                    );
                    continue;
                }

                books.add(
                        new Book(title, author, publicationYear)
                );
            }

            System.out.println(
                    "Successfully loaded " + books.size() +
                    " books from " + filename
            );

        } catch (IOException e) {

            System.out.println(
                    "Error reading book file: " + e.getMessage()
            );
        }
    }

    /**
     * Searches for books by title, author, or publication year.
     *
     * The search is case-insensitive for title and author.
     * The publication year is also matched using its text value.
     *
     * @param searchTerm the text to search for
     * @return a list containing matching books
     */
    public ArrayList<Book> searchBooks(String searchTerm) {

        ArrayList<Book> results = new ArrayList<>();

        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return results;
        }

        String searchValue = searchTerm.trim().toLowerCase();

        for (Book book : books) {

            boolean titleMatches = book.getTitle()
                    .toLowerCase()
                    .contains(searchValue);

            boolean authorMatches = book.getAuthor()
                    .toLowerCase()
                    .contains(searchValue);

            boolean yearMatches = String.valueOf(
                    book.getPublicationYear()
            ).contains(searchValue);

            if (titleMatches || authorMatches || yearMatches) {
                results.add(book);
            }
        }

        return results;
    }

    /**
     * Displays all books currently stored in the library.
     */
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books found in the library.");
            return;
        }

        System.out.println();
        System.out.println("===== LIBRARY BOOKS =====");

        for (Book book : books) {
            System.out.println(book);
        }
    }
}

