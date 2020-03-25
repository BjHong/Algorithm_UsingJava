package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

public class A형기출_백준수들의합2_2003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int array[] = new int[N];
		for(int i=0;i<N;i++) {
			array[i] = sc.nextInt();
		}
		int count=0;
		for(int i=0;i<N;i++) {
			int sum=0;
			for(int j=i;j<N;j++) {
				sum+=array[j];
				if(sum == M) {
					count++;
					break;
				}
				if(sum>M) break;
			}
		}
		System.out.println(count);
	}

}
