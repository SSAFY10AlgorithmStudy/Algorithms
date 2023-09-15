package S_0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G_2179 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<StringNum> list = new ArrayList<StringNum>(); 
        ArrayList<StringNum> list2 = new ArrayList<StringNum>();
        for (int i = 0; i < N; i++) {
            list.add(new StringNum(br.readLine(), i)); //입력 받기 문자열이랑, 인덱스
        }
        Collections.sort(list); //문자열 기준 정렬
        int max = 0;
        for (int i = 0; i < list.size()-1; i++) {
            int cnt = 0; //카운트 세기
            StringNum a = list.get(i);
            StringNum b = list.get(i + 1);
            for (int j = 0; j < Math.min(a.s.length(),b.s.length()); j++) {
                if (a.s.charAt(j) == b.s.charAt(j)) {
                    cnt++; //두 단어 같으면 cnt ++
                }
                else break;
            }
            if(cnt > max){ //기존 값보다 더 크면 이전거 지우고 리스트에 추가
                max = cnt;
                list2.clear();
                list2.add(a);
                list2.add(b);
            }
            else if(cnt == max){ //같으면 둘다 추가
                list2.add(a);
                list2.add(b);
            }
        }


        Collections.sort(list2, new Comparator<StringNum>() { //인덱스 기준 정렬
            @Override
            public int compare(StringNum o1, StringNum o2) {
                return Integer.compare(o1.n,o2.n);
            }
        });
        String S,T; 
        StringNum s = list2.get(0); //인덱스 가장 빠른애 뽑고
        String pre = s.s.substring(0, max); //0 ~ max 값까지인 문자열로 만들고
        S = s.s;
        T = null;
        for (int i = 0; i < list2.size(); i++) {
            if(s.n == list2.get(i).n) continue; //근데 비교안하고 넣어서 똑같은거 생길 수 있으니깐 인덱스 같으면 넘기기
            if (list2.get(i).s.substring(0, max).equals(pre)) { //맥스길이까지 짤라서 비교
                T = list2.get(i).s; //이제 같으면 T에 추가하고 break;
                break;
            }
        }
        System.out.println(S);
        System.out.println(T);
    }

    private static class StringNum implements  Comparable<StringNum>{
        String s;
        int n;

        public StringNum(String s, int n) {
            this.s = s;
            this.n = n;
        }


        @Override
        public String toString() {
            return "StringNum{" +
                    "s='" + s + '\'' +
                    ", n=" + n +
                    '}';
        }

        @Override
        public int compareTo(StringNum o) {
            return this.s.compareTo(o.s);
        }
    }


}