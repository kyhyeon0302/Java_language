https://www.acmicpc.net/problem/11050


/*
1. 아이디어
조합으로 풀자
점화식 :   D[i][j]= D[i-1][j-1]+D[i-1][j];

i = 총 숫자의 갯수
j = 총 선택수의 갯수

dp배열 초기화
D[i][i] = 1, D[i][0] = 1, D[i][1] = i;


2. 시간복잡도



3. 변수
 */


import java.util.*;
import java.io.*;
	
	
public class Main{
	public static int N, K;
	public static int[][] D;
	
	
	
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		D = new int[N+1][N+1];
		
		
		//dp배열 초기화, 기본값 
		for(int i=0; i<=N; i++) {
			D[i][i] = 1;
			D[i][1] = i;
			D[i][0] = 1;
		}
		
		
		for(int i=2; i<=N; i++) { //1인것은 이미 초기화 했기 떄문! 
			for(int j=1; j<i; j++) { // i랑 같지 않은 이유는 앞에서 이미 초기화 했기 때문!
				D[i][j] = D[i-1][j-1] + D[i-1][j];
			}
		}
		
		System.out.println(D[N][K]);
	}
}
