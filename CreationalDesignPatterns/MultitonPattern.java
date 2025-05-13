import java.util.HashMap;
import java.util.Map;

// here we create multiple instances of only one of a kind (Main Oven) -> Oven1, Oven2, Oven3 just a subtype we can use another overs when one is being occupied
// Used in DataBase Connections
class Oven {
    private static final Map<String, Oven> ovens = new HashMap<>();
    private String ovenName;

    private Oven(String ovenName) {
        this.ovenName = ovenName;
    }

    public static Oven getOven(String key) {
        if (!ovens.containsKey(key)) {
            ovens.put(key, new Oven(key));  // Create a new oven only if it doesn't exist
        }
        return ovens.get(key);
    }

    public String getOvenName() {
        return ovenName;
    }
}

public class PizzaShop {
    public static void main(String[] args) {
        Oven oven1 = Oven.getOven("Oven1");
        Oven oven2 = Oven.getOven("Oven2");
        Oven anotherOven1 = Oven.getOven("Oven1");

        System.out.println(oven1.getOvenName());   // Output: Oven1
        System.out.println(oven2.getOvenName());   // Output: Oven2
        System.out.println(anotherOven1.getOvenName());  // Output: Oven1

        // Check if the same instance is returned
        System.out.println(oven1 == anotherOven1);  // Output: true
        System.out.println(oven1 == oven2);         // Output: false
    }
}
