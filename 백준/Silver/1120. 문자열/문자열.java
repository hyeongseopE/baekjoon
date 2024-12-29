import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= b.length()-a.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < a.length(); j++) {
                if(a.charAt(j) != b.charAt(i+j)){
                    cnt++;
                }
            }
            ans = Math.min(ans,cnt);
        }
        System.out.println(ans);

    }
}