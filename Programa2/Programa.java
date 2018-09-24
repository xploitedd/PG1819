import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hey! What´s your name?");
        String name = sc.next();
        System.out.printf("And how old are you %s?\n", name);
        byte age = sc.nextByte();
        Person p = new Person(name, age);
        System.out.printf("Person created! Name: %s Age: %d", name, age);
    }

    static class Person {
        public String name;
        public byte age;
    
        public Person(String name, byte age) {
            this.name = name;
            this.age = age;
        }
    }
}