package S_0923;


import java.util.*;
import java.io.*;
import java.awt.*;
//12580kb	116ms
//감시피하기
public class G_18428 {
    static int N ;
    static String map[][]; //맵
    static ArrayList<Point> S ; //학생위치

    static String answer;
    static int dx[] = {0,0,-1,1} , dy[] = {-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        S = new ArrayList<Point>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = s[j];
                if(map[i][j].equals("S")){
                    S.add(new Point(j, i)); //학생들 추가
                }
            }
        }

        answer = "NO";
        find(map,0);

        System.out.println(answer);
    }


    private static void find(String [][] map,int cnt) {
        if(cnt == 3){ //cnt==3개되면
            if(yesCheck(map)){ //체크
                answer = "YES";
            }
            return;
        }
        for (int i = 0; i < N; i++) { //맵 전부 돌면서
            for (int j = 0; j < N; j++) {
                if(map[i][j].equals("X")){ //X일 때 
                    map[i][j] = "B"; //B로 만들고
                    find(map, cnt + 1); //cnt+1 해서 재귀 태움
                    map[i][j] = "X"; //원복
                }
            }
        }
    }

    private static boolean yesCheck(String[][] map) {

        for (int i = 0; i < S.size(); i++) {
            Point p = S.get(i); //학생들하나씩 꺼내가면서
            for (int j = 0; j < 4; j++) {
                int x = p.x;
                int y = p.y;
                while (check(x, y)) { //범위 안에 있으면
                    x = x + dx[j]; //끝까지 가보기
                    y = y + dy[j];
                    if(check(x,y) && map[y][x].equals("X")) continue; //X면 넘어가고
                    if (check(x, y) && map[y][x].equals("T")) { //T면 안되고
                        return false;
                    }
                    else if(check(x,y) && (map[y][x].equals("B") || map[y][x].equals("S")))break; //또 학생만나면 break;

                }
            }
        }
        return true;
    }
    private static void Map(String map[][]){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean check(int x, int y){
        if(x>=0 && y>=0 && x<N && y<N){
            return true;
        }
        return false;
    }
}
