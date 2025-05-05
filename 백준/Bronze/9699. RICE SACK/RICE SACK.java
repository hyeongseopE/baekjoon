import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int i = 0; i < testCase; i++) {
			int max = -999;
			for(int j = 0; j < 5; j++) {
				int array = sc.nextInt();
				max = Math.max(max, array);
			}
			System.out.println("Case #" + (i + 1) + ": " + max);
		}
		sc.close();
	}
}