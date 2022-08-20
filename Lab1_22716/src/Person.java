import java.util.Random;
import java.util.Scanner;

public class Person {

    Scanner sc = new Scanner(System.in);

    //Variable que almacenara la confiabilidad de la persona
    private static int trust;

    //Variable que almacenara si la persona tiene una galleta o no
    private static boolean cookie;

    //Constructo del objeto Person
    public Person(){

        trust = generateFiability();
        cookie = hasCookie();

    }

    //Metodo que genera la confiabilidad de la persona
    public int generateFiability(){
        Random rand = new Random();
        return rand.nextInt(9)+1;
    }

    //Metodo que genera si la persona tendra una galleta
    public boolean hasCookie(){
        int hasAnyCookie;
        boolean _cookie;
        Random rand = new Random();
        hasAnyCookie = rand.nextInt(2);

        _cookie = hasAnyCookie == 0;

        return _cookie;

    }

    //Metodo que muestra la accion de la persona
    public void runsScared(){
        System.out.println("\n*the person runs scared*\n");
    }

    //Metodo que muestra la accion de la persona
    public void sobs(){
        System.out.println("\n*the person sobs and the doctor checks the person*\n");
    }

    //Metodo que muestra la accion de la persona
    public void fearAndCookie(){
        System.out.println("\n*the person gets scared and tries to give a cookie to the doggo*\n");
    }

    //Metodo que muestra la accion de la persona
    public void fear(){
        System.out.println("*the person gets scared by the doggo* \n");
    }

    //Metodo que muestra la accion de la persona
    public void patDoggo(){
        System.out.println("\n*the person pats the doggo and seems happy*\n");
    }

    //Getters y Setters de Trust y Cookie
    public int getTrust() {
        return trust;
    }

    public void setTrust(int trust) {
        Person.trust = trust;
    }

    public static boolean isCookie() {
        return cookie;
    }

    public void setCookie(boolean cookie) {
        Person.cookie = cookie;
    }
}
