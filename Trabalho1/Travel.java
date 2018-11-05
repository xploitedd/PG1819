import java.util.Scanner;

public class Travel {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
    	System.out.print("Partida ? ");
		int hp = in.nextInt(), mp = in.nextInt(), sp = in.nextInt(); /* Não há verificação
		dos dados introduzidos pois é dito no enunciado para assumir que estes estejam certos */
		System.out.print("Chegada ? ");
		int hc = in.nextInt(), mc = in.nextInt(), sc = in.nextInt();
		int totalsp = hp * 3600 + mp * 60 + sp; // conversão dos dados introduzidos para segundos
		int totalsc = hc * 3600 + mc * 60 + sc;
		int diffs = totalsc - totalsp;
		
		if(diffs < 0) {
			System.out.println("Partida > Chegada");
		} else {
			int hf = (int) diffs / 3600; // Reposição de segundos para horas e minutos
			diffs = diffs - 3600 * hf;
			int mf = (int) diffs / 60;
			diffs = diffs - 60 * mf;
			System.out.println("Duração = " + hf + ":" + mf + ":" + diffs);
		}
  }
}
