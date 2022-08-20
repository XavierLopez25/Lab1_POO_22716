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

        //Se crean los objectos Person y Dog por primera vez
        Person person = new Person();
        Dog dog = new Dog();

        while (!Program) {

            //Se le muestran las opciones al usuario

            System.out.println("Options: \n\t1. Show Person Data ^-^. \n\t2. Show Doggo Data 0_0. \n\t3. Give cookie ^^. \n\t4. Interact with doggo ^^. \n\t5. Create new person ^^. \n\t6. Create new doggo ^^. \n\t7. Exit Program. \n\nEnter your option, please: ");

            option = readInput.nextInt();


            //Segun la opcion seleecionada de la persona se realizaran las siguientes acciones
            switch (option) {
                case 1 -> showPersonData(person); //Mostrar los datos de la persona
                case 2 -> showDoggoData(dog); // Mostrar los datos del perro
                case 3 -> giveCookieDoggo(); //Darle una galleta al perro
                case 4 -> interactWithDoggo(dog, person); //Interactuar con el perro
                case 5 -> person = createNewPerson(); //Se crea una nueva persona
                case 6 -> dog = createNewDoggo(); //Se crea un nuevo perro
                case 7 -> { //Se sale del programa
                    Program = true;
                    System.out.println("\n\nExiting program...\n\n");
                }
                default -> System.out.println("\n\nOnly values from 1 to 5 please!\n\n"); //Se muestra una excepcion si la opcion se encuentra fuera del rango de opciones
            }
        }


    }

    //Se crea un metodo para poder asignarle un numero de galletas a la persona y mosrtar sus datos
    public static void showPersonData(Person person){

        int cookies;

        if (Person.isCookie()){
            cookies = 1;
        }else{
            cookies = 0;
        }

        System.out.println("\n\nPerson:\n\n\tFiability: " + person.getTrust() + "\n\tCookies: " + cookies + "\n\n");
    }

    //Se crea un metodo para poder mostrar los datos del perro al usuario
    public static void showDoggoData(Dog doggo){
        System.out.println("\n\nDoggo:\n\n\tMood: " + doggo.getMood() + "\n\tMood Umbral: " + doggo.getMood_umbral() + "\n\n");
    }


    //Se crea un metodo para poder crear una nueva persona cuando se desee
    public static Person createNewPerson() {
        System.out.println("\n\nCreando nueva persona...\n\n");
        Person person = new Person();
        showPersonData(person);
        return person;
    }

    //Se crea un metodo para poder crear un nuevo perro cuando se desee
    public static Dog createNewDoggo() {
        System.out.println("\n\nCreando nuevo perro...\n\n");
        Dog doggo = new Dog();
        showDoggoData(doggo);
        return doggo;
    }

    //Se crea un metodo que realiza la accion de darle una galleta al perro
    public static int giveCookieDoggo(){

        if(Person.isCookie()){
            System.out.println("\n\nYou gave a cookie to the doggo, its mood seems to improve...\n\n");
            return 5;
        }else{
            System.out.println("\n\nSorry, we ran out of cookies :(\n\n");
            return 0;
        }

    }

    //Se crea un metodo que realiza una interaccion con el perro para devolver la reaccion del mismo en base a sus atributos
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

