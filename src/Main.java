/**
 * Entry point for the Library Search Engine application.
 */
public class Main {

    /**
     * Starts the Library Search Engine.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Library library = new Library();

        library.loadBooksFromFile("data/books.txt");

        LibraryMenu menu = new LibraryMenu(library);

        menu.start();
    }
}
