package hw0123.InsertionSort;

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

	public static void InsertionSort(int[] arr, BufferedWriter bw) throws IOException {
		int len = arr.length;

		// 첫 번째 요소는 정렬된 상태로 보고 1번 요소부터 반복
		for (int i = 1; i < len; i++) {
			// i 번 요소 꺼내기
			int val = arr[i];
			// 앞의 정렬된 배열과 크기를 비교하며 반복
			int j;
			for (j = i - 1; j >= 0; j--) {
				// j 번째 요소가 i번에서 꺼낸 요소보다 크다면
				// j + 1 번으로 자리 옮기기
				if (arr[j] > val) {
					arr[j + 1] = arr[j];
				}
				// j 번째 요소가 i번에서 꺼낸 요소보다 작다면 반복문 나가기
				else {
					break;
				}
			}
			// 위 반복문이 끝났을 때 j + 1 위치가 val 이 들어갈 위치
			arr[j + 1] = val;

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
		InsertionSort(arr, bw);

		bw.flush();

		bw.close();
		br.close();
	}

}
