import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        int c = (int) (Math.random() * 2);
        System.out.print(a + " " + (c == 0 ? '+' : '-') + " " + b + " = ");
        int r = s.nextInt();
        System.out.println("Resposta " + ((c == 0 ? a + b : a - b) == r ? "certa" : "errada"));
    }
}