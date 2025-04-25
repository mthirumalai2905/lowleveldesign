class Logger{
    private static Logger instance;
    
    private Logger(){
        System.out.println("Initializing Logger...");
    }
    
    public static synchronized Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }
    
    public void log(String message){
        System.out.println("[LOG]: " + message);
    }
    
    public static void main(String[] args){
        Logger l1 = Logger.getInstance();
        l1.log("Logging message from l1");
        
        Logger l2 = Logger.getInstance();
        l2.log("Logging message from l2");
        
        System.out.println(l1.hashCode()); // both will be the same
        System.out.println(l2.hashCode()); // both will be the same
    }
}
