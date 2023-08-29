import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S_9095 {
    static int N,answer;
    static int data[][];
    static int day[],profit[];

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        day = new int[N];
        profit = new int[N];
        int [] dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]); //날
            int b = Integer.parseInt(s[1]); //수익

            day[i] = a;
            profit[i] = b;

        }
        answer = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
                if (j + day[j] == i) {
                    dp[i] = Math.max(dp[j] + profit[j], dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);


    }
}
