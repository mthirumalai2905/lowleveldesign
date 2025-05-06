abstract class Logger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int level;
    protected Logger nextLogger;

    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);

    public static Logger getChainOfLoggers() {
        Logger errorLogger = new Logger(ERROR) {
            protected void write(String message) {
                System.out.println("ERROR: " + message);
            }
        };

        Logger debugLogger = new Logger(DEBUG) {
            protected void write(String message) {
                System.out.println("DEBUG: " + message);
            }
        };

        Logger infoLogger = new Logger(INFO) {
            protected void write(String message) {
                System.out.println("INFO: " + message);
            }
        };

        errorLogger.setNext(debugLogger);
        debugLogger.setNext(infoLogger);

        return errorLogger;
    }

    public Logger(int level) {
        this.level = level;
    }

    public static void main(String[] args) {
        Logger loggerChain = Logger.getChainOfLoggers();

        loggerChain.logMessage(Logger.INFO, "This is an informational message.");
        loggerChain.logMessage(Logger.DEBUG, "This is a debug message.");
        loggerChain.logMessage(Logger.ERROR, "This is an error message.");
    }
}
