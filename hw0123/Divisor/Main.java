package hw0123.Divisor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static int findDivisor(int N, int K) {
		// 먼저 N 을 2로 나누어 약수를 구하는 반복 횟수 줄이기
		int iter = N / 2;

		// 약수가 저장될 집합(중복 제거)
		// TreeSet 은 중복제거 + 오름차순 정렬
		Set<Integer> set = new TreeSet<>();
		for (int i = 1; i <= iter; i++) {
			// N이 i에 의해 나누어 떨어지면
			if (N % i == 0) {
				// i 와 N 을 i 로 나눈 몫이 약수가 된다
				set.add(i);
				set.add(N / i);
			}
		}

		// list의 원소 갯수 세기
		int len = set.size();

		// 약수의 갯수가 K 보다 작다면 0 반환
		if (len < K)
			return 0;

		// K 번 째로 작은 요소를 반환하기 위한 iterator 가져오기
		Iterator<Integer> it = set.iterator();

		// list의 K 번 째로 작은 요소 반환
		for (int i = 0; i < K - 1; i++) {
			it.next();
		}
		return it.next();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		bw.write(findDivisor(N, K) + "");

		bw.flush();

		bw.close();
		br.close();
	}

}
