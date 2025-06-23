import java.util.Scanner;
import java.util.Arrays;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int arr[] = {in.nextInt(), in.nextInt(), in.nextInt()};
		in.close();		
        
		Arrays.sort(arr);	
        
		System.out.println(arr[1]);
	}
}
 