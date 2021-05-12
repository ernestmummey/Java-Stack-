public class Wizard extends Human{
    public Wizard(){
        this.health = 50;
        this.intelligence = 8;
    }

    public void heal(Human opponent){
        opponent.health += this.intelligence;
    }

    public void fireball(Human opponent){
        opponent.health -= this.intelligence * 3;
    }

}