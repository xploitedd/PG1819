public class Programa {
    public static void main(String[] args) {
        int[] pesos = { 1, 5, 10, 50, 100, 500, 1000 };
        char[] roman = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int conta = 0;
        for (String s : args) {
            char[] inch = s.toCharArray();
            for (int i = 0; i < inch.length; ++i) {
                int j = 0;
                while (j < roman.length) {
                    if (roman[j] == inch[i]) {
                        ++j;
                        break;
                    }
                }

                int k = 0;
                if (i + 1 != inch.length) {
                    while (k < roman.length) {
                        if (roman[k] == inch[i + 1]) {
                            ++k;
                            break;
                        }
                    }
                }

                if (k > j) {

                } else {
                    conta += j;
                }
            }
        }

        System.out.println("Conta: " + conta);
    }
}