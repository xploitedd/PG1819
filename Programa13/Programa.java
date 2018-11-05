import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Numero ? ");
        int n = s.nextInt();
        String r = "";

        do {
            r = n % 2 + r;
            n /= 2;
        } while (n > 0);

        System.out.println("O numero e " + r + " em binario");
    }
}