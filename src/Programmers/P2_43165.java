package Programmers;

class P2_43165 {
    static int answer;
    public static int solution(int[] numbers, int target) {
        find(numbers,target,0,0,numbers.length); //찾기
        return answer;
    }
    //cnt는 개수 인덱스, length는 numbers 길이
    private static void find(int[] numbers, int target, int sum, int cnt,int length) {
        if(cnt == length){ //길이같을 때
            if(sum== target){ //타켓이랑 더한 값 같으면 정답 +1
                answer+=1;
            }
            return;
        }
        find(numbers,target,sum-numbers[cnt],cnt+1,length); //더하기
        find(numbers,target,sum+numbers[cnt],cnt+1,length); //빼기

    }


}

