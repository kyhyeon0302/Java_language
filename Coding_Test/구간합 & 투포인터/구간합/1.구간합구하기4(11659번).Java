// https://www.acmicpc.net/problem/11659

/*
 *  합 배열 : S[i] = S[i-1] + A[i];
 *  구간 합 배열 result[i] = S[j] - S[i-1];
 * 
 * 
 * 
 */


import java.util.*;
import java.io.*;


public class Main{
	public static int N, M;
	public static int[] S;
	public static int[] A;
	public static int[] result;
	
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		S = new int[N+1]; //합 배열
		A = new int[N+1]; //입력 받은 배열
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			S[i] = S[i-1] + A[i]; // 합 배열 공식  a(n) = s(n) - s(n-1);
		}
		
		
		result = new int[M+1];
		
		for(int k=1; k<=M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			result[k] = S[j] - S[i-1]; // 구간 합 공식
			System.out.println(result[k]);
			
		}
	}
}
