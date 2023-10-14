package S_1014;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//	13872kb	124ms
public class G_2629 {
    static int n,m; //n 추 개수 m 구슬 개수
    static int []chu; //츄
    static boolean [][]dp; //dp
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        chu = new int[n];
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            chu[i] = Integer.parseInt(s[i]);
        }
        //추무게 최대 4만
        dp = new boolean[n+1][40001];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            //이전 추 꺼내서
            int temp = chu[i - 1];
            //무게만큼 돌면서
            for (int j = 0; j <=40000; j++) {
                //이전추에 해당하는 무게가 참이다
                if(dp[i-1][j]){
                    //지금고려한 i에 j에도 참 표시
                    dp[i][j] = true;
                    //더한 값 4만보다 작으면 표시
                    if(j+temp <=40000){
                        dp[i][j+temp] =true;
                    }
                    //뺸 값 0보다 크면 표시
                    int temp2 = Math.abs(j-temp);
                    if(temp2 >=0){
                        dp[i][temp2] = true;
                    }
                }
            }
        }
        m = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        //m만큼 돌면서
        for(int k=0;k<m;k++){
            int data=Integer.parseInt(s[k]);
            //추가 4만보다크거나 || 모든 추 고려한거에서 해당 무게가 false 면 N
            if(data>40000||!dp[n][data])
                System.out.print("N ");
            else
                System.out.print("Y ");
        }
    }
}
