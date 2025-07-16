import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int l = 0;
		int k = 0;
		int p = 0;
		
		for(int i = 0; i < 3; i++) {
			String s = sc.next();
			if(s.charAt(0) == 'l') {
				l = 1;
			}else if(s.charAt(0) == 'k') {
				k = 1;
			}else if(s.charAt(0) == 'p') {
				p = 1;
			}
		}
		
		if(l == 1 && k == 1 && p == 1) {
			System.out.println("GLOBAL");
		}else {
			System.out.println("PONIX");
		}
		
		sc.close();
	}
}