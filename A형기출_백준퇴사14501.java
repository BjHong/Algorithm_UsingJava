package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

class Friend {
	int time;
	int money;

	Friend(int time, int money) {
		this.time = time;
		this.money = money;
	}
}

public class A형기출_백준퇴사14501 {
	static int N;
	static int time[];
	static int money[];
	static boolean check[];
//	static ArrayList<Friend> list;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		max = 0;
		time = new int[N + 1];
		money = new int[N + 1];
		check = new boolean[N];
		for (int i = 1; i <= N; i++) {
			time[i] = sc.nextInt();
			money[i] = sc.nextInt();
		}
		powerset(0);
		System.out.println(max);
	}

	static void powerset(int idx) {
		if (idx == check.length) {
			int sum = 0;
			int flag = 0;
			for (int i = 1; i <= N; i++) {
				if (check[i - 1]) {
					if (i + time[i] - 1 > N) {
						flag = 1;
						break;
					}
					sum += money[i];
					i+=time[i]-1;
				}
			}
			if (flag == 0) {
				max = Math.max(max, sum);
			}
			return;
		}
		if (!check[idx])
			check[idx] = true;
		powerset(idx + 1);
		check[idx] = false;
		powerset(idx + 1);

	}

}
