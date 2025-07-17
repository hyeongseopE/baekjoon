import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		if(a.equals("fdsajkl;") || a.equals("jkl;fdsa")) {
			System.out.println("in-out");
		}else if(a.equals("asdf;lkj") || a.equals(";lkjasdf")) {
			System.out.println("out-in");
		}else if(a.equals("asdfjkl;")) {
			System.out.println("stairs");
		}else if(a.equals(";lkjfdsa")) {
			System.out.println("reverse");
		}else {
			System.out.println("molu");
		}
		sc.close();
	}
}