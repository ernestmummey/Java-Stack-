public class Bat extends Mammal{

    public Bat(){
        this.energyLevel = 300;
    }

    public void fly(){
        System.out.println("Wings beating the air");
        this.energyLevel -= 50;
    }

    public void eatHumans(){
        System.out.println("Death");
        this.energyLevel += 25;
    }

    public void attackTown(){
        System.out.println("Screams in the distance");
        this.energyLevel -= 100;
    }
}