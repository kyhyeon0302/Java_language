import java.util.*;
import java.io.*;

public class Main{
	public static int N; // 초기 값 
	public static boolean[] visit; // 방문 배열
	public static ArrayList<Integer>[] tree; // 인접리스트
	public static int[] answer;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		
		visit = new boolean[N+1];
		tree = new ArrayList[N+1];
		answer = new int[N+1];
		
		
		
		for(int i=0; i<tree.length; i++) {  //인접리스트 초기화, 트리의 길이만큼 제작
			tree[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N; i++) { // 인접리스트 만들기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);

		}
		
		DFS(1); // 함수 실행 
		for(int i=2; i<=N; i++) { // for문을 돌리면서 answer에 담긴 원소들 출력
			System.out.println(answer[i]);
			
		}
	
		
		
	}
	
	public static void DFS(int num) { //DFS함수 구현하기 
		visit[num] = true; // 방문처리 
		for(int i : tree[num]) { // 숫자의 길이만큼 포문 진행 
			if(!visit[i]) { //만약 방문하지 않았더라면
				answer[i] = num; //answer에 해당 숫자 삽입
				DFS(i);
			}
		}
		
		
	}
	
}
