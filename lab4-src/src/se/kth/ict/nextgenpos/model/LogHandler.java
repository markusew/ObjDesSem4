package se.kth.ict.nextgenpos.model;

import java.io.*;
import java.time.*;
import java.time.format.*;

/**
 * This class is responsible for the log.
 */
public class LogHandler {


    private static final String LOG_FILE_NAME
            = "seminar4.txt";
    private PrintWriter logFile;
    
    public LogHandler() throws IOException {
        this.logFile = new PrintWriter(
                new FileWriter(LOG_FILE_NAME), true);
    }
    

    /**
     * Writes log entries.
     *
     * @param entry The log entry.
     */
    public void logException(Exception exception) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
