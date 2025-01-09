import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class PP {
        int team,ability;
        public PP (int team,int ability){
            this.team = team;
            this.ability = ability;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<PP> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                list.add(new PP(i,Integer.parseInt(st.nextToken())));
            }
        }

        list.sort((o1, o2) -> o1.ability - o2.ability);

        int left = 0;
        int right = 0;
        int teamCnt = 0;
        int []cnt = new int [n+1];
        int ans = Integer.MAX_VALUE;
        while(right < list.size()){
            PP pp = list.get(right);
            if(cnt[pp.team]==0){
                teamCnt ++;
            }
            cnt[pp.team]++;
            right ++;


            while(teamCnt==n){
                PP leftPP = list.get(left);
                PP rightPP = list.get(right-1);
//                System.out.println(leftPP.ability+" "+rightPP.ability);
                int minAbility = rightPP.ability - leftPP.ability;
                ans = Math.min(ans,minAbility);

                PP pp2 = list.get(left);
                cnt[pp2.team]--;
                if(cnt[pp2.team]==0){
                    teamCnt --;
                }
                left ++;
            }
        }


        System.out.println(ans);


    }
}
