package S_1030;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class G_1580 {
    //N과 M입력받기
    static int N,M;
    static char[][] map;
    static PointAB pointab;
    static int[][][][] visited;
    static int[] dx = {-1,-1,-1,0,0,0,1,1,1}, dy = {-1,0,1,-1,0,1,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        
        map = new char[N][M];
        visited = new int[N][M][N][M];
        
        //a 위치 b 위치 이동횟수 저장하는 PointAB
        pointab = new PointAB(new Point(0, 0), new Point(0, 0), 0);
        
        //입력받기
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                //a 위치 b위치 pointab에 저장
                if(map[i][j] == 'A') pointab.a = new Point(j, i);
                if(map[i][j] == 'B') pointab.b = new Point(j, i);
            }
        }

        ArrayDeque<PointAB> dq = new ArrayDeque<PointAB>();
        dq.add(pointab);
        visited[pointab.a.y][pointab.a.x][pointab.b.y][pointab.b.x] = 1;
        
        while (!dq.isEmpty()) {
            //a, b 꺼냄
            PointAB cur = dq.poll();
            Point a = cur.a;
            Point b = cur.b;
            
            //a가 b로 b가 a에 초기 위치로 갔다 -> 정답출력
            if(a.x == pointab.b.x && a.y == pointab.b.y &&
                    b.x == pointab.a.x && b.y == pointab.a.y){
                System.out.println(cur.cnt);
                return;
            }
            
            //상하좌우, 대각선, 가만히있는거 9가지 이동
            for (int i = 0; i < 9; i++) {
                
                int ax = a.x + dx[i];
                int ay = a.y + dy[i];
                //범위안에있지않고 이동할 곳이 X면 continue
                if(!check(ax, ay)) continue;
                
                for (int j = 0; j < 9; j++) {
                    
                    int bx = b.x + dx[j];
                    int by = b.y + dy[j];
                    //b가 이동하는것도 똑같이 체크한 후
                    if(!check(bx, by)) continue;
                    //a가 이동한 곳과 b가 이동한 곳이 같다 continue
                    if(ax == bx && ay == by) continue;
                    //a가 이동할 곳이 이전 b가 있던 위치, b가 이동할 곳이 a가 이전에 있던 위치면 continue;
                    if(ax == b.x && ay == b.y && by == a.y && bx == a.x) continue;
                    
                    //아닐 경우 방문 처리후 dq에 추가
                    if(visited[ay][ax][by][bx] == 0){
                        visited[ay][ax][by][bx] = 1;
                        dq.add(new PointAB(new Point(ax, ay), new Point(bx, by), cur.cnt + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static boolean check(int x, int y){
        if(x >=0 && x<M && y>=0 && y<N && map[y][x] != 'X'){
            return true;
        }
        return false;
    }

    private static class PointAB {
        Point a,b;
        int cnt;

        public PointAB(Point a, Point b, int cnt) {
            this.a = a;
            this.b = b;
            this.cnt = cnt;
        }
    }
}