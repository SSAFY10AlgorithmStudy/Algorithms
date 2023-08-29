import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S_9095 {
    static int T,N,answer;
    //1,2,3 만 이용함
    static int one[];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int _ = 0; _ < T; _++) {
            N = Integer.parseInt(br.readLine());
            one = new int[N+3];

            answer= 0 ;
            one[0] =1;
            one[1] =1;
            one[2] = 2;
            for (int i = 3; i <=N ; i++) {
                one[i] = one[i-3]+one[i-2]+one[i-1];
            }
            System.out.println(one[N]);

        }
    }
}
