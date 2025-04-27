interface Prototype {
    Prototype clone();
}

class Goblin implements Prototype {
    int health;
    int attackPower;

    Goblin(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    @Override
    public Prototype clone() {
        return new Goblin(this.health, this.attackPower);
    }

    public void display() {
        System.out.println("Goblin -> Health: " + health + ", Attack: " + attackPower);
    }
}

public class Game {
    public static void main(String[] args) {
        Goblin originalGoblin = new Goblin(100, 30);

        Goblin goblin1 = (Goblin) originalGoblin.clone();
        Goblin goblin2 = (Goblin) originalGoblin.clone();

        goblin1.health = 80; // Customize clone 1
        goblin2.attackPower = 40; // Customize clone 2

        originalGoblin.display();
        goblin1.display();
        goblin2.display();
    }
}
