import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int score3 = sc.nextInt();
		int score2 = sc.nextInt();
		int score1 = sc.nextInt();
		int totalA = score3 * 3 + score2 * 2 + score1;
		
		score3 = sc.nextInt();
		score2 = sc.nextInt();
		score1 = sc.nextInt();
		int totalB = score3 * 3 + score2 * 2 + score1;
		
		if(totalA > totalB) {
			System.out.println("A");
		}else if(totalA < totalB) {
			System.out.println("B");
		}else {
			System.out.println("T");
		}
		sc.close();
	}
}