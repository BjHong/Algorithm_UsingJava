package 백준알고리즘.Algorithm_UsingJava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kimmseonhong
 *
 */
public class N과M_8 {
	static Scanner sc = new Scanner(System.in);
	static int N=sc.nextInt();
	static int M=sc.nextInt();
	static int array[] = new int[N];
	static int re_array[] = new int[M];
	static boolean bo_array[] = new boolean[N];
	
	public static void main(String args[]) {
		for(int i=0;i<N;i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		Answer(0,M,0);
	}
	private static void Answer(int idx,int M,int start) {
		if(idx == M) {
			for(int i=0;i<M;i++) {
				System.out.print(re_array[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<N;i++) {
				re_array[idx] = array[i];
				Answer(idx+1,M,i);
		}
	}
}

