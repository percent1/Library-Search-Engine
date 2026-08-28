import java.util.ArrayList;

/**
 * Utility class containing sorting algorithms for books.
 */
public class SortUtil {

    /**
     * Prevents creation of SortUtil objects.
     */
    private SortUtil() {
    }

    /**
     * Sorts books alphabetically by title using bubble sort.
     *
     * @param books the list of books to sort
     */
    public static void sortByTitle(ArrayList<Book> books) {

        for (int i = 0; i < books.size() - 1; i++) {

            for (int j = 0; j < books.size() - 1 - i; j++) {

                if (books.get(j).getTitle()
                        .compareToIgnoreCase(books.get(j + 1).getTitle()) > 0) {

                    swap(books, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts books alphabetically by author using bubble sort.
     *
     * @param books the list of books to sort
     */
    public static void sortByAuthor(ArrayList<Book> books) {

        for (int i = 0; i < books.size() - 1; i++) {

            for (int j = 0; j < books.size() - 1 - i; j++) {

                if (books.get(j).getAuthor()
                        .compareToIgnoreCase(books.get(j + 1).getAuthor()) > 0) {

                    swap(books, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts books by publication year using bubble sort.
     *
     * @param books the list of books to sort
     */
    public static void sortByPublicationYear(ArrayList<Book> books) {

        for (int i = 0; i < books.size() - 1; i++) {

            for (int j = 0; j < books.size() - 1 - i; j++) {

                if (books.get(j).getPublicationYear()
                        > books.get(j + 1).getPublicationYear()) {

                    swap(books, j, j + 1);
                }
            }
        }
    }

    /**
     * Swaps two books in a list.
     *
     * @param books the list of books
     * @param firstIndex the first index
     * @param secondIndex the second index
     */
    private static void swap(
            ArrayList<Book> books,
            int firstIndex,
            int secondIndex) {

        Book temporary = books.get(firstIndex);

        books.set(firstIndex, books.get(secondIndex));
        books.set(secondIndex, temporary);
    }
}
