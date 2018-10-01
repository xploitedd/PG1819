import java.util.Scanner;

public class Pay {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Valor da compra (em euros)? ");
		
		/*
		* 0.005f arredonda o valor se necessário
		* para indicar float devemos usar f (de float) no fim do número decimal
		*/
		float cEuros = s.nextFloat();
		int cCents = (int) ((cEuros + 0.005f) * 100);
		System.out.println("Preço (em cêntimos) = " + cCents);
		
		System.out.print("Pagamento (em euros)? ");
		float pEuros = s.nextFloat();
		
		if (pEuros >= cEuros) {
			int pCents = (int) ((pEuros + 0.005f) * 100);
			System.out.println("Valor pago (em cêntimos) = " + pCents);
			int demasia = pCents - cCents;
			
			// 2 euros = 200 cents
			if (demasia > 0) {
				System.out.println("Demasia (em cêntimos) = " + demasia);
				
				int doisEuros = (int) (demasia / 200);
				demasia = demasia % 200;
				// usar restos para calcular o restante troco
				int cinqCent = (int) (demasia / 50);
				
				demasia = demasia % 50;
				int dezCent = (int) (demasia / 10);
				int umCent = (int) (demasia % 10);
				
				// verifica se o troco numa certa moeda é >= que 1, e caso o seja imprime na consola
				if (doisEuros >= 1)
					System.out.println(doisEuros + " moeda(s) de 2€");
				
				if (cinqCent >= 1)
					System.out.println(cinqCent + " moeda(s) de 50c");
				
				if (dezCent >= 1)
					System.out.println(dezCent + " moeda(s) de 10c");
				
				if (umCent >= 1)
					System.out.println(umCent + " moeda(s) de 1c");
				
			} else {
				System.out.println("Não	existe troco!");
			}
		} else {
			System.out.println("Este valor não lhe permite pagar a compra!");
		}
	}
}