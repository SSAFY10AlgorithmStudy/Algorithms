import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S_14501 {
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
                if (j + day[j] == i) { //현재 날짜 기준(i)  == 이전 날짜 중(j) + 이전 날짜에서 일했을 경우 걸릴 시간
                    dp[i] = Math.max(dp[j] + profit[j], dp[i]); //수익난거 더한거와 선택안했을 경우 가장 큰 값 선택
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);


    }
}
//public class Main { 재귀 풀이
//    static int N,answer;
//    static int data[][];
//    public static void main(String[] args) throws  Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        data = new int[N][2];
//
//        for (int i = 0; i < N; i++) {
//            String[] s = br.readLine().split(" ");
//            int a = Integer.parseInt(s[0]); //날
//            int b = Integer.parseInt(s[1]); //수익
//            data[i][0] = a;
//            data[i][1] = b;
//        }
//        answer = 0;
//        find(0,0);
//
//        System.out.println(answer);
//
//
//    }
//
//    private static void find(int day, int profit) {
//        if(day >= N){
//            if(answer < profit){
//                answer = Math.max(profit,answer);
//            }
//            return;
//        }
//        if(day + data[day][0]<=N ){
//            find(day+data[day][0], profit+ data[day][1]);
//        }
//        find(day+1,profit);
//
//
//    }
//}
