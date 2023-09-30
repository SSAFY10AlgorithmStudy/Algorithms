package S_0930;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

//299696kb	988ms
public class G_18809 {
    //맵
    static int map[][];
    //N 세로 M 가로 g그린 개수, r 레드 개수 , 정답
    static int N, M, g, r,answer;
    //꽃 설치 가능한곳
    static ArrayList<Point> can;
    //조합 visited
    static boolean visited[];
    //조합 뽑은거 저장 배열
    static Point[] green , red;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        //입력
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        g = Integer.parseInt(s[2]);
        r = Integer.parseInt(s[3]);

        //초기화
        answer= 0 ;
        map = new int[N][M];
        can = new ArrayList<Point>();
        green = new Point[g];
        red = new Point[r];

        //맵입력받고 꽃설치 가능한 위치 저장
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j] == 2) can.add(new Point(j, i));
            }
        }

        visited = new boolean[can.size()];
        Green(0,0);
        System.out.println(answer);
    }

    private static void Green(int cnt, int idx) {
        //다 뽑으면 레드 뽑으러 가기
        if(cnt == g){
            Red(0,0);
            return ;
        }
        //조합 뽑기
        for (int i = idx; i <can.size() ; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            green[cnt] = can.get(i);
            Green(cnt + 1, i + 1);
            visited[i] = false;

        }
    }

    private static void Red(int cnt, int idx) {
        //다 뽑으면 시뮬레이션하러가기
        if(cnt == r){
            int make = make();
            if(make > answer) answer = Math.max(answer, make);
            return;
        }
        //조합 뽑기
        for (int i = idx; i < can.size(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            red[cnt] = can.get(i);
            Red(cnt + 1, i+ 1);
            visited[i] = false;
        }
    }


    private static int make() {
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        int temp [][] = new int[N][M];

        //꽃 visited [y][x] = x,y,time,color
        PointTime visited[][] = new PointTime[N][M];

        //맵 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }
        ArrayDeque<PointTime> dq = new ArrayDeque<PointTime>();
        //그린 뽑아서 데크추가 + visited 추가
        for (Point g : green) {
            dq.add(new PointTime(g,0,3));
            visited[g.y][g.x] = new PointTime(g.x, g.y, 0, 3);
        }
        //빨강 뽑아서 데크추가 + visited 추가
        for (Point r:red) {
            dq.add(new PointTime(r,0,4));
            visited[r.y][r.x] = new PointTime(r.x, r.y, 0, 4);
        }
        //3 은 그린 4는 빨강 5는 꽃 핌
        while (!dq.isEmpty()) {
            //뽑은다음에
            PointTime p = dq.poll();

            //5면 꽃핀거니깐 continue;
            if(temp[p.y][p.x] ==5) continue;

            //상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                //범위 안에 있을 때
                if (x >= 0 && x < M && y >= 0 && y < N) {
                    //아직 방문 안했고 물 아니면
                    if(visited[y][x] == null && temp[y][x] != 0){
                        //time +1 해서 방문처리 후 데크 추가
                        visited[y][x] = new PointTime(x,y, p.time+1, p.color);
                        dq.add(new PointTime(x, y, p.time + 1, p.color));
                    }
                    //방문했던 곳인데 꽃색깔 다르고 시간 1 차이나면 꽃핌
                    else if(visited[y][x] != null &&visited[y][x].color != p.color && visited[y][x].time == p.time+1 ){
                        temp[y][x] =5;
                    }
                }
            }

        }
        //꽃세기
        int flowersCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(temp[i][j] == 5){
                    flowersCnt++;
                }
            }
        }
        return flowersCnt;
    }

    public static class PointTime extends Point {
        int time;
        int color;

        public PointTime(Point p, int time, int color) {
            super(p);
            this.time = time;
            this.color = color;
        }

        public PointTime(int x, int y, int time, int color) {
            super(x, y);
            this.time = time;
            this.color = color;
        }
    }

}

