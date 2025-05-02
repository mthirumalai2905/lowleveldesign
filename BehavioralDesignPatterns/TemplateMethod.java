public class Main {

    abstract static class Beverage {
        public final void prepare() {
            boilWater();
            brew();
            pourInCup();
            addCondiments();
        }

        void boilWater() {
            System.out.println("Boiling water");
        }

        void pourInCup() {
            System.out.println("Pouring into cup");
        }

        abstract void brew();
        abstract void addCondiments();
    }

    static class Tea extends Beverage {
        void brew() {
            System.out.println("Steeping the tea");
        }

        void addCondiments() {
            System.out.println("Adding lemon");
        }
    }

    static class Coffee extends Beverage {
        void brew() {
            System.out.println("Dripping coffee through filter");
        }

        void addCondiments() {
            System.out.println("Adding sugar and milk");
        }
    }

    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.prepare();

        System.out.println();

        Beverage coffee = new Coffee();
        coffee.prepare();
    }
}
