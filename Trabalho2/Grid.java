import java.util.Scanner;

public class Grid {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] maxrange = { 5, 8, 3, 5 };
        int[] minrange = { 2, 2, 1, 1 };
        int[] values = new int[4];

        String[] names = { "Linhas", "Colunas", "Altura", "Largura" };

        for (int i = 0; i < values.length; ++i) {
            int min = minrange[i], max = maxrange[i];

            do {
                System.out.print(names[i] + " (" + min + ".." + max + ")? ");
                values[i] = s.nextInt();
            } while (values[i] < min || values[i] > max);
        }

        int offset = 0;
        int totalLinhas = values[0] * (values[2] + 1) + (values[0] > 1 ? 1 : 0);
        for (int i = 0; i < totalLinhas; ++i) {
            if (i == 0 || i + 1 == totalLinhas) {
                for (int j = 0; j < values[1]; ++j) {
                    if (j == 0)
                        System.out.print("0");

                    for (int k = 0; k < values[3]; ++k)
                        System.out.print("-");

                    System.out.print("0");
                }
            } else if (i - offset - 1 == values[2]) {
                for (int j = 0; j < values[1]; ++j) {
                    if (j == 0)
                        System.out.print("0");

                    for (int k = 0; k < values[3]; ++k)
                        System.out.print("-");

                    if (j + 1 == values[1])
                        System.out.print("0");
                    else
                        System.out.print("+");
                }

                offset += values[2] + 1;
            } else {
                for (int j = 0; j < values[1]; ++j) {
                    if (j == 0)
                        System.out.print("|");

                    for (int k = 0; k < values[3]; ++k)
                        System.out.print(" ");

                    System.out.print("|");
                }
            }

            System.out.println();
        }
    }
}