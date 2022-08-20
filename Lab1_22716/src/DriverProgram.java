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

        Dog dog = new Dog();
        Person person = new Person();

        while (!Program) {



            System.out.println("Options: \n\t1. New Person ^-^. \n\t2. New Doggo 0_0. \n\t3. Give cookie ^^. \n\t4. Interact with doggo ^^. \n\t5. Exit Program. \n\nEnter your option, please: ");

            option = readInput.nextInt();

            switch (option) {
                case 1:
                    showPersonData(person);
                    break;
                case 2:
                    showDoggoData(dog);
                    break;
                case 3:
                    giveCookieDoggo(person);
                    break;
                case 4:
                    interactWithDoggo(dog, person);
                    break;
                case 5:
                    Program = true;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Only values from 1 to 5 please!");
            }
        }


    }


    public static void showPersonData(Person person){

        int cookies;

        if (person.isCookie()){
            cookies = 1;
        }else{
            cookies = 0;
        }

        System.out.println("Person:\n\n\tFiability: " + person.getTrust() + "\n\tCookies: " + cookies);
    }

    public static void showDoggoData(Dog doggo){
        System.out.println("Doggo:\n\n\tMood: " + doggo.getMood() + "\n\tMood Umbral: " + doggo.getMood_umbral());
    }
//    public static Person createNewPerson() {
//        Person person = new Person();
//        showPersonData(person);
//        return person;
//    }
//    public static Dog createNewDoggo() {
//        Dog doggo = new Dog();
//        showDoggoData(doggo);
//        return doggo;
//    }

    public static int giveCookieDoggo(Person person){

        if(person.isCookie()){
            System.out.println("You gave a cookie to the doggo, its mood seems to improve...");
            return 5;
        }else{
            System.out.println("Sorry, we ran out of cookies :(");
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
                if(person.isCookie()){
                    person.fearAndCookie();
                    dog.setMood(dog.getMood() + giveCookieDoggo(person));
                    showDoggoData(dog);
                    showPersonData(person);
                }else{
                    person.fear();
                    showDoggoData(dog);
                    showPersonData(person);
                }

            }
        }
        else if (dog.getMood()>0){
            dog.DoggoMovesTail();
            person.patDoggo();
        }

    }

}

