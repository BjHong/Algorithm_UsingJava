package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

public class 백준계단오르기2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int score[] = new int[N+1];
		int memo[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			score[i] = sc.nextInt();
		}
		memo[1]=score[1];
		memo[2]=score[1]+score[2];
		for(int i=3;i<=N;i++) {
			int a=0;int b=0;
			a = score[i]+memo[i-2];
			if(i-3==0) {
				memo[i]=a;
				continue;
			}
			b = score[i]+score[i-1]+memo[i-3];
			memo[i]=Math.max(a, b);
		}
		System.out.println(memo[N]);
		
	}

}
