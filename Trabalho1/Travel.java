import java.util.Scanner;

public class Travel{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Partida? ");
		int hp = in.nextInt();
		int mp = in.nextInt();
		int sp = in.nextInt();
		
		System.out.print("Chegada? ");
		int hc = in.nextInt();
		int mc = in.nextInt();
		int sc = in.nextInt();
		
		hc = hc - hp;
		mc = mc - mp;
		sc = sc - sp;
		if (hc < 0 || (hc == 0 && mc < 0) || (hc == 0 && mc == 0 && sc == 0)) {
			System.out.println("Partida > Chegada");
		} else {
			if (mc < 0) {
				mc += 60;
				--hc;
			}

			if (sc < 0) {
				sc += 60;
				--mc;
			}

			System.out.print("Duração = " + hc + ":" + mc + ":" + sc);
		}
	}
}