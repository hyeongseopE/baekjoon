import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		int aTotal = 0;
		int bTotal = 0;
		
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == 'A') {
				aTotal += a.charAt(i + 1) - 48;
			}
			if(a.charAt(i) == 'B') {
				bTotal += a.charAt(i + 1) - 48;
			}
		}
		
		if(aTotal > bTotal) {
			System.out.println("A");
		}else if(aTotal < bTotal) {
			System.out.println("B");
		}
		sc.close();
	}
}