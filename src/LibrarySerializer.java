import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Handles serialization and deserialization of the Library.
 */
public class LibrarySerializer {

    private static final String LIBRARY_FILE = "data/library.ser";

    /**
     * Saves the library to a serialized file.
     *
     * @param library the library to save
     */
    public static void saveLibrary(Library library) {

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(
                             new FileOutputStream(LIBRARY_FILE))) {

            outputStream.writeObject(library);

            System.out.println(
                    "Library saved successfully to " + LIBRARY_FILE
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving library: " + e.getMessage()
            );
        }
    }

    /**
     * Loads a library from the serialized file.
     *
     * @return the loaded Library, or null if loading fails
     */
    public static Library loadLibrary() {

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(
                             new FileInputStream(LIBRARY_FILE))) {

            Library library = (Library) inputStream.readObject();

            System.out.println(
                    "Library loaded successfully from " + LIBRARY_FILE
            );

            return library;

        } catch (IOException | ClassNotFoundException e) {

            System.out.println(
                    "Error loading library: " + e.getMessage()
            );

            return null;
        }
    }
}
