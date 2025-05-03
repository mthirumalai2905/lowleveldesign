public class Main {

    // Subsystem classes
    static class Engine {
        void start() { System.out.println("Engine started"); }
    }

    static class Lights {
        void turnOn() { System.out.println("Lights turned on"); }
    }

    static class AirConditioner {
        void cool() { System.out.println("AC cooling"); }
    }

    // Facade
    static class Car {
        private Engine engine = new Engine();
        private Lights lights = new Lights();
        private AirConditioner ac = new AirConditioner();

        void startCar() {
            engine.start();
            lights.turnOn();
            ac.cool();
        }
    }

    // Main method
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar(); // Facade call
    }
}
