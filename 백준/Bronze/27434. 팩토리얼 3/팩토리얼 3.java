import java.util.Scanner;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(fact(1, n));
		
		sc.close();
	}
	
	public static BigInteger fact(int a, int n) {
		
		BigInteger mul = BigInteger.valueOf(a);
		
		if(a < n) {
			int b = (a + n) / 2;
			mul = fact(a, b).multiply(fact(b + 1, n));
		}
		
		return mul;
	}
}