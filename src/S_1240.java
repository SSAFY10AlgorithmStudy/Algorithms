import java.awt.*;
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class S_1240 {
    static int n,m;
    static ArrayList<Point>[] list;
    static int answer=0;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<Point>();
        }
        for (int i = 0; i < n-1; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            list[a].add(new Point(b, c));
            list[b].add(new Point(a, c));
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            bfs(a, b);
//            sb.append(answer).append("\n");
            Arrays.fill(visited, false);
            answer= 0 ;
        }
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
    }

    private static void bfs(int a, int b) {
        ArrayDeque<Point> dq  = new ArrayDeque<Point>();
        dq.add(new Point(a,0));
        int ans[] = new int[n + 1];
        while (!dq.isEmpty()) {
            Point p = dq.poll();
            visited[p.x] = true;

            for (Point temP: list[p.x]) {
                if (!visited[temP.x]) {
                    ans[temP.x] = temP.y+ans[p.x];
                    if (temP.x == b) {
                        System.out.println(ans[b]);
                        return ;
                    }
                    dq.add(temP);
                }

            }
        }
    }


//    private static void dfs(int a, int b, int d) {
//        if (a == b) {
//            answer = d;
//            return;
//        }
//        visited[a] = true;
//        for (Point p : list[a]) {
//            if (!visited[p.x]) {
//                dfs(p.x,b,d+p.y);
//            }
//        }
//    }
}
