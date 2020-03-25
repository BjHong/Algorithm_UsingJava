package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

public class 백준배수공사15817 {
	//dp question
	static int N,x;
	static int array[];
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		x=sc.nextInt();
		int array[] = new int[x+1];
		array[0]=1;
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int j=x;j>=0;j--) {
				if(array[j]!=0) {
					for(int k=1;k<=b;k++) {
						if(j+a*k>x) break;
						array[j+a*k]+=array[j];
					}
				}
			}
		}
		System.out.println(array[x]);
	}
}
