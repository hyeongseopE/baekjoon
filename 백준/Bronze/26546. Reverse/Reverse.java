import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int j = 0; j < a; j++) {
				System.out.print(s.charAt(j));
			}
			for(int j = b; j < s.length(); j++) {
				System.out.print(s.charAt(j));
			}
			System.out.println();
		}
		sc.close();
	}
}