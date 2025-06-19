import java.util.Scanner;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		BigInteger c, d, t1, t2;

		c = a.divide(BigInteger.valueOf(2)).multiply(b);
		d = a.multiply(b).subtract(c);
		if(c.compareTo(d) == 1) {
			t1 = c.subtract(d);
		}else {
			t1 = d.subtract(c);
		}
		
		c = b.divide(BigInteger.valueOf(2)).multiply(a);
		d = a.multiply(b).subtract(c);
		if(c.compareTo(d) == 1) {
			t2 = c.subtract(d);
		}else {
			t2 = d.subtract(c);
		}
		
		if(t1.compareTo(t2) == 1) {
			System.out.println(t2);
		}else {
			System.out.println(t1);
		}
		sc.close();
	}
}