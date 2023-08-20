package KSY;

import java.util.*;
class 여행경로 {
    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, Integer> visited = new HashMap<>();
    static String[] answer;
    static boolean flag=false;
        
    public static String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        
        for(int i=0; i<tickets.length; i++){
            //graph.computeIfAbsent(tickets[i][0], k -> new ArrayList<>()).add(tickets[i][1]);
        	// 티켓 개수 구하기 
        	String tempKey = tickets[i][0] + tickets[i][1];
        	if(visited.containsKey(tempKey))
        		visited.put(tempKey, visited.get(tempKey)+1);
        	else
        		visited.put(tempKey, 1);
        	
        	if(graph.containsKey(tickets[i][0])){
                graph.get(tickets[i][0]).add(tickets[i][1]);
            } else{
                List<String> list = new ArrayList<>();
                list.add(tickets[i][1]);
                graph.put(tickets[i][0], list);
            }
        }
        // Todo : map 출력 방법, computeIfAbsente
        
        for(Map.Entry<String, List<String>> entry: graph.entrySet()) {
        	Collections.sort(graph.get(entry.getKey()));  //정렬
        	System.out.println(entry.getKey() +" "+ entry.getValue());
        }
        
        DFS("ICN", 0);
        return answer;
    }
    
    public static void DFS(String vertex, int cnt){
    	if(cnt == answer.length-1){
            System.out.println("--"+Arrays.toString(answer));
            flag = true;
            return;
        }
    	answer[cnt] = vertex;
        
    	if(graph.containsKey(vertex)) {
    	    for(String v: graph.get(vertex)) {
    		    if(visited.get(vertex+v) > 0) {  //아직 방문하지 않은 
    			    visited.put(vertex+v, visited.get(vertex+v)-1);  // 방문 표시
                    answer[cnt+1] = v;
    			    DFS(v, cnt+1);
    			    if(!flag)  // 정답이 만들어지지 못 했다면 backtracking
    			    	visited.put(vertex+v, visited.get(vertex+v)+1);  // 미방문 표시
    		    }
    	    }
    	}
    }    
    public static void main(String[] args) {
//    	System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
    	System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
    
    }
}
