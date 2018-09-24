import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("This is program 5");
        System.out.print("Is that correct? ");
        boolean isTrue = s.nextBoolean();
        if (isTrue)
            System.out.println("Noice!");
        else
            System.out.println("What's wrong about it mate?");
    }
}