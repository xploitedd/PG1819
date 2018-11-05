import java.util.Scanner;

public class Payment {
    public static void main(String[] args) {
        int[] pesos = { 200, 100, 50, 20, 10, 5, 2, 1 };
        int[] moedas = new int[pesos.length];

        int mds = 0;
        String arg = args[0];
        for (int i = 0; i < arg.length(); ++i) {
            char c = arg.charAt(i);
            mds *= 10;
            mds += (c - '0');
        }

        for (int i = 0; i < moedas.length; ++i)
            moedas[i] = mds;

        System.out.println("Máquina carregada com " + mds + " moeda" + (mds > 1 ? "s" : "") + " de cada tipo.");

        Scanner s = new Scanner(System.in);
        for ( ; ; ) {
            System.out.print("Preço (em euros)? ");
            int pr = (int) (s.nextDouble() * 100);
            if (pr == 0)
                break;

            System.out.print("Quantia recebida (em euros)? ");
            int qnt = (int) (s.nextDouble() * 100);

            if (qnt == pr) {
                System.out.println("Quantia certa.");
            } else if (qnt < pr) {
                System.out.println("Quantia insuficiente!");
            } else {
                int troco = qnt - pr;
                int tr = troco;
                int[] moedasUsadas = new int[pesos.length];

                for (int i = 0; i < moedas.length; ++i) {
                    if (moedas[i] > 0) {
                        if (pesos[i] == troco) {
                            ++moedasUsadas[i];
                            --moedas[i];
                            troco = 0;
                            break;
                        } else {
                            while(pesos[i] < troco && moedas[i] > 0) {
                                ++moedasUsadas[i];
                                --moedas[i];
                                troco -= pesos[i];
                            }
                        }
                    }
                }

                String demasia = "Demasia: (" + tr / 100.0 + ") = ";
                if (troco > 0) {
                    demasia += "Não há troco. Venda interrompida.";
                    for (int i = 0; i < moedasUsadas.length; ++i) {
                        if (moedasUsadas[i] > 0)
                            ++moedas[i];
                    }
                } else {
                    int last = 0;
                    for (int i = 0; i < moedasUsadas.length; ++i) {
                        if (moedasUsadas[i] > 0)
                            last = i;
                    }

                    for (int i = 0; i < moedasUsadas.length; ++i) {
                        if (moedasUsadas[i] > 0) {
                            demasia += moedasUsadas[i] + " x " + (pesos[i] < 100 ? pesos[i] + "c" : pesos[i] / 100 + "€") 
                                + (i == last ? "" : " + ");
                        }
                    }
                }

                System.out.println(demasia);
            }
        }
    }
}