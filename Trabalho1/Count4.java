import java.util.Scanner;

public class Count4{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("4 valores?");
		int num1 = in.nextInt() ;
		int num2 = in.nextInt() ;
		int num3 = in.nextInt() ;
		int num4 = in.nextInt() ;
		int imp = (num1 % 2) + (num2 % 2) + (num3 % 2) + (num4 % 2);
		int par = 4 - imp;
		if( num1==num2 && num2==num3 && num3==num4)
			System.out.print("Iguais:4");
		else if((num1==num2 && num1==num3) || (num1==num3 && num1==num4) || (num2==num3 && num2==num4) || (num3==num1 && num3==num4) || (num2==num1 && num2==num4))
			System.out.print("Iguais:3");
			else if(num1==num2 || num1==num3 || num1==num4 || num2==num3 || num2==num4 || num3==num4)
				System.out.print("Iguais:2");
				else 
					System.out.print("Iguais:0");

		System.out.print(" Pares:" + par + " Impares" + imp);
	}
}