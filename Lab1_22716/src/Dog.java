import java.util.Random;

public class Dog {

    //Variable que almacenara el animo del perro
    private static float mood;

    //Variable que almacenara el umbral de animo del perro
    private static int mood_umbral;


    //Getters y Setters de mood y mood_umbral
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
        mood_umbral = mood_umbra;
    }

    //Constructor del objeto Dog
    public Dog(){
        Random rand = new Random();
        mood = rand.nextFloat() * 10 - 5;
        mood_umbral = rand.nextInt(20)*-1;
    }


    //Metodo que muestra la accion que realiza el perro hacia la persona
    public void DoggoBites(){
        System.out.println("\nThe doggo bit you...\n");
    }


    //Metodo que muestra la accion que realiza el perro hacia la persona
    public void DoggoBarks(){
        System.out.println("\nThe doggo has barked at you...\n");
    }


    //Metodo que muestra la accion que realiza el perro hacia la persona
    public void DoggoMovesTail(){
        System.out.println("\nThe doggo seems to be happy with you *the doggo wags its tail*\n");
    }

    //Metodo que gestiona el animo/psicologia del perro en base a si se le ha dado una galleta o no para mejorar su estado de animo
    public void psican(Person person){
        Random rand = new Random();
        mood = (float) ((1.0/person.getTrust()) * (rand.nextFloat() - 0.5) * 10 + mood);

        if(Person.isCookie()){
            mood += (1.0 / person.getTrust()) * rand.nextInt(2);
        }

        System.out.println("\nMy new mood is: " + mood + ".\n\n");

    }

}
