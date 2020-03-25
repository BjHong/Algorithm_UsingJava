package 백준알고리즘.Algorithm_UsingJava;
import java.util.Scanner;
public class 백준가장긴증가하는부분수열11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int array[] = new int[N];
		int max = 0;
		for(int i=0;i<N;i++) {
			array[i] = sc.nextInt();
		}
		int count[] = new int[N];
		for(int i=0;i<N;i++) {
			count[i] = 1;
			int alpha=0;
			for(int j=0;j<i;j++) {
				if(array[j]<array[i]&&alpha<count[i]) {
					alpha = count[j];
					count[i] = count[j]+1;
				}
			}
			max=Math.max(max, count[i]);
		}
		System.out.println(max);
	}
		

}
