https://www.acmicpc.net/problem/2747

import java.util.*;
import java.io.*;

public class Main{
	public static int[] D;
	public static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(br.readLine());
		 D = new int[n+1];
		 
		 for(int i=0; i<=n; i++) {
			 D[i] = -1;				 
		 }
		 D[0] = 0;
		 D[1] = 1;
		 fibo(n);
		 System.out.println(D[n]);
	}
	
	public static int fibo(int n) {
		if( D[n] != -1) { //메모리제이션 : 기존계산은  재계산하지 않고 리턴
			return D[n];
		}
		return D[n] = fibo(n-1) + fibo(n-2);
	}
}
