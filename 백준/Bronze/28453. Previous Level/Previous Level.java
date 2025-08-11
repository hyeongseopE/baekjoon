import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int m = sc.nextInt();
			if(m >= 300) {
				System.out.print("1 ");
			}else if(275 <= m && m < 300) {
				System.out.print("2 ");
			}else if(250 <= m && m < 275) {
				System.out.print("3 ");
			}else {
				System.out.print("4 ");
			}
		}
		sc.close();
	}
}