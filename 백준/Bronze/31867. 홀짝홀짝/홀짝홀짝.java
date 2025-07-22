import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String k = sc.next();
		
		int odd = 0;
		int even = 0;
		
		for(int i = 0; i < n; i++) {
			if(k.charAt(i) % 2 == 0) {
				even++;
			}else {
				odd++;
			}
		}
		
		if(even > odd) {
			System.out.println("0");
		}else if(even < odd) {
			System.out.println("1");
		}else {
			System.out.println("-1");
		}
		sc.close();
	}
}