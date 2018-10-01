import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Valor (0..9999)? ");
        int valor = s.nextInt();
        String mensagemFinal = "O valor apresentado não se encontra entre 0 e 9999";
        if (valor >= 0 && valor <= 9999) {
            int vCopy = valor;
            int milhares = (int) (valor / 1000);
            valor = valor - milhares * 1000;
            int centenas = (int) (valor / 100);
            valor = valor - centenas * 100;
            int dezenas =  (int) (valor / 10);
            valor = valor - dezenas * 10;

            mensagemFinal = vCopy + " = " + milhares + " milhar(es) + " + centenas + " centena(s) + " + dezenas + " dezena(s) + " + valor + " unidade(s).";
        }

        System.out.println(mensagemFinal);
    }
}