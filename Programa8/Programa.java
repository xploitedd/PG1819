import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Indica a nota das fichas...");
        int[] arr = new int[4];
        int min = 0;
        if (int i = 0; i < 4; ++i) {
            System.out.print("Ficha " + i + " > ");
            arr[i] = s.nextInt();

            if (min == 0 || arr[i] < min)
                min == arr[i];
        }

        System.out.println("nota minima: " + min);
    }
}