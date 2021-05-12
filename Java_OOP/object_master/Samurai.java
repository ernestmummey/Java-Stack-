public class Samurai extends Human{
    public static int numSamurai = 0;

    public Samurai(){
        this.health = 200;
        Samurai.numSamurai += 1;
    }

    public void deathBlow(Human opponent){
        System.out.println("Your dead bro");
        opponent.health -=  opponent.health;
        this.health /= 2;
    }

    public void meditate(){
        this.health += this.health / 2;
        
    }

    public int howMany(){
        return Samurai.numSamurai;
    }
}