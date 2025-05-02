public class Main{
    interface State{
        void handle();
    }
    static class OffState implements State{
        @Override
        public void handle(){
            System.out.println("Fan is Off");
        }
    }
    static class LowState implements State{
        @Override
        public void handle(){
            System.out.println("Fan is on Low Speed");
        }
    }
    static class MediumState implements State{
        @Override
        public void handle(){
            System.out.println("Fan is on Medium Speed");
        }
    }
    static class Fan{
        private State[] states = {new OffState(), new LowState(), new MediumState() };
        private int current = 0;
        
        public void pullCord(){
            states[current].handle();
            current = (current + 1) % states.length;
        }
    }
    public static void main(String[] args){
        Fan fan = new Fan();
        fan.pullCord(); // Off
        fan.pullCord(); // Low
        fan.pullCord(); // Medium
        fan.pullCord(); // Off Again
    }
}
