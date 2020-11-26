package com.company.server;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Logger {
    private static Logger logger;
    private final String logFile = "log.txt";
    private final PrintWriter printLine;

    private Logger() throws IOException {
        FileWriter write = new FileWriter(logFile, false);
        printLine = new PrintWriter(write);
    }

    //Returns the logger instance, íf this does not yet exist it will be created.
    public static Logger getLogger() throws IOException {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    //Prints a string to the log file.
    public void writeToLog(String textLine) {
        printLine.printf("%s" + "%n", textLine);
        printLine.flush();
    }

    //Reads the log and returns it in string format.
    public String getLog() throws IOException {
        String log;
        log = new String(Files.readAllBytes(Paths.get(logFile)));
        return log;
    }
}
