import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Numero ? ");
        int n = s.nextInt();
        int c = 0, ns = 0, a = n;

        while (n > 0) {
            c *= 10;
            c += n % 10;
            n /= 10;
            ++ns;
        }

        if (c == a)
            System.out.println("Este numero e uma capicua! " + c);

        System.out.println("Tem " + ns + " digitos!");
    }
}