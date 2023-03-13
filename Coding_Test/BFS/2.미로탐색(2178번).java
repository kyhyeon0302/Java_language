https://www.acmicpc.net/problem/2178

import java.util.*;
import java.io.*;


public class Main{

	public static int N, M;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());


		map = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];

		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';

			}
		}

		BFS(0, 0);
		System.out.println(map[N-1][M-1]);

	}

	public static void BFS(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));


		while(!q.isEmpty()) {

			Node node = q.poll();

			for(int i=0; i<4; i++) {

				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >=0 && ny >=0 && nx < N && ny < M) {
					if(!visit[nx][ny] && map[nx][ny]== 1) {
						visit[nx][ny] = true;
						map[nx][ny] = map[node.x][node.y]+ 1;
						q.add(new Node(nx, ny));
						
						
					}
				}



			}
		}
	}
}

class Node{
	int x;
	int y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
