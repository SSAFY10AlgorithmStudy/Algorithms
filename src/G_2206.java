import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class G_2206 {

    static int N, M; //N 과 M 크기
    static Point start; //시작점
    static int map[][]; //맵
    static boolean visited[][][]; //방문기록 3차원
    static int dx[] = {-1,1,0,0} , dy[] = {0,0,-1,1}; //이동하기
    static int answer; //정답

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        
        N = Integer.parseInt(s[0]); 
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        visited = new boolean[N][M][2];
        answer = -1; //초기값 -1 
        
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        
        start = new Point(0,0);
        ArrayDeque<PointN> dq = new ArrayDeque<PointN>();
     
        //시작점,이동횟수,1 은 부셔버릴 횟수
        dq.add(new PointN(start, 0,1)); 
        visited[start.y][start.x][1] = true;
        
        while(!dq.isEmpty()){
            PointN p = dq.poll(); //좌표 꺼내서
            if(p.x == M-1  && p.y == N-1){ //끝에 도달하면
                if(map[p.y][p.x] == 0){
                    answer = p.broke+1; // 브레이크
                    break;
                }
                else{
                    break; //끝에 도달했는데 1이여도 브레이크 정답 갱신 안하고
                }
            }

            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if(x >=0 && x< M && y >= 0 && y<N){
                	//방문했으면 continue
                    if(visited[y][x][p.cnt]) continue; 
                    
                    //안부셔도 되면 그냥 이동횟수만 증가
                    if(map[y][x] == 0 ){
                        visited[y][x][p.cnt] = true;
                        dq.add(new PointN(new Point(x,y),p.broke+1,p.cnt));
                        
                    }else{
                    	//근데 가는 곳이 부숴야 할 경우
                    	//횟수 없으면 continue 있으면 부수고 이동
                        if(p.cnt == 0) continue;
                        visited[y][x][p.cnt-1] = true;
                        dq.add(new PointN(new Point(x,y),p.broke+1,p.cnt-1));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static class PointN extends Point{
        int cnt, broke;

        public PointN(Point p,int broke, int cnt) {
            super(p);
            this.broke =  broke;
            this.cnt = cnt;
        }

        public PointN(int x, int y) {
            super(x, y);
        }
    }
}