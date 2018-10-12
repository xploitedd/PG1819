import java.util.Scanner;

public class Number{
	public static void main(String[] args){
		System.out.print("Valor (0..9999)?	");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int numk = num/1000 ;
		int numc = (num)/100 - (numk * 10);
		int numd = (num)/10 - (numk * 100) - (numc * 10);
		int numu = num - (numk * 1000) - (numc * 100) - (numd * 10);
		System.out.print(num + " = " + numk + " milhar(es) + " + numc + " centena(s) + " + numd +  " dezena(s) + " + numu +" unidade(s)");
	}
}