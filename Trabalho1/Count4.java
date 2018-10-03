import java.util.Scanner;

public class Count4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("4 valores? ");
        int iguais = 0;
        int pares = 0;
        int v1 = s.nextInt();
        if (v1 % 2 == 0)
            pares = pares + 1;

        int v2 = s.nextInt();
        if (v2 == v1)
            iguais = iguais + 2;

        if (v2 % 2 == 0)
            pares = pares + 1;

        int v3 = s.nextInt();
        if (iguais == 2 && v3 == v1)
            iguais = iguais + 1;
        else if (v3 == v2 || v3 == v1)
            iguais = iguais + 2;

        if (v3 % 2 == 0)
            pares = pares + 1;
            
        int v4 = s.nextInt();
        if (iguais == 3 && v4 == v1)
            iguais = iguais + 1;
        else if (iguais == 2 && v4 == v3)
            iguais = iguais + 1;
        else if (v4 == v3 || v4 == v2 || v4 == v1)
            iguais = iguais + 2;

        if (v4 % 2 == 0)
            pares = pares + 1;

        System.out.println("Iguais: " + iguais + " Pares: " + pares + " Impares: " + (4 - pares));
    }
}