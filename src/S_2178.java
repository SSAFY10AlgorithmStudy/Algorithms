import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//	13648kb	152ms
public class S_2178 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int N,M;
    static int map[][], map2[][];
    static boolean visited[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0])+1;
        M = Integer.parseInt(s[1])+1;

        map = new int[N][M];
        map2 = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 1; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 1; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        bfs(1,1);
        System.out.println(map2[N-1][M-1]+1);

    }

    private static void bfs(int x, int y) {
        Point p = new Point(x, y);
        visited[y][x] = true;
        ArrayDeque<Point> dq=new ArrayDeque<Point>();
        dq.add(p);
        while (!dq.isEmpty()) {
            Point point = dq.pollFirst();
            int tempDx = point.x;
            int tempDy = point.y;
            for (int i = 0; i < 4; i++) {
                int tempDx2 = tempDx + dx[i];
                int tempDy2 = tempDy + dy[i];
                if ( 1 <= tempDx2 && tempDx2 < M && 1 <= tempDy2 && tempDy2 < N && map[tempDy2][tempDx2] ==1) {
                    if (!visited[tempDy2][tempDx2]) {
                        map2[tempDy2][tempDx2] += map[tempDy2][tempDx2] + map2[tempDy][tempDx];
                        visited[tempDy2][tempDx2] = true;
                        dq.add(new Point(tempDx2, tempDy2));
                    }
                }
            }
        }
    }
}
