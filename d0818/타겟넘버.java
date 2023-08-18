package d0818;

class 타겟넘버 {
    static int answer;
    static int n;

    public static int solution(int[] numbers, int target) {
        answer = 0;
        n = numbers.length;

        dfs(0, 0, numbers, target);

        return answer;
    }

    private static void dfs(int cnt, int cursum, int[] numbers, int target) {
        if (cnt == n) {
            if (cursum == target) answer++;
            return;
        }

        dfs(cnt+1, cursum+numbers[cnt], numbers, target); // 더하기
        dfs(cnt+1, cursum-numbers[cnt], numbers, target); // 빼기

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,1,1,1}, 3));
    }
}
