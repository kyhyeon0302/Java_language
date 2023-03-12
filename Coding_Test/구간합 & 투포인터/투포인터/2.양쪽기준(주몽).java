// https://www.acmicpc.net/problem/1940
/*
1.아이디어: 투포인터 양쪽
A[start] + A[end] > M : end--
A[start] + A[end] < M : start++
A[start] + A[end] == M : start++, end--, cnt++

2.시간복잡도:
보통은 투포인터 O(n) 여기서는 정렬을 사용해야하므로 
O(nlogn)


3.자료구조(변수):
 */
import java.util.*;
import java.io.*;

public class Main{
	public static int N, M;
	public static int[] A; //입력받을 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		int start = 0;
		int end = N-1;
		int cnt = 0;

		while(start < end) {
			if(A[start] +  A[end] == M) {
				cnt++;
				start++;
				end--;
			}else if(A[start] + A[end] < M) {
				start++;
			}else {
				end--;
			}
		}
		System.out.println(cnt);
	}

}
