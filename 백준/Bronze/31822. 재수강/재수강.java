import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String code = str.substring(0, 5);
        int num = Integer.parseInt(br.readLine());
        int ansewr = 0;

        for (int i = 0; i < num; i++) {
            String subject = br.readLine();
            String subjectCode = subject.substring(0, 5);

            if (subjectCode.equals(code)){
                ansewr++;
            }
        }

        sb.append(ansewr);
        System.out.println(sb.toString());
    }
}