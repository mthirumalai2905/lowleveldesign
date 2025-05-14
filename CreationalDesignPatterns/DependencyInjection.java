interface NotificationService {
    void sendMessage(String message);
}

class EmailService implements NotificationService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email Sent: " + message);
    }
}

class SMSService implements NotificationService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS Sent: " + message);
    }
}

class UserController {
    private NotificationService ns;
    
    public UserController(NotificationService ns) {
        this.ns = ns;
    }
    
    public void notifyUser(String message) {
        ns.sendMessage(message);
    }
}

class Main {
    public static void main(String[] args) {
        NotificationService emailService = new EmailService();
        UserController userController = new UserController(emailService);
        userController.notifyUser("Welcome via Email!");
        
        NotificationService smsService = new SMSService();
        UserController userController2 = new UserController(smsService);
        userController2.notifyUser("Welcome via SMS!");
    }
}
