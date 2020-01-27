package hw0123.gcd_lcm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	// 유클리드 호제법을 사용한 lcm, gcd 구하는 함수
	// 유클리드 호제법: gcd(a, b) = gcd(b, a mod b)

	// 최대 공약수
	public static int gcd(int a, int b) {
		// a 를 b 로 나눈 나머지 구하기
		int mod = a % b;

		// 나머지 연산의 결과가 0이 될 때 까지 반복
		while (mod > 0) {
			// a 에는 b 를 넣기
			a = b;
			// b 에는 (a % b) 넣기
			b = mod;
			mod = a % b;
		}
		return b;
	}

	// 최소 공배수는 a 와 b 의 곱을 두 수의 최대 공약수로 나눈 것
	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	// a, b 의 최대 공약수가 D 일때
	// a, b, c 의 최대 공약수는 D, c 의 최대 공약수와 같다
	public static int getGcd(int[] arr) {
		int g = arr[0];
		int len = arr.length;

		for (int i = 1; i < len; i++) {
			g = gcd(g, arr[i]);
		}

		return g;
	}

	// 위 최대 공약수랑 같은 원리
	public static int getLcm(int[] arr) {
		int l = arr[0];
		int len = arr.length;

		for (int i = 1; i < len; i++) {
			l = lcm(l, arr[i]);
		}

		return l;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(getGcd(arr) + " ");
		bw.write(getLcm(arr) + "");

		bw.flush();

		bw.close();
		br.close();
	}

}
