import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int j = 0; j < b; j++) {
				for(int k = 0; k < a; k++) {
					System.out.print("X");
				}
				System.out.println();
			}
			System.out.println();
		}
		sc.close();
	}
}