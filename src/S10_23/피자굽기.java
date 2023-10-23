package S10_23;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 피자굽기 {
    static int d,n;
    static int pizza[], oven [];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        d = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        oven = new int[d];
        pizza = new int[n];

        s = br.readLine().split(" ");
        oven[0] = Integer.parseInt(s[0]);
        for (int i = 1; i < oven.length; i++) {
            oven[i] = Math.min(Integer.parseInt(s[i]),oven[i-1]);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < pizza.length; i++) {
            pizza[i] = Integer.parseInt(s[i]);
        }

        int depth = d-1;

        for (int p : pizza) {
            while(depth >=0 && p>oven[depth]) depth--;
            if(depth<0) {
                System.out.println(0);
                return;
            }
            depth--;
        }
        System.out.println(depth+2);
    }

}
