import java.util.Scanner;

public class Dice{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int d1 = (int)((Math.random() * 6) + 1);
		System.out.println("Primeiro dado = [" + d1 + "]");
		int d2 = (int)((Math.random() * 6) + 1);
		System.out.println("\nPrima enter.");
		in.nextLine();
		System.out.print("Segundo dado = [" + d2 + "]");
		System.out.println("\nTotal" + (d1 == d2 ? " a dobrar = " + (d1 * 4) : " = " + (d1 + d2)));

	}	
}