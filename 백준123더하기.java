package 백준알고리즘.Algorithm_UsingJava;

import java.util.Arrays;
import java.util.Scanner;

public class 백준123더하기 {
	static int memo[] = new int[11];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase=sc.nextInt();
		for(int tc=1;tc<=testcase;tc++) {
			int N=sc.nextInt();
			memo[N] = dp(N);
			System.out.println(memo[N]);
//			System.out.print(Arrays.toString(memo));
		}
	}
	static int dp(int i) {
		if(i==1) return 1;
		if(i==2) return 2;
		if(i==3) return 4;
		if(memo[i] > 0)
			return memo[i];
		memo[i] = dp(i-1)+dp(i-2)+dp(i-3);
		return memo[i];
	}

}
