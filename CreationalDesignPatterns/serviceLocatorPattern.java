// Service Interface
public interface Service {
    void execute();
}

// Concrete Services
class EmailService implements Service {
    @Override
    public void execute() {
        System.out.println("Executing Email Service");
    }
}

class SMSService implements Service {
    @Override
    public void execute() {
        System.out.println("Executing SMS Service");
    }
}

// Service Locator
class ServiceLocator {
    private static final Map<String, Service> serviceRegistry = new HashMap<>();

    static {
        // Register services
        serviceRegistry.put("Email", new EmailService());
        serviceRegistry.put("SMS", new SMSService());
    }

    // Get service from the registry
    public static Service getService(String serviceName) {
        return serviceRegistry.get(serviceName);
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        // Using the Service Locator to get and use services
        Service emailService = ServiceLocator.getService("Email");
        emailService.execute();  // Output: Executing Email Service

        Service smsService = ServiceLocator.getService("SMS");
        smsService.execute();  // Output: Executing SMS Service
    }
}
