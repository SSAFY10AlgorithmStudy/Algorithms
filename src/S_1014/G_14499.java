package S_1014;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//12148kb	92ms
public class G_14499 {
    static int n, m, k;
    static Point start;
    static int dx[] = {0, 1, -1, 0, 0}, dy[] = {0, 0, 0, -1, 1};
    static int map[][];
    static int dice[];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        sb = new StringBuilder();
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        //왜그런지 모르겠는데 주사위 x, y 반대?
        int x = Integer.parseInt(s[3]);
        int y = Integer.parseInt(s[2]);
        k = Integer.parseInt(s[4]);
        start = new Point(x, y);
        map = new int[n][m];
        dice = new int[6];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        //주사위를 어떻게할까?
        s = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(s[i]);
            make(command);
        }
        System.out.println(sb);
    }

    private static void make(int command) {

        int x = start.x + dx[command];
        int y = start.y + dy[command];
        //범위 안에 있을때
        if (check(x, y)) {
        	//주사위 굴리기
            roll(command);
            //map == 0 일때 랑 아닐때
            if (map[y][x] == 0) {
                map[y][x] = dice[5];
            } else {
                dice[5] = map[y][x];
                map[y][x] = 0;
            }
            //윗면 sb에 추가하고 좌표 바꾸기
            sb.append(dice[0]).append("\n");
            start = new Point(x, y);
        }

    }

    //주사위 굴리기
    private static void roll(int command) {
    	//서
        if (command == 1) {
            diceSwap(0,2);
            diceSwap(1,5);
            diceSwap(1,2);
        }
        //남
        else if (command == 2) {
            diceSwap(0, 1);
            diceSwap(1, 5);
            diceSwap(2, 5);
        }
        //북
        else if (command == 3) {
            diceSwap(0, 3);
            diceSwap(3, 5);
            diceSwap(4, 5);
        }
        //남
        else if (command == 4) {
            diceSwap(0, 4);
            diceSwap(3, 4);
            diceSwap(4, 5);
        }

    }
    //스왑
    private static void diceSwap(int to, int from) {
        int temp = dice[to];
        dice[to] = dice[from];
        dice[from] = temp;
    }
    
    //체크
    private static boolean check(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }
}
