package Programmers;

import java.util.*;

class P3_43164 {
    static HashMap<String,ArrayList<String>> grp; //그래프 저장
    static ArrayList<String> answer; //정답리스트
    static int totalTickets; //총길이
    static int first=0; //답 여러개 경우 하나만 출력하기 위해서 사용
    public ArrayList<String> solution(String[][] tickets) {
        grp = new HashMap<>(); 
        answer= new ArrayList<String>();
        for (int i = 0; i < tickets.length; i++) {
            String a = tickets[i][0];
            String b = tickets[i][1];
            if(!grp.containsKey(a)){
                grp.put(a, new ArrayList<String>());
            }
            grp.get(a).add(b); //그래프 추가
        }
        for (ArrayList<String> values: grp.values()) {
            Collections.sort(values); //이름순으로 방문하기 위해 정렬
        }

        totalTickets = tickets.length+1; //정답 길이는 티켓 길이 +1
        ArrayList<String> dd = new ArrayList<String>();
        dd.add("ICN");  //처음에 인천넣어주기
        find("ICN", dd); //찾기

        return answer;
    }

    private void find(String v, ArrayList<String> data) {
        if(totalTickets == data.size()){ //티켓길이랑 data 길이가 같으면
            if(first != 0) return; //첫번째가 아니면 리턴
            answer=  (ArrayList<String>) data.clone(); //정답에 데이터 복사
            first++; //복사되었으니 first 하나 증가
            return;
        }
        if(grp.containsKey(v)){ //해당 키가 있으면
            ArrayList<String> nodes = grp.get(v); //꺼내기
            for(int i =0; i<nodes.size();i++){ //꺼낸거 다돌기
                String city = nodes.get(i); //꺼낸거 하나 도시 선택
                data.add(city); //데이터에 추가
                nodes.remove(i); //nodes에서 제거

                find(city,data); //찾기

                for (int j = data.size()-1; j >= 0; j--) { //원복하려고하는데 같은 이름일 경우 remove 사용하면 앞에꺼 삭제되어서 꼬임
                    if(data.get(j).equals(city)){ //그래서 뒤에꺼 제거
                        data.remove(j);
                        break;
                    }
                }
                nodes.add(i,city); //원래자리에 도시다시 넣기
            }
        }
    }
}
