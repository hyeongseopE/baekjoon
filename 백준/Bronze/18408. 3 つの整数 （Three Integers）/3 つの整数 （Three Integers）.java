import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int count1 = 0, count2 = 0;
		
		if(a == 1) {
			count1++;
		}else {
			count2++;
		}
		
		if(b == 1) {
			count1++;
		}else {
			count2++;
		}
		
		if(c == 1) {
			count1++;
		}else {
			count2++;
		}
		
		if(count1 > count2) {
			System.out.println("1");
		}else if(count1 < count2){
			System.out.println("2");
		}
		sc.close();
	}
}