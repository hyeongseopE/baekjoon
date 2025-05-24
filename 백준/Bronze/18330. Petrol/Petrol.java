import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int total = 0;
		
		if(n - k <= 60) {
			total = n * 1500;
		}else {
			total = (60 + k) * 1500 + (n - 60 - k) * 3000;
		}
		
		System.out.println(total);
		sc.close();
	}
}