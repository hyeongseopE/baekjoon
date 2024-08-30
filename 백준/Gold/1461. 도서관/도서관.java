import java.io.*;
import java.util.*;

public class Main {

    static int max_A = -1;
    static int max_B = -1;
    static int lcnt,rcnt,sum,i1,i2,c=1,t;

    static public void goright(int n){
        for (int i = 0; i < n; i++) {
            c++;
            rcnt = rcnt - 1;
        }
    }

    static public void goleft(int n){
        for (int i = 0; i < n; i++) {
            c++;
            lcnt = lcnt - 1;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        arr.add(0);
        arr2.add(0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x<0){
                lcnt++;
                x *= -1;
                arr2.add(x);
                if(x > max_B ){
                    max_B = x;
                }
            }else {
                rcnt++;
                arr.add(x);
                if(x > max_A){
                    max_A = x;
                }
            }
        }

        Collections.sort(arr);
        Collections.sort(arr2);
//        for (int i = 1; i < arr.size(); i++) {
//            System.out.println("arr["+i+"]:"+arr.get(i));
//        }
//        for (int i = 1; i < arr2.size(); i++) {
//            System.out.println("arr2["+i+"]:"+arr2.get(i));
//        }



//        System.out.println("max_A: "+max_A+" max_B:"+max_B);
        int b1 = lcnt % m;
        int a1 = rcnt % m;
//        System.out.println("lcnt: "+lcnt+" rcnt:"+rcnt);
//        System.out.println("sum:"+sum+" c:"+c);
        if(max_A < max_B){
            goright(a1);
            sum = sum + arr.get(c-1)*2;
//            System.out.println("sum:"+sum+" c:"+c);
            while(rcnt!=0){
                goright(m);
                sum=sum+arr.get(c-1)*2;
//                System.out.println("sum:"+sum+" c:"+c);
            }
            c=1;
            goleft(b1);
            sum = sum + arr2.get(c-1)*2;
//            System.out.println("sum:"+sum+" c:"+c);
            while(lcnt != 0 ){
                goleft(m);
                sum = sum + arr2.get(c-1)*2;
//                System.out.println("sum:"+sum+" c:"+c);
            }
            sum = sum - arr2.get(c-1);
        }else if(max_A > max_B){
            goleft(b1);
            sum = sum + arr2.get(c-1)*2;
//            System.out.println("sum:"+sum+" c:"+c);
            while(lcnt!=0){
                goleft(m);
                sum=sum+arr2.get(c-1)*2;
//                System.out.println("sum:"+sum+" c:"+c);
            }
            c=1;
            goright(a1);
            sum=sum+arr.get(c-1)*2;
//            System.out.println("sum:"+sum+" c:"+c);
            while(rcnt != 0 ){
                goright(m);
                sum = sum + arr.get(c-1)*2;
//                System.out.println("sum:"+sum+" c:"+c);
            }
            sum = sum - arr.get(c-1);
        }

        System.out.println(sum);

    }
}