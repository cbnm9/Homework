package hw0123.PrimeNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	// 에라토스테네스의 체 알고리즘을 이용해 소수 배열 만들기
	public static void makePrimeArray(boolean[] arr, int max) {

		// 먼저 숫자 0과 1은 소수가 아니므로 true
		arr[0] = arr[1] = true;

		// 2 부터 숫자를 키워가며 배수들을 제외
		// 이 때 sqrt(max) 아래의 정수 까지만 이 처리과정을 거치면 된다
		// ( sqrt(max) = a 일 때 a*a = max 이며 이 a를 기준으로 약수는 대칭을 이룸)
		// ( ex> 12: 2 3 4 6, sqrt(12) = 3.xxx, 2*6 과 3*4 는 3.xx 기준 대칭)
		// 즉, i = 2 ~ (int)sqrt(max)
		int iter = (int) Math.sqrt(max);
		for (int i = 2; i <= iter; i++)
			// i 가 소수인 경우
			if (!arr[i])
				// i 이후 i의 배수들을 true 로 설정
				// 이 때 i * i 이전은 i 보다 작은 수의 배수로써 처리 되었기 때문에
				// i * i 부터 처리하면 된다
				for (int j = i * i; j <= max; j += i)
					arr[j] = true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());

		// 숫자를 인덱스로 접근했을 때 소수면 false 값을 가지는 배열 만들기
		boolean[] isNotPrime = new boolean[max + 1];
		makePrimeArray(isNotPrime, max);

		// 숫자 범위 내 소수의 갯수 세기
		int result = 0;
		for(int i = min; i <= max; i++)
			if(!isNotPrime[i])
				result++;
		
		bw.write(result +"");

		bw.flush();

		bw.close();
		br.close();
	}

}
