import java.util.Scanner;

public class Slope {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("(x1 y1) : ");
		float x1 = in.nextFloat();
		float y1 = in.nextFloat();
		System.out.print("(x2 y2) : ");
		float x2 = in.nextFloat();
		float y2 = in.nextFloat();
		String out = "x = " + x1;
		
		if(x1 == x2 && y1 == y2) {
			out = "Não é possivel determinar uma equação com o mesmo ponto";
		} else if (x1 != x2) {
			float m = (y2 - y1)/(x2 - x1);
			out = "y = " + m + "x + " + (y1 - m*x1);
		}

		System.out.println(out);
	}
}
