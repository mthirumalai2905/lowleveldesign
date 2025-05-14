// Abstract Product 1
interface Button {
    void render();
}

// Abstract Product 2
interface Checkbox {
    void render();
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Product 1 for Windows
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

// Concrete Product 2 for Windows
class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

// Concrete Product 1 for Mac
class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

// Concrete Product 2 for Mac
class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Mac Checkbox");
    }
}

// Concrete Factory 1 for Windows
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory 2 for Mac
class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        // Choose the operating system
        String os = "Windows";  // Can be "Mac" as well
        
        if (os.equals("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        // Create UI components for the selected OS
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}
