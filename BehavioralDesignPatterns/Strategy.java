// Step 1: Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Step 2: Concrete strategy for CreditCard payment
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

// Step 3: Concrete strategy for PayPal payment
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Step 4: Concrete strategy for Bitcoin payment
class BitcoinPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Bitcoin.");
    }
}

// Step 5: Context class that uses a strategy
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Set a different strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Execute the payment
    public void executePayment(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Step 6: Client Code
public class StrategyPatternExample {
    public static void main(String[] args) {
        // Using Credit Card Payment strategy
        PaymentContext paymentContext = new PaymentContext(new CreditCardPayment());
        paymentContext.executePayment(100);

        // Switching to PayPal Payment strategy
        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.executePayment(200);

        // Switching to Bitcoin Payment strategy
        paymentContext.setPaymentStrategy(new BitcoinPayment());
        paymentContext.executePayment(300);
    }
}
