import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class S1_14940 {
    static int n , m ;
    static int map[][];
    static int dx[] ={1,-1,0,0} ,dy[] ={0,0,-1,1}; //방향
    static Point p; //시작 위치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j] == 2){
                    map[i][j] = 0;
                    p = new Point(j,i);
                }
            }
        }
        ArrayDeque<Point> dq = new ArrayDeque<Point>();
        dq.add(p);
        boolean [][] visited = new boolean[n][m];

        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m ; j++) {
                if(map[i][j] == 0 || map[i][j] == 2){ // 맵 0일떄와 2일때 더이상 가면 안되서 visited True
                    visited[i][j] = true;
                    map[i][j] = 0;
                }
            }
        }
        while(!dq.isEmpty()){
            Point temp = dq.poll();
            for (int i = 0; i < 4; i++) {
                int xx =temp.x + dx[i];
                int yy = temp.y + dy[i];
                if(xx >=0 && xx <m && yy>=0 && yy<n ){
                   if(visited[yy][xx]) continue;
                   if(map[yy][xx] != 0){
                       visited[yy][xx] =true;
                       map[yy][xx]  += map[temp.y][temp.x];
                       dq.add(new Point(xx,yy));
                   }
                }
            }
        }
            for (int i = 0; i < n; i++) { //맵에 1이 남아있고 방문안했으면 -1로 바꾸기
                for (int j = 0; j < m; j++) {
                    if(map[i][j] == 1 && !visited[i][j]){
                        System.out.print(-1 + " ");
                    }else{
                        System.out.print(map[i][j] + " ");
                    }

                }
                System.out.println();
            }





    }





}