package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ABCDE13024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		int N=sc.nextInt();
		int M=sc.nextInt();
		int array[][] = new int[N][N];
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			array[a][b] = 1;
			array[b][a] = 1;
		}
		int count_a=0;
		int ai=0;
		int k=0,p=0;
		int tmp=0;
		while(true) {
			if(array[k][p]==1) {
				if(array[0][1]==1) {
					count_a+=1;
					break;
				}
				else {
					tmp = p;
					p=k;
					k=tmp;
				}
			}
		}
		

	}

}
