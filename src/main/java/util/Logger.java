package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private final String logFile;
    private static Logger instance = new Logger("hello.txt");

    private Logger(String logFile){
        this.logFile = logFile;
    }

    public Logger getInstance(String logFile){
        synchronized(Logger.class){
            if(instance==null){
                instance = new Logger(logFile);
            }
        }
        return instance;
    }

    public void log(String data) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logFile)))) {
            out.write(data);
        }
    }


    }
