import java.util.Random;

public class Dog {

    private static float mood;
    private static int mood_umbral;

    public float getMood() {
        return mood;
    }

    public void setMood(float mood) {
        Dog.mood = mood;
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


    public void psican(Person person){
        Random rand = new Random();
        mood = (float) ((1.0/person.getTrust()) * (rand.nextFloat() - 0.5) * 10 + mood);

        if(Person.isCookie()){
            mood += (1.0 / person.getTrust()) * rand.nextInt(2);
        }

        System.out.println("\nMy new mood is: " + mood + ".\n\n");

    }

}
