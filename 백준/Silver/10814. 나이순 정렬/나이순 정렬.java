import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {

    static class People implements Comparable<People>{
        int age,num;
        String name;
        public People(int age, String name, int num){
            this.age = age;
            this.name = name;
            this.num = num;
        }

        @Override
        public int compareTo(People o){
            if(this.age == o.age){
                return this.num - o.num;
            }
            return this.age - o.age;

        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<People> pq  = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new People(Integer.parseInt(st.nextToken()), st.nextToken(),i));
        }

        for (int i = 0; i < n; i++) {
            People people = pq.poll();
            System.out.println(people.age+" "+people.name);
        }






    }
}