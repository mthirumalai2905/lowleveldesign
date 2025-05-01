public class CommandPatternSimple {
    
    interface Command {
        void execute();
    }

    static class Light {
        public void on() {
            System.out.println("Light is ON");
        }

        public void off() {
            System.out.println("Light is OFF");
        }
    }

    static class TurnOnCommand implements Command {
        private Light light;

        TurnOnCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.on();
        }
    }

    static class TurnOffCommand implements Command {
        private Light light;

        TurnOffCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.off();
        }
    }

    public static void main(String[] args) {
        Light light = new Light();

        Command turnOn = new TurnOnCommand(light);
        Command turnOff = new TurnOffCommand(light);

        turnOn.execute();
        turnOff.execute();
    }
}
