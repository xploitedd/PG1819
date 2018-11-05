import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a, b, c, r;
        boolean cont;

        do {
            a = (int) (Math.random() * 10);
            b = (int) (Math.random() * 10);
            c = (int) (Math.random() * 2);
            System.out.print(a + " " + (c == 0 ? '+' : '-') + " " + b + " = ");
            r = s.nextInt();
            System.out.println("Resposta " + ((c == 0 ? a + b : a - b) == r ? "certa" : "errada"));
            System.out.print("Queres continuar (S/N) ? ");
            cont = s.next().toLowerCase().charAt(0) == 's';
        } while (cont);

        System.out.println("Thanks for playing mate!");
    }
}