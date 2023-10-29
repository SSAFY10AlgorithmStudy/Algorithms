package d1014;

import java.util.*; // 자료구조 등 위해
import java.io.*; // 테스트케이스 입출력 위해

public class bj14499 { // 클래스 정의 시작

    static class Dice {
        static int[] vals = new int[7]; // 1, 2, 3, 4, 5, 6
        static int face = 1; // 면
        static int dir = 2; // 북쪽 면
        static int r = -1;
        static int c = -1;
    }

    public static void main(String[] args) throws Exception { // 메인 메서드 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 빠르게 읽기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(); // 문자열 모아서 출력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        Dice.r = x;
        Dice.c = y;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {0, 0, 0, -1, 1}; // x동서남북
        int[] dc = {0, 1, -1, 0, 0};
        int[] opposite = {0, 6, 5, 4, 3, 2, 1};
        int[][][] faceMap = new int[7][7][5];
        // facemap[면][방향][명령]
        faceMap[1][2] = new int[] {0, 3, 4, 5, 2};
        faceMap[1][3] = new int[] {0, 5, 2, 4, 3};
        faceMap[1][5] = new int[] {0, 4, 3, 2, 5};
        faceMap[1][4] = new int[] {0, 2, 5, 3, 4};

        faceMap[2][1] = new int[] {0, 4, 3, 6, 1};
        faceMap[2][3] = new int[] {0, 1, 6, 4, 3};
        faceMap[2][6] = new int[] {0, 3, 4, 1, 6};
        faceMap[2][4] = new int[] {0, 6, 1, 3, 4};

        faceMap[3][1] = new int[] {0, 2, 5, 6, 1};
        faceMap[3][2] = new int[] {0, 6, 1, 5, 2};
        faceMap[3][5] = new int[] {0, 1, 6, 2, 5};
        faceMap[3][6] = new int[] {0, 5, 2, 1, 6};

        faceMap[4][1] = new int[] {0, 5, 2, 6, 1};
        faceMap[4][2] = new int[] {0, 1, 6, 5, 2};
        faceMap[4][5] = new int[] {0, 6, 1, 2, 5};
        faceMap[4][6] = new int[] {0, 2, 5, 1, 6};

        faceMap[5][1] = new int[] {0, 3, 4, 6, 1};
        faceMap[5][3] = new int[] {0, 6, 1, 4, 3};
        faceMap[5][4] = new int[] {0, 1, 6, 3, 4};
        faceMap[5][6] = new int[] {0, 4, 3, 1, 6};

        faceMap[6][2] = new int[] {0, 4, 3, 5, 2};
        faceMap[6][3] = new int[] {0, 2, 5, 4, 3};
        faceMap[6][5] = new int[] {0, 3, 4, 2, 5};
        faceMap[6][4] = new int[] {0, 5, 2, 3, 4};


        st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++) {
            int command = Integer.parseInt(st.nextToken());
            // update pos
            int nr = Dice.r + dr[command];
            int nc = Dice.c + dc[command];
            if (nr >= 0 && nc >= 0 && nr < n && nc <m) {
                int nFace = -1;
                int nDir = -1;

                // update face
                // current face & direction & command
                nFace = faceMap[Dice.face][Dice.dir][command];

                // update dir
                if (command == 4) {
                    nDir = opposite[Dice.face];
                } else if (command == 3) {
                    nDir = Dice.face;
                } else {
                    nDir = Dice.dir;
                }

                // update dice face val & map
                if (map[nr][nc] == 0) {
                    // 맵이 0이면 바닥 값 복사
                    map[nr][nc] = Dice.vals[opposite[nFace]];
                } else {
                    // 아니면 바닥에 맵 값 복사 후 맵은 0
                    Dice.vals[opposite[nFace]] = map[nr][nc];
                    map[nr][nc] = 0;
                }

                // append ans
                sb.append(Dice.vals[nFace]).append("\n");

                // apply next
                Dice.r = nr;
                Dice.c = nc;
                Dice.dir = nDir;
                Dice.face = nFace;
            }
        }

        bw.write(sb.toString());
        bw.flush();

    }

}