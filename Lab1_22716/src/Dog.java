import java.util.Random;

public class Dog {

    private float mood;
    private int mood_umbral;

    public float getMood() {
        return mood;
    }

    public void setMood(float mood) {
        this.mood = mood;
    }

    public int getMood_umbral() {
        return mood_umbral;
    }

    public void setMood_umbral(int mood_umbra) {
        this.mood_umbral = mood_umbra;
    }

    public Dog(){
        Random rand = new Random();
        mood = rand.nextFloat() * 10 - 5;
        mood_umbral = rand.nextInt(20)*-1;
    }

    public void DoggoBites(){
        System.out.println("\nThe doggo bit you...\n");
    }

    public void DoggoBarks(){
        System.out.println("\nThe doggo has barked at you...\n");
    }

    public void DoggoMovesTail(){
        System.out.println("\nThe doggo seems to be happy with you *the doggo wags its tail*\n");
    }




}
