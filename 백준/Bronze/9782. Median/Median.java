import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 0;
		while(n != 0) {
			int[] a = new int [n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			count++;
			if(n % 2 == 0) {
				System.out.println("Case " + count + ": " + (double)(a[n / 2 - 1] + a[n / 2]) / 2);
			}else {
				System.out.println("Case " + count + ": " + (double)a[(n - 1) / 2]);
			}
			n = sc.nextInt();
		}
		sc.close();
	}
}