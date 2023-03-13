// https://www.acmicpc.net/problem/2667

import java.util.*;
import java.io.*;

public class Main{
	public static int N;
	public static int[][] map;
	public static boolean[][] visited;
	public static int areaCount = 0;


	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	public static ArrayList<Integer> result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0; i<N; i++) {
			String str = br.readLine(); //2차원 배열에 input값 삽입 
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0'; //배열에서 띄어쓰기가 없으므로 charAt 사용
			}

		}

		result = new ArrayList<>(); //결과 값을 ArrayList에 담기 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					areaCount++; // 2차원 배열을 수행하면서 집의 갯수를 증가
					BFS(i, j); // BFS수행하기
				}
			}
		}

		System.out.println(areaCount); // 집의 갯수 출력
		Collections.sort(result); //result값을 오름차순으로 정리
		for(int i=0; i<result.size(); i++) { //ArrayList는 size()가 길이가 된다. 기본 배열의 length와 차이가 존재 
			System.out.println(result.get(i)); // 정돈된 원소 출력하기
		}




	}

	public static void BFS(int x, int y) {
		Queue<Node> q = new LinkedList<>(); //queue를 사용하기 위한 LinkedList 선언
		int count = 1; //처음 갯수는 0으로 지정
		q.add(new Node(x, y)); // q에 정보 저장
		visited[x][y] = true; // 방문 처리 

		while(!q.isEmpty()) { // q가 빌 때 까지 while문으로 반복 수행
			Node node = q.poll(); // 첫 원소 뽑아서 출력

			for(int i=0; i<4; i++) { // 상하좌우 탐색 시작 
				int nx = node.x + dx[i]; // nx로 업데이트 
				int ny = node.y + dy[i]; // ny로 업데이트 
				if(nx >= 0 && ny >=0 && nx < N && ny <N ) { //범위를벗어 나지 않는 선에서 실행 
					if(!visited[nx][ny] && map[nx][ny] == 1) { //단지가 존재하고 방문 한적이 없으면 
						visited[nx][ny]  = true; //방문 처리 
						count++; // 갯수 증가 
						q.add(new Node(nx, ny)); //방문처리된 노드를 q에 저장. 계속 반복
					}

				}
			}
		}
		result.add(count); //while문으로 q가 비면 결과를 result에 저장
	}
}


class Node{ //Node class만들기
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


