import java.util.Scanner;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		for(int i = 0; i < a; i++) {
			BigInteger lt = sc.nextBigInteger();
			BigInteger wt = sc.nextBigInteger();
			BigInteger le = sc.nextBigInteger();
			BigInteger we = sc.nextBigInteger();
			
			int compare = lt.multiply(wt).compareTo(le.multiply(we));
			
			if(compare == 1) {
				System.out.println("TelecomParisTech");
			}else if(compare == -1){
				System.out.println("Eurecom");
			}else {
				System.out.println("Tie");
			}
		}
		sc.close();
	}
}