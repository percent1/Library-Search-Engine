import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Records user activity in the Library Search Engine.
 */
public class ActivityLogger {

    private static final String LOG_DIRECTORY = "logs";
    private static final String LOG_FILE =
            LOG_DIRECTORY + File.separator + "library_activity.log";

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Records a user action in the activity log.
     *
     * @param action the action performed by the user
     */
    public static void log(String action) {

        File directory = new File(LOG_DIRECTORY);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(LOG_FILE, true))) {

            String timestamp =
                    LocalDateTime.now().format(FORMATTER);

            writer.println(timestamp + " - " + action);

        } catch (IOException e) {

            System.out.println(
                    "Unable to write activity log: " +
                    e.getMessage()
            );
        }
    }
}
