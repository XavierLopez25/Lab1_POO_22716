/**
 * @author Aroldo Xavier López Osoy
 * @class Programación Orientada a Objetos
 * @carnet 22716
 */

import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        boolean Program = false;
        int option;

        System.out.println("\nWelcome to our training simulator! What you wanna do today?\n");

        Person person = new Person();
        Dog dog = new Dog();

        while (!Program) {



            System.out.println("Options: \n\t1. Show Person Data ^-^. \n\t2. Show Doggo Data 0_0. \n\t3. Give cookie ^^. \n\t4. Interact with doggo ^^. \n\t5. Create new person ^^. \n\t6. Create new doggo ^^. \n\t7. Exit Program. \n\nEnter your option, please: ");

            option = readInput.nextInt();



            switch (option) {
                case 1 -> showPersonData(person);
                case 2 -> showDoggoData(dog);
                case 3 -> giveCookieDoggo();
                case 4 -> interactWithDoggo(dog, person);
                case 5 -> person = createNewPerson();
                case 6 -> dog = createNewDoggo();
                case 7 -> {
                    Program = true;
                    System.out.println("\n\nExiting program...\n\n");
                }
                default -> System.out.println("\n\nOnly values from 1 to 5 please!\n\n");
            }
        }


    }


    public static void showPersonData(Person person){

        int cookies;

        if (Person.isCookie()){
            cookies = 1;
        }else{
            cookies = 0;
        }

        System.out.println("\n\nPerson:\n\n\tFiability: " + person.getTrust() + "\n\tCookies: " + cookies + "\n\n");
    }

    public static void showDoggoData(Dog doggo){
        System.out.println("\n\nDoggo:\n\n\tMood: " + doggo.getMood() + "\n\tMood Umbral: " + doggo.getMood_umbral() + "\n\n");
    }


    public static Person createNewPerson() {
        System.out.println("\n\nCreando nueva persona...\n\n");
        Person person = new Person();
        showPersonData(person);
        return person;
    }
    public static Dog createNewDoggo() {
        System.out.println("\n\nCreando nuevo perro...\n\n");
        Dog doggo = new Dog();
        showDoggoData(doggo);
        return doggo;
    }

    public static int giveCookieDoggo(){

        if(Person.isCookie()){
            System.out.println("\n\nYou gave a cookie to the doggo, its mood seems to improve...\n\n");
            return 5;
        }else{
            System.out.println("\n\nSorry, we ran out of cookies :(\n\n");
            return 0;
        }

    }

    public static void interactWithDoggo(Dog dog, Person person){
        if(dog.getMood()<dog.getMood_umbral()) {
            dog.DoggoBites();
            person.setTrust(person.getTrust()-5);

            if (person.getTrust()<0){
                person.runsScared();
            }else {
                person.sobs();
                showPersonData(person);
                showDoggoData(dog);
            }
        }
        else if ((dog.getMood()<0)&&(dog.getMood()>dog.getMood_umbral())){
            {
                dog.DoggoBarks();
                if(Person.isCookie()){
                    person.fearAndCookie();
                    dog.setMood(dog.getMood() + giveCookieDoggo());
                }else{
                    person.fear();
                }
                showDoggoData(dog);
                showPersonData(person);

            }
        }
        else if (dog.getMood()>0){
            dog.DoggoMovesTail();
            person.patDoggo();
        }

        dog.psican(person);

    }

}

