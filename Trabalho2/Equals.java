import java.util.Scanner;

public class Equals {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int counter = 0;
        int[] numbers = new int[20];
        for (int i = 0; s.hasNextInt(); ++i) {
            if (i == numbers.length) {
                int[] temp = numbers;
                numbers = new int[numbers.length + 20];
                for (int j = 0; j < temp.length; ++j)
                    numbers[j] = temp[j];
            }

            numbers[i] = s.nextInt();
            ++counter;
        }

        int equals = 0;
        for (int i = 0; i < counter; ++i) {
            for (int j = 0; j < counter; ++j) {
                if (i != j && numbers[i] == numbers[j])
                    System.out.println(i + " " + j);
            }
        }

        System.out.println(equals);
    }
}