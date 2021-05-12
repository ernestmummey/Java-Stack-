public class Human {
    protected int health = 100;
    protected int strength = 3;
    protected int stealth = 3;
    protected int intelligence = 3;
    // private in variable

    public void attack(Human opponent) {
        System.out.println("this human is attacking");
        opponent.health -= this.strength;
    }
}


