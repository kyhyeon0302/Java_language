https://www.acmicpc.net/problem/14502

import java.util.*;
import java.io.*;


public class Main{
	public static int[][] map; // 입력 받을 지도 
	public static int[][] virus_map; // 바이러스 지도
	public static int N, M;
	public static boolean[][] visit;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	public static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		virus_map = new int[N][M];
	
		for(int i=0; i<N; i++) { // 지도에 값 입력하기.
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0); // 벽세우고 바이러스 뿌리기 
		System.out.println(result); //결과 값 출력하기 
	}

	public static void DFS(int depth) {
		if(depth == 3) { // 깊이가 3, 즉 벽3개 세우면 바이러스 뿌리기(바이러스 함수 실행) 
			BFS(); // 인자 없이 함수 실행하기 
			return;
		}

		for(int i=0; i<N; i++) { // 벽3개 못 세웠다면 다시 세우기.
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) { //만약 빈칸인경우 아래 문장 실행
					map[i][j] = 1; // 지도 업데이트 벽 세우기 
					DFS(depth + 1); // 재귀함수 호출
					map[i][j] = 0; // 다시 돌려놓기. 
				}
			}
		}
	}

	public static void BFS()  { //바이러스  퍼트리기 BFS
		Queue<Node> q = new LinkedList<>(); // 큐 선언하기 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				virus_map[i][j] = map[i][j]; // 바이러스 지도 제작 
				
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virus_map[i][j] == 2) { //만약 바이러스면 큐에 넣는다. 
					q.add(new Node(i, j)); // q에 좌표점 담기 좌표 숫자가 2이면 담아야함. 
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if( nx>=0 && ny>=0 && nx<N && ny < M) {
					if(virus_map[nx][ny] == 0) { // 만약 벽 없이 0이면 바이러스 퍼짐 
						virus_map[nx][ny] = 2; // 바이러스 퍼진것 
						q.add(new Node(nx,ny)); // 퍼진 바이러스 큐에 담기 
					}
				}
			}
			
			
		}
		safe(virus_map); // 제작된 바이러스 지도를 safe함수에 인자로 사용하기 
	}
	
	public static void safe(int[][] virus_map) { // 바이러스 맵 인자로 입력받기. 
		int count = 0;   // 초기 count = 0; 
		for(int i=0; i<N; i++) { 
			for(int j=0; j<M; j++) {
				if(virus_map[i][j] ==0) {
					count++; // 만약에 인자로 받은 바이러스 맵에서 0이면 안전지역을 말함. 
				}
			}
		}
		result = Math.max(count, result); // 안전지역의 최대값 출력	
	}
}

class Node{ //바이러스를 퍼트릴 클래스 만들기 (큐에 x,y 좌표값 넣는 것) 
	int x;
	int y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
