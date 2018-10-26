import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] vals = new int[10];
        int sum = 0, values = 0;
        while (s.hasNextInt())
            sum += vals[values++] = s.nextInt();

        float avg = (values > 0) ? (float) sum / values : 0;
        int gtha = 0;
        for (int i = 0; i < values; ++i) {
            if (vals[i] > avg)
                ++gtha;
        }

        System.out.println("A media e " + avg + ". Existem " + gtha + " valores maiores que a media!"); 
    }
}