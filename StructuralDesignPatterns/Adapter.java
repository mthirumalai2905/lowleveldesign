interface NewPrinter {
    void print(String text);
}

class OldPrinter {
    public void printOld(String text) {
        System.out.println("Old Printer Printing: " + text);
    }
}

class PrinterAdapter implements NewPrinter {
    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String text) {
        oldPrinter.printOld(text);
    }
}

public class Main {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter();
        NewPrinter printer = new PrinterAdapter(oldPrinter);
        printer.print("Hello, World!");
    }
}
