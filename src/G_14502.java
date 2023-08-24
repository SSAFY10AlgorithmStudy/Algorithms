import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class G_14502 {
    static ArrayList<Point> blank,virus; //빈칸이랑 바이러스 저장
    static int N,M;
    static int map[][];
    static int answer;
    static int dx[] = {-1,1,0,0}, dy[] ={0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); 
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        blank = new ArrayList<Point>();
        virus = new ArrayList<Point>();
        answer = 0;
        
        //맵 입력받기
        for (int i = 0; i < N; i++) {
            s= br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j] == 0 )blank.add(new Point(j,i)); //빈칸 추가
                if(map[i][j] == 2) virus.add(new Point(j,i)); //바이러스 추가
            }
        }
        find(0,0,new Point[3]); //찾기
        System.out.println(answer); //정답출력
    }

    private static void find(int cnt,int start, Point[] arr) {
        if(cnt ==3 ){
            int[][] map = copyMap(arr); //빈칸 3개 찾으면 맵 복사 벽세우기
            int safezone = count(map); //바이러스 퍼트리고 카운트 세기
            if(safezone > answer) answer = Math.max(answer,safezone); //안전지대 갱신
            return;
        }
        for (int i = start; i < blank.size() ; i++) {
            arr[cnt] = blank.get(i);
            find(cnt+1,i+1,arr);
        }
    }

    private static int count(int[][] map) { //바이러스 bfs로 퍼트리고 카운트 세기
        ArrayDeque<Point> dq = new ArrayDeque<Point>();
        for (int i = 0; i < virus.size(); i++) {
            dq.offer(virus.get(i));
        }
        while(!dq.isEmpty()){
            Point p = dq.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(x>=0 && x<M && y>=0 && y<N){
                    if(map[y][x] == 0){
                        map[y][x] =2;
                        dq.add(new Point(x,y));
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    cnt+=1;
                }
            }
        }
        return cnt;
    }

    private static int[][] copyMap(Point[] arr) { //맵 복사 + 벽세우기
        int temp[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i].y][arr[i].x] = 1;
        }
        return temp;
    }
}
