package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

public class 백준2xN타일링11726 {
	static int N;
	static int array[][];
	static int d[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		array = new int[2][N];
		d = new int[N+1];
		System.out.println(go(N));
	}
	static int go(int a) {
		if(a==0) return 0;
		else if(a==1) return 1;
		else if(a==2) return 2;
		d[0]=0;
		d[1]=1;
		d[2]=2;
		for(int i=3;i<=N;i++) {
			d[i] = (d[i-1]+d[i-2])%10007;
		}
		return d[N];
	}

}
