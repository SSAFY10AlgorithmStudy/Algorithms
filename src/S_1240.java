import java.awt.*;
import java.io.*;
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
            dfs(a, b, 0);
            sb.append(answer).append("\n");
            Arrays.fill(visited, false);
            answer= 0 ;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int a, int b, int d) {
        if (a == b) {
            answer = d;
            return;
        }
        visited[a] = true;
        for (Point p : list[a]) {
            if (!visited[p.x]) {
                dfs(p.x,b,d+p.y);
            }
        }
    }
}
