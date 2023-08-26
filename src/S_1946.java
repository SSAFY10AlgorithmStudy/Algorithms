import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class S_1946 {
    static int T, N ;
    static ArrayList<int[]> data;
    static ArrayDeque<int[]> real;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int _ = 0; _ < T; _++) {
            N = Integer.parseInt(br.readLine());
            data = new ArrayList<int[]>();
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                data.add(new int[]{a,b});
            }

            Collections.sort(data, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0],o2[0]);
                }
            });
            real = new ArrayDeque<int[]>(data);
            int cnt =1;

            if(!real.isEmpty()){
                int top = real.poll()[1];
                while(!real.isEmpty()){
                    if(real.peek()[1]< top){
                        cnt+=1;
                        top = real.peek()[1];
                    }
                    real.poll();
                }

            }
            System.out.println(cnt);
        }
    }

}
