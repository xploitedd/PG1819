import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Pense num numero de 0 a 15.");
        System.out.print("Prima <Enter>");
        s.nextLine();

        int max = 15, min = 0;
        do {
            int m = (min + max + 1) / 2;
            System.out.print("O numero e menor que " + m + " ? (S/N) ");
            char res = s.next().charAt(0);
            if (res == 'S' || res == 's')
                max = m - 1;
            else
                min = m;

        } while (min < max);

        System.out.println("O numero que pensaste foi " + max);
    }
}