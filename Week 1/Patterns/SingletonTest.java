class Logger {
    private static Logger instance = new Logger();
    
    private Logger() {
        System.out.println("Logger created!");
    }
    
    public static Logger getInstance() {
        return instance;
    }
    
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        System.out.println("Same instance? " + (logger1 == logger2));
        
        logger1.log("Hello from logger1");
        logger2.log("Hello from logger2");
    }
}