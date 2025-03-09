import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        HashMap<String,String> hm = new HashMap<String,String>(){
            {
                put("Algorithm","204");
                put("DataAnalysis","207");
                put("ArtificialIntelligence","302");
                put("CyberSecurity","B101");
                put("Network","303");
                put("Startup","501");
                put("TestStrategy","105");
            }
        };

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <n ; i++) {
            String s = br.readLine();
            System.out.println(hm.get(s));
        }


    }
}


