import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Intervalo A? ");
        int a1 = s.nextInt(), a2 = s.nextInt();
        System.out.print("Intervalo B? ");
        int b1 = s.nextInt(), b2 = s.nextInt();
        int min1 = a1, max1 = b1;
        if (min1 > b1) {
            min1 = b1;
            max1 = a1;
        }

        int min2 = a2, max2 = b2;
        if (min2 > b2) {
            min2 = b2;
            max2 = a2;
        }

        
    }
}