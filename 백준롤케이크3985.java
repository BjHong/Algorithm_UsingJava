package 백준알고리즘.Algorithm_UsingJava;
import java.util.Scanner;
public class 백준롤케이크3985 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int array[] = new int[M+1];
		int array_lol[] = new int[N+1];
		int array_answer[] = new int[N+1];
		for(int i=1;i<=M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			array[i] = b-a+1;
			for(int j=a;j<=b;j++) {
				if(array_lol[j]==0) {
					array_lol[j] = i;
					array_answer[i]++;
				}
			}
		}
		int max=0,answer1 = 0;
		for(int i=1;i<=M;i++) {
			if(array[i]>max) {
				max = array[i];
				answer1 = i;
			}
		}
		max=0;
		int answer2 = 0;
		for(int i=1;i<=N;i++) {
			if(array_answer[i]>max) {
				max = array_answer[i];
				answer2 = i;
			}
		}
		System.out.println(answer1);
		System.out.println(answer2);
	}
}
