import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//	11588kb	80ms
public class G_1068 {
    static int N,M;
    static ArrayList<Integer>[] tree;
    static int answerList[];
    static int top;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String [] s = br.readLine().split(" ");
        tree =new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        answerList = new int[N];
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(s[i]);
            if(temp== -1) top = i ;
            else tree[temp].add(i);
        }
        M = Integer.parseInt(br.readLine());

        get();
        System.out.println(answerList[top]);
    }

    private static void get() {
        for (int i = 0; i < N; i++) {
            for (int j = tree[i].size()-1; j >=0 ; j--) {
                if(tree[i].get(j) == M) tree[i].remove(j);
            }

        }
        if(M != top) find(top,-1);
    }

    private static void find(int x, int par) {
        if(tree[x].isEmpty())  answerList[x] = 1;

        for (int xx :tree[x]) {
            if(par == xx) continue;
            find(xx,x);
            answerList[x] += answerList[xx];


        }
    }

}