package S_0916;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class G_7569 {
    static int N,M,H;
    static int dx[] = {0,0,-1,1}, dy[] = {1, -1, 0, 0} ,backgo[] ={-1,1};
    static int map[][][];
    static ArrayList<PointNum> p; //토마토 위치 x,y,h 가진애들
    static class PointNum extends Point{
        int height;


        public PointNum(Point p, int height) {
            super(p);
            this.height = height;
        }

        public PointNum(int x, int y, int height) {
            super(x, y);
            this.height = height;
        }

        @Override
        public String toString() {
            return super.toString()+ "height : "+ height;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        H = Integer.parseInt(s[2]);

        map = new int[N][M][H];
        p = new ArrayList<PointNum>();
        for (int z = 0; z < H; z++) {
            for (int i = 0; i < N; i++) {
                s = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j][z] = Integer.parseInt(s[j]);
                    if(map[i][j][z] == 1) p.add(new PointNum(j,i,z)); //1위치 저장
                }
            }
        }
        ArrayDeque<PointNum> dq = new ArrayDeque<PointNum>();
        for (int i = 0; i < p.size(); i++) { //1인애들 데크에 넣기
            dq.add(p.get(i));
        }

        while(!dq.isEmpty()){
            PointNum toma = dq.poll(); //꺼내서
            for (int i = 0; i < 4; i++) { //상하좌우 비교
                int x = toma.x + dx[i];
                int y = toma.y + dy[i];
                if(x >=0 &&x<M && y>=0 && y<N){
                    if(map[y][x][toma.height] == 0){
                        map[y][x][toma.height] += map[toma.y][toma.x][toma.height] +1;
                        dq.add(new PointNum(x, y, toma.height));
                    }
                }
            }
            for (int i = 0; i < 2; i++) { //높이 아래 위 비교
                int h = toma.height + backgo[i];
                if(h >=0 && h<H){
                    if(map[toma.y][toma.x][h] == 0){
                        map[toma.y][toma.x][h] = map[toma.y][toma.x][toma.height] +1;
                        dq.add(new PointNum(toma.x, toma.y, h));
                    }
                }
            }
        }
        boolean flag = false;
        int MinValue = -1; //가장큰거 찾아서
        for (int z = 0; z < H; z++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j][z] == 0 ){
                        flag = true;
                        break;
                    }
                    if(MinValue < map[i][j][z]){
                        MinValue = map[i][j][z];
                    }
                }
            }
        }
        if(flag) System.out.println(-1);
        else System.out.println(MinValue-1); //출력
    }
}
