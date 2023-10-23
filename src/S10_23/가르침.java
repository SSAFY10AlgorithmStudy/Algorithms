package S10_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//	37308kb	 624ms
public class 가르침 {
    static Set<Character> commonWord,learnWord;
    static int n,k;
    static int learn[];
    static int answer;
    static Set<Character> words [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        if(k <5) {
            System.out.println(0);
            return;
        }
        words = new HashSet[n];
        for (int i = 0; i < n; i++) {
            words[i] = new HashSet<Character>();
        }
        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                words[i].add(charArray[j]);
            }

        }

        learn = new int[123];
        commonWord = new HashSet<Character>();
        commonWord.add('a');
        commonWord.add('c');
        commonWord.add('t');
        commonWord.add('n');
        commonWord.add('i');

        for (char a :commonWord) {
            learn[a] = 1;
        }

        learnWord = new HashSet<Character>();
        for (int i = 97; i < 123; i++) {
            learnWord.add((char)i);
        }
        learnWord.removeAll(commonWord);
        Object[] array = learnWord.toArray();

        find(new char[k-5],0,0,array);
        System.out.println(answer);
    }

    private static void find(char temp[],int cnt,int index,Object[] arr) {
        if(k-5 == cnt){
            for (char w :temp) {
                learn[w] = 1;
            }
            int a = check();
            if(answer < a) answer = Math.max(answer,a);
            for (char w :temp) {
                learn[w] = 0;
            }
            return;
        }
        for (int i = index; i < arr.length; i++) {
            char w = (char) arr[i];
            temp[cnt] = w;
            find(temp,cnt+1,i + 1,arr);
        }

    }

    private static int check() {
        int temp = 0;
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (char w : words[i]) {
                if(learn[w] == 0){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                temp++;
            }
        }
        return temp;
    }
}
