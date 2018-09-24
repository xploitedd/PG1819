import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Hello! I'm a Java program!\n");
        System.out.printf("What is your name?\n> ");
        String name = in.next();
        System.out.printf("And how old are you mate?\n> ");
        byte age = in.nextByte();
        String agePrefix = (age < 30) ? "young" : "old";
        System.out.printf("Hello %s, it seems you are quite %s!\nNice to meet you!", name, agePrefix);
    }
}