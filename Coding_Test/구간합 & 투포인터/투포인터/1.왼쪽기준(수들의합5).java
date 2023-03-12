// https://www.acmicpc.net/problem/2018

/*
 1.아이디어:  투포인터
sum > N :  sum = sum - start, start++;
sum > N :  end++, sum = sum + end;
sum == N : end++, sum + sum + end, cnt++

2. 시간복잡도 :
정렬하지 않은 투포인트 O(N)

3. 자료구조(변수) :
N, count ,sum, start, end, 

 */

import java.util.*;
import java.io.*;


public class Main{
	//연속된 합이 15가 되어야한다.
	public static int N;
	public static int count, sum, start, end;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		count = 1;
		sum = 1;
		start = 1;
		end = 1;

		while(end != N) {
			if(sum == N) {
				count++;
				end++;
				sum = sum + end;

			}else if(sum > N) {
				sum = sum - start;
				start++;
				
			} else {
				end++;
				sum = sum + end;
			}
		}
		System.out.println(count);	
	}
}
