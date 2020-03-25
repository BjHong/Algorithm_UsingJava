package 백준알고리즘.Algorithm_UsingJava;

import java.util.Arrays;
import java.util.Scanner;

public class 소수찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int array[]=new int[N];
		for(int i=0;i<N;i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		int answer=0;
		for(int i=0;i<N;i++) {
			int count=0;
			if(array[i] == 1) {
				continue;
			}
			else {
				for(int j=2;j<=array[i];j++) {
					if(array[i]%j!=0) {
						count++;
					}
				}
				if(count==array[i]-2) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}
