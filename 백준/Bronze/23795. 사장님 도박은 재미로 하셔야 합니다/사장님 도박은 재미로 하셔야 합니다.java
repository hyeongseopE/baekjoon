import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int total = 0;
		
		while(n != -1) {
			total += n;
			n = sc.nextInt();
		}
		System.out.println(total);
		sc.close();
	}
}