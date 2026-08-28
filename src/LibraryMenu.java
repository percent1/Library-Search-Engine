import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides the interactive menu for the Library Search Engine.
 */
public class LibraryMenu {

    private Library library;
    private Scanner scanner;

    /**
     * Creates a new library menu.
     *
     * @param library the library used by the menu
     */
    public LibraryMenu(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the interactive library menu.
     */
    public void start() {

        int choice = 0;

        do {
            displayMenu();

            try {
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        ActivityLogger.log("VIEW_ALL_BOOKS");
                        library.displayBooks();
                        break;

                    case 2:
                        searchBooks();
                        break;

                    case 3:
                        sortBooks();
                        break;

                    case 4:
                        saveLibrary();
                        break;

                    case 5:
                        loadLibrary();
                        break;

                    case 6:
                        ActivityLogger.log("EXIT");

                        System.out.println();
                        System.out.println(
                                "Thank you for using the Library Search Engine!"
                        );
                        break;

                    default:
                        System.out.println();
                        System.out.println(
                                "Invalid option. Please choose 1, 2, 3, 4, 5, or 6."
                        );
                }

            } catch (InputMismatchException e) {

                System.out.println();
                System.out.println(
                        "Invalid input. Please enter a number."
                );

                scanner.nextLine();
                choice = 0;
            }

        } while (choice != 6);

        scanner.close();
    }

    /**
     * Displays the main menu.
     */
    private void displayMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("        LIBRARY SEARCH ENGINE");
        System.out.println("========================================");
        System.out.println("1. View All Books");
        System.out.println("2. Search Books");
        System.out.println("3. Sort Books");
        System.out.println("4. Save Library");
        System.out.println("5. Load Library");
        System.out.println("6. Exit");
        System.out.println("========================================");
    }

    /**
     * Allows the user to search for books.
     */
    private void searchBooks() {

        System.out.println();
        System.out.print("Enter title, author, or publication year: ");

        String searchTerm = scanner.nextLine();

        ActivityLogger.log("SEARCH: " + searchTerm);

        ArrayList<Book> results = library.searchBooks(searchTerm);

        System.out.println();
        System.out.println("===== SEARCH RESULTS =====");

        if (results.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book book : results) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println("Found " + results.size() + " book(s).");
    }

    /**
     * Allows the user to choose a sorting method.
     */
    private void sortBooks() {

        System.out.println();
        System.out.println("===== SORT BOOKS =====");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Author");
        System.out.println("3. Sort by Publication Year");
        System.out.print("Choose a sorting option: ");

        try {

            int sortChoice = scanner.nextInt();
            scanner.nextLine();

            switch (sortChoice) {

                case 1:
                    SortUtil.sortByTitle(library.getBooks());

                    ActivityLogger.log("SORT: TITLE");

                    System.out.println(
                            "Books sorted by title."
                    );
                    library.displayBooks();
                    break;

                case 2:
                    SortUtil.sortByAuthor(library.getBooks());

                    ActivityLogger.log("SORT: AUTHOR");

                    System.out.println(
                            "Books sorted by author."
                    );
                    library.displayBooks();
                    break;

                case 3:
                    SortUtil.sortByPublicationYear(
                            library.getBooks()
                    );

                    ActivityLogger.log(
                            "SORT: PUBLICATION_YEAR"
                    );

                    System.out.println(
                            "Books sorted by publication year."
                    );
                    library.displayBooks();
                    break;

                default:
                    System.out.println(
                            "Invalid sorting option."
                    );
            }

        } catch (InputMismatchException e) {

            System.out.println(
                    "Invalid input. Please enter a number."
            );

            scanner.nextLine();
        }
    }

    /**
     * Saves the current library to a serialized file.
     */
    private void saveLibrary() {

        System.out.println();
        System.out.println("===== SAVING LIBRARY =====");

        LibrarySerializer.saveLibrary(library);

        ActivityLogger.log("SAVE_LIBRARY");
    }

    /**
     * Loads the library from a serialized file.
     */
    private void loadLibrary() {

        System.out.println();
        System.out.println("===== LOADING LIBRARY =====");

        Library loadedLibrary = LibrarySerializer.loadLibrary();

        if (loadedLibrary != null) {

            library = loadedLibrary;

            ActivityLogger.log("LOAD_LIBRARY");

            System.out.println();
            System.out.println(
                    "Library data has been loaded successfully."
            );

        } else {

            System.out.println();
            System.out.println(
                    "Library could not be loaded."
            );
        }
    }
}
