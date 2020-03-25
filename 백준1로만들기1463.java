package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

public class 백준1로만들기1463 {
	static int N;
	static int count;
	static int array[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		array = new int[N+1];
		count=0;
		go(N);
		System.out.println(array[N]);
	}
	static int go(int a) {
		array[1] = 0;
		if(N==1) return 0;
		for(int i=2;i<=N;i++) {
			array[i] = array[i-1]+1;
			if(i%3==0) {
				int tmp = array[i/3]+1;
				if(array[i]>tmp) {
					array[i] = tmp;
				}
			}
			if(i%2==0) {
				int tmp =array[i/2]+1;
				if(array[i]>tmp) {
					array[i] = tmp;
				}
			}
		}
		return array[N];
	}

}
