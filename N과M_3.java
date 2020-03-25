package 백준알고리즘.Algorithm_UsingJava;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_3 {
	static Scanner sc = new Scanner(System.in);
	static int N=sc.nextInt();
	static int M=sc.nextInt();
	static int array[] = new int[N];
	static int re_array[] = new int[M];
	
	public static void main(String args[]) {
		for(int i=0;i<N;i++) {
			array[i] = i+1;
		}
		Answer(0,M);
	}
	private static void Answer(int idx,int M) {
		if(idx == M) {
			for(int i=0;i<M;i++) {
				System.out.print(re_array[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<N;i++) {
				re_array[idx] = array[i];
				Answer(idx+1,M);
		}
	}
}

