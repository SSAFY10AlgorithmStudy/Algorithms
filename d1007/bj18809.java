package d1007;

import java.util.*; // 자료구조 등 위해
import java.io.*; // 테스트케이스 입출력 위해

public class bj18809 { // 클래스 정의 시작

    static int n, m, g, r;
    static int nfertile, flowers;
    static int[][] map;
    static List<int[]> fertile = new ArrayList<>();
    static int[] plant;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception { // 메인 메서드 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 빠르게 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 배양액 뿌릴 수 있는 위치
                if (map[i][j] == 2) fertile.add(new int[] {i, j}); 
            }
        }

        nfertile = fertile.size(); // 배양액 가능한 땅 개수 -> 조합 크기 확인용
        plant = new int[nfertile]; // 배양액 가능한 위치에 뿌릴 색 기록용


        // dfs로 배양액 위치 조합 생성
        // 배양액 색 별 선택 횟수
        dfs(0, 0, 0);

        System.out.println(flowers);

    }

    static void dfs(int green, int red, int cnt) {
        // 선택한 초록,빨강이 심어야하는 수보다 크면 가지치기
        // 남은 칸에 모두 배양액 심어도 부족하면 가지치기
        if (green > g || red > r || ((g+r) - (green + red) > (nfertile - cnt))) return; // too many of color
        
        // 배양액 다 심었으면, 시뮬레이션
        if (cnt == nfertile) {
            // 선택한 초록, 빨강 수 안맞으면 리턴
            if (green != g || red != r) return; // if color number doesn't match
            simulate();
            return;
        }

        // cnt가 배양액 가능한 위치 인덱스
        // cnt에 초록, 빨강, 빈칸 중 선택한 상태에서 dfs재귀
        // 3 green, 4 red, 1 blank
        plant[cnt] = 3;
        dfs(green+1, red, cnt+1);
        plant[cnt] = 4;
        dfs(green, red+1, cnt+1);
        plant[cnt] = 1;
        dfs(green, red, cnt+1);
    }

    static void simulate() {
        // 시뮬레이션 위한 새로운 맵(시간 정보도 포함한)
        int[][][] gstate = new int[n][m][2];
        // 맵 복사
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                gstate[i][j][0] = map[i][j];
            }
        }

        // 배양액 퍼지기 위한 dfs queue
        Queue<int[]> q = new ArrayDeque<>();
        // 배양액 심기
        for(int i=0; i<nfertile; i++) {
            int c = fertile.get(i)[1];
            int color = plant[i];
            gstate[r][c][0] = color;
            if (color == 3 || color == 4) {
                // 큐에 시간 정보와 함께 추가
                q.offer(new int[] {r, c, color, 1});
            }
        }

        // bfs로 시뮬레이션
        while (!q.isEmpty()) {
            int r = q.peek()[0];
            int c = q.peek()[1];
            int color = q.peek()[2];
            int time = q.peek()[3];
            q.poll();
            if (gstate[r][c][0] == 5) continue; //!!

            for (int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // if in range, and not water, and not flower
                if (nr >= 0 && nc >= 0 && nr < n && nc < m
                        && gstate[nr][nc][0] != 0 && gstate[nr][nc][0] != 5) {
                    if (color == 3) { // green
                        if (gstate[nr][nc][0] == 4 && gstate[nr][nc][1] == time) {
                            gstate[nr][nc][0] = 5;
                        } else if (gstate[nr][nc][0] == 1) {
                            gstate[nr][nc][0] = 3;
                            gstate[nr][nc][1] = time;
                            q.offer(new int[] {nr, nc, color, time+1});
                        }
                    } else if (color == 4) { // red
                        if (gstate[nr][nc][0] == 3 && gstate[nr][nc][1] == time) {
                            gstate[nr][nc][0] = 5;
                        } else if (gstate[nr][nc][0] == 1) {
                            gstate[nr][nc][0] = 4;
                            gstate[nr][nc][1] = time;
                            q.offer(new int[] {nr, nc, color, time+1});
                        }
                    }
                }
            }

        }
        int flowercnt = 0;
        // 큐 비었으면 꽃 세기
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (gstate[i][j][0] == 5) {
                    flowercnt++;
                }
            }
        }

        flowers = Math.max(flowers,  flowercnt);

    }

}