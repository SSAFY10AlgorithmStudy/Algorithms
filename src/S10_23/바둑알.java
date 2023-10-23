package S10_23;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

//106212kb	468ms
public class 바둑알 {
    //N : y M : x
    static int N, M;
    //영위치 저장
    static ArrayList<Point> zeroPoint;
    //맵저장
    static int map[][];
    //임시 바둑알세기
    static ArrayList<Integer> tempCnt;
    //방문처리
    static boolean visited[][];
    static int dx[] ={0,0,-1,1} , dy[]={-1,1,0,0};
    static int answer;
    public static void main(String[] args) throws Exception {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        
        //초기화
        zeroPoint = new ArrayList<Point>();
        map = new int[N][M];
        answer = 0;
        
        //0위치 추가
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 0) zeroPoint.add(new Point(j, i));
            }
        }
        //찾으러가기
        find(0, 0, new Point[2]);
        
        //정답출력
        System.out.println(answer);
    }
    //조합생성
    private static void find(int cnt, int idx, Point[] point) {
        //2개 뽑기
        if (cnt == 2) {
            int temp = check(point);
            if(answer <temp) answer = Math.max(answer,temp);
            return;
        }
        
        for (int i = idx; i < zeroPoint.size(); i++) {
            point[cnt] = zeroPoint.get(i);
            find(cnt + 1, i + 1, point);
        }
    }
    //바둑알체크
    private static int check(Point[] point) {
        tempCnt =new ArrayList<Integer>();
        visited = new boolean[N][M];
        //0인 위치 흰 바둑알 두개
        map[point[0].y][point[0].x] = 1;
        map[point[1].y][point[1].x] = 1;
        
        //흰 바둑알 둔 위치에서 상하좌우탐색
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                int x = point[i].x + dx[j];
                int y = point[i].y + dy[j];
                if(x>=0 && y>=0 && x<M && y < N){
                    //검은바둑알이고 방문해본적없으면 
                    if(map[y][x] ==2&& !visited[y][x])
                         //bfs
                        bfs(x,y);
                }
            }
        }
        
        //원복
        map[point[0].y][point[0].x] = 0;
        map[point[1].y][point[1].x] = 0;
        
        //검은바둑알 추가 된거 다더하기
        return tempCnt.stream().mapToInt(a -> a).sum();
    }

    private static void bfs(int j, int i) {
        visited[i][j] = true;
        ArrayDeque<Point> dq = new ArrayDeque<Point>();
        dq.add(new Point(j,i));
        
        //검은바둑알세기
        int cnt = 1;
        
        
        while (!dq.isEmpty()){
            Point p = dq.poll();
            //흰바둑알이면 아무것도 하지않아
            if(map[p.y][p.x] == 1) continue;
            
            //상하좌우돌면서
            for (int k = 0; k < 4; k++) {
                int x = p.x + dx[k];
                int y = p.y + dy[k];
                if(x>=0 && x<M && y>=0 && y<N){
                    //0이 있다면 안됨 return
                    if(!visited[y][x]){
                        if(map[y][x] == 0){
                            return;
                        }
                        //2있으면 큐에추가하고 바둑알하나세기
                        else if(map[y][x] == 2){
                            dq.add(new Point(x,y));
                            visited[y][x] = true;
                            cnt+=1;
                        }
                    }
                }
            }
        }
        //검은 바둑알센거 tempCnt에 추가
        tempCnt.add(cnt);
    }

}
