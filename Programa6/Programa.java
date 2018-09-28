import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        double m = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Indica os valores para o cálculo da média aritmética:");
        System.out.println("Quando acabares escreve um número negativo");
        int i = 0;
        double n;
        while((n = s.nextDouble()) >= 0) {
            m += n;
            ++i;
        }

        System.out.println("O valor da média aritmética é : " + m + "/" + i + ": " + m / i);
    }
}