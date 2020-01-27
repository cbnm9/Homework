package hw0123.BubbleSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void PrintArr(int[] arr, BufferedWriter bw) throws IOException {
		for (int i : arr) {
			bw.write(i + " ");
		}
		bw.newLine();
	}

	public static void BubbleSort(int[] arr, BufferedWriter bw) throws IOException {
		int len = arr.length;

		// i 는 두 번째 반복문의 반복 범위를 정해주는데 사용
		// 즉, 처음엔 len - 2 번 요소까지 다음 요소와 비교하지만
		// 마지막엔 0번 요소만 다음 요소와 비교
		for (int i = len - 2; i >= 0; i--) {
			// 첫 번째 요소부터 아직 정렬되지 않은 마지막 요소까지 반복 비교
			// 즉, 첫 번째 요소부터 i + 1 번째 요소 중 가장 큰 수를 맨 뒤로 보내기
			for (int j = 0; j <= i; j++) {
				// j 번째 요소가 그 다음 요소보다 크다면 자리 바꾸기
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			PrintArr(arr, bw);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 수열의 길이 입력
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 수열 입력
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬 및 각 단계별 결과를 출력
		BubbleSort(arr, bw);

		bw.flush();

		bw.close();
		br.close();
	}

}
