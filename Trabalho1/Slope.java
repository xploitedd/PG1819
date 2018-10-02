import java.util.Scanner;

public class Slope {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("(x1 y1)? ");
        double x1 = s.nextDouble();
        double y1 = s.nextDouble();
        System.out.print("(x2 y2)? ");
        double v1 = s.nextDouble(); // or y2
        double v2 = s.nextDouble(); // or x2

        String out = "x = " + x1;
        if (x1 != v2) {
            v1 = (y1 - v2) / (x1 - v1);
            v2 = y1 - v1 * x1;
            if (v2 > 0)
                out = "y = " + v1 + "x + " + v2;
            else
                out = "y = " + v1 + "x";
        }

        System.out.println(out);
    }
}