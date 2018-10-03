import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int pt = (int) (Math.random() * 6 + 1);
        System.out.println("Primeiro dado = [" + pt + "]\nPrima enter");
        s.nextLine();

        /*
        * 0 <= random < 1
        * 0 <= 6 * random < 6
        * 1 <= 6 * random + 1 < 7
        */
        int segundo = (int) (Math.random() * 6 + 1);

        String total = "Total ";
        pt = pt + segundo;
        if (pt == segundo * 2) {
            total = total + "a dobrar ";
            pt = pt * 2;
        }

        System.out.println("Segundo dado = [" + segundo + "]\n" + total + "= " + pt);
    }
}