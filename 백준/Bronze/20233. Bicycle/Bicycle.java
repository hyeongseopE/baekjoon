import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int x = sc.nextInt();
		int b = sc.nextInt();
		int y = sc.nextInt();
		int t = sc.nextInt();
		int Atotal = 0, Btotal = 0;
		
		if(t <= 30) {
			Atotal = a;
		}else {
			Atotal = a + (t - 30) * x * 21;
		}
		
		if(t <= 45) {
			Btotal = b;
		}else {
			Btotal = b + (t - 45) * y * 21;
		}
		
		System.out.println(Atotal + " " + Btotal);
		sc.close();
	}
}