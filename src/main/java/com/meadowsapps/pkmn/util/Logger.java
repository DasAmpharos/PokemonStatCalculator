package com.meadowsapps.pkmn.util;

/**
 * Created by dmeadows on 9/9/16
 */
public class Logger {

    /**
     * Boolean flag that holds the debugging state
     */
    private boolean debugging = false;

    /**
     * ANSI escape code to reset the output color
     */
    private final String RESET = "\u001B[0m";

    /**
     * ANSI escape code to set output color to blue
     */
    private final String INFO = "\u001B[34m";

    /**
     * ANSI escape code to set output color to yellow
     */
    private final String WARNING = "\u001B[33m";

    /**
     * ANSI escape code to set output color to red
     */
    private final String ERROR = "\u001B[31m";

    /**
     * ANSI escape code to set output color to green
     */
    private final String DEBUG = "\u001B[32m";

    /**
     * Singleton logger instance
     */
    private static Logger logger = new Logger();

    /**
     * Creates a new Logger instance
     */
    private Logger() {
    }

    /**
     * Logs the specified message to the console as a normal log message
     *
     * @param message the message to log
     */
    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    /**
     * Logs the specified <code>Throwable</code> to the console as a
     * normal log message
     *
     * @param t the <code>Throwable</code> instance to log
     */
    public void log(Throwable t) {
        System.out.println("LOG: " + t.getMessage());
        t.printStackTrace(System.out);
    }

    /**
     * Logs the specified message and the specified <code>Throwable</code>
     * to the console as a normal log message
     *
     * @param message the message to log
     * @param t       the <code>Throwable</code> instance to log
     */
    public void log(String message, Throwable t) {
        System.out.println("LOG: " + message);
        t.printStackTrace(System.out);
    }

    /**
     * Logs the specified message to the console as an information message
     *
     * @param message the message to log
     */
    public void info(String message) {
        System.out.println(INFO + "INFO: " + message + RESET);
    }

    /**
     * Logs the specified <code>Throwable</code> to the console as an
     * information messsage
     *
     * @param t the <code>Throwable</code> instance to log
     */
    public void info(Throwable t) {
        System.out.println(INFO + "INFO: " + t.getMessage());
        t.printStackTrace(System.out);
        System.out.print(RESET);
    }

    /**
     * Logs the specified message and the specified <code>Throwable</code>
     * to the console as an information message
     *
     * @param message the message to log
     * @param t       the <code>Throwable</code> instance to log
     */
    public void info(String message, Throwable t) {
        System.out.println(INFO + "INFO: " + message);
        t.printStackTrace(System.out);
        System.out.print(RESET);
    }

    /**
     * Logs the specified message to the console as a warning message
     *
     * @param message the message to log
     */
    public void warn(String message) {
        System.out.println(WARNING + "WARN: " + message + RESET);
    }

    /**
     * Logs the specified <code>Throwable</code> to the console as a
     * warning messsage
     *
     * @param t the <code>Throwable</code> instance to log
     */
    public void warn(Throwable t) {
        System.out.println(WARNING + "WARN: " + t.getMessage());
        t.printStackTrace(System.out);
        System.out.print(RESET);
    }

    /**
     * Logs the specified message and the specified <code>Throwable</code>
     * to the console as a warning message
     *
     * @param message the message to log
     * @param t       the <code>Throwable</code> instance to log
     */
    public void warn(String message, Throwable t) {
        System.out.println(WARNING + "WARN: " + message);
        t.printStackTrace(System.out);
        System.out.print(RESET);
    }

    /**
     * Logs the specified message to the console as an error message
     *
     * @param message the message to log
     */
    public void error(String message) {
        System.out.println(ERROR + "ERROR: " + message + RESET);
    }

    /**
     * Logs the specified <code>Throwable</code> to the console as an
     * error message
     *
     * @param t the <code>Throwable</code> instance to log
     */
    public void error(Throwable t) {
        System.out.println(ERROR + "ERROR: " + t.getMessage());
        t.printStackTrace(System.out);
        System.out.print(RESET);
    }

    /**
     * Logs the specified message and the specified <code>Throwable</code>
     * to the console as an error message
     *
     * @param message the message to log
     * @param t       the <code>Throwable</code> to log
     */
    public void error(String message, Throwable t) {
        System.out.println(ERROR + "ERROR: " + message);
        t.printStackTrace(System.out);
        System.out.print(RESET);
    }

    /**
     * Logs the specified message to the console as a debug message
     * if debugging is turned on
     *
     * @param message the message to log
     */
    public void debug(String message) {
        if (isDebugging()) {
            System.out.println(DEBUG + "DEBUG: " + message + RESET);
        }
    }

    /**
     * Logs the specified <code>Throwable</code> to the console as a
     * debug message if debugging is turned on
     *
     * @param t the <code>Throwable</code> to log
     */
    public void debug(Throwable t) {
        if (isDebugging()) {
            System.out.println(DEBUG + "DEBUG: " + t.getMessage());
            t.printStackTrace(System.out);
            System.out.print(RESET);
        }
    }

    /**
     * Logs the specified message and the specified <code>Throwable</code>
     * to the console as a debug message if debugging is turned on
     *
     * @param message the message to log
     * @param t       the <code>Throwable</code> to log
     */
    public void debug(String message, Throwable t) {
        if (isDebugging()) {
            System.out.println(DEBUG + "DEBUG: " + message);
            t.printStackTrace(System.out);
            System.out.print(RESET);
        }
    }

    /**
     * Gets if the logger has debugging turned on
     *
     * @return if debugging is turned on
     */
    public boolean isDebugging() {
        return debugging;
    }

    /**
     * Sets if the logger is logging debug messages or not
     *
     * @param debugging determines if the logger should log debug
     *                  messages or not
     */
    public void setDebugging(boolean debugging) {
        this.debugging = debugging;
    }

    /**
     * Gets the singleton Logger instance
     *
     * @return the Logger singleton instance
     */
    public static Logger getLogger() {
        return logger;
    }

}