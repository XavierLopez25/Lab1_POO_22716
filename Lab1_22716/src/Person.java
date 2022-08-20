import java.util.Random;
import java.util.Scanner;

public class Person {

    Scanner sc = new Scanner(System.in);
    private static int trust;
    private static boolean cookie;

    public Person(){

        trust = generateFiability();
        cookie = hasCookie();

    }

    public int generateFiability(){
        Random rand = new Random();
        return rand.nextInt(9)+1;
    }

    public boolean hasCookie(){
        int hasAnyCookie;
        boolean _cookie;
        Random rand = new Random();
        hasAnyCookie = rand.nextInt(2);

        _cookie = hasAnyCookie == 0;

        return _cookie;

    }

    public void runsScared(){
        System.out.println("\n*the person runs scared*\n");
    }

    public void sobs(){
        System.out.println("\n*the person sobs and the doctor checks the person*\n");
    }

    public void fearAndCookie(){
        System.out.println("\n*the person gets scared and tries to give a cookie to the doggo*\n");
    }

    public void fear(){
        System.out.println("*the person gets scared by the doggo* \n");
    }

    public void patDoggo(){
        System.out.println("\n*the person pats the doggo and seems happy*\n");
    }


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
