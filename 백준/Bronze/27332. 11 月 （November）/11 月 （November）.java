import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		a = a + b * 7;
		
		if(a > 30) {
			System.out.println("0");
		}else {
			System.out.println("1");
		}
		sc.close();
	}
}