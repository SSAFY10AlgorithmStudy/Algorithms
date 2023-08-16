import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_2847{

    static int N,r,c;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);
        answer = 0;
        find(0,0,(int)Math.pow(2,N),0);
        System.out.println(answer);
        br.close();
    }

    private static void find(int x, int y, int size, int cnt) {
        if ((x + size - 1 < r || x > r) &&(y + size - 1 < c || y > c)) return;
        if(size ==2){
            int temp = 0;
            for (int i = y; i <y+2; i++) {
                for (int j = x; j < x+2; j++) {
                    if(i == c && j == r){
                        answer += cnt+temp;
                    }else{
                        temp+=1;
                    }
                }
            }
            return;
        }
        int half = size/2;
        find(x,y,half,cnt);
        find(x,y+half,half,cnt+half*half*1);
        find(x+half,y,half,cnt+half*half*2);
        find(x+half,y+half,half,cnt+half*half*3);

    }

}