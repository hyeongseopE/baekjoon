import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int p = sc.nextInt();
		int totalA = 0, totalP = 0;
		
		totalA = a * 7;
		totalP = p * 13;
		
		if(totalA > totalP) {
			System.out.println("Axel");
		}else if(totalA < totalP) {
			System.out.println("Petra");
		}else {
			System.out.println("lika");
		}
		sc.close();
	}
}