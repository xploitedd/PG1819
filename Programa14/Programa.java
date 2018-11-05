import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Numero binario ? ");
        String bin = s.next();
        int res = 0, mp = 1;

        for (int i = bin.length() - 1; i >= 0; --i) {
            res += (bin.charAt(i) - '0') * mp;
            mp <<= 1;
        }

        System.out.println("O numero e " + res + " em decimal");
    }
}