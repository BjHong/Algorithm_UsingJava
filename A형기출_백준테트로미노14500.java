package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

public class A형기출_백준테트로미노14500 {
	static int tetris[] = {1,2,3,4,5};
	static int result[] = new int[5];
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int array[][] = new int[N][M];
		max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				array[i][j] = sc.nextInt();
			}
		}
		comb(0,0);
		System.out.println(max);
	}
	static void comb(int idx,int good) {
		if(good == result.length) {
			
			return;
		}
		if(idx == tetris.length) return;
		result[good] = tetris[idx];
		comb(idx+1,good+1);
		comb(idx+1,good);
	}

}
