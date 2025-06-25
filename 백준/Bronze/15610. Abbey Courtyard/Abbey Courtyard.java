import java.util.Scanner;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		double result = Math.sqrt(a);
		result = result * 4;
		
		System.out.println(result);
		sc.close();
	}
}