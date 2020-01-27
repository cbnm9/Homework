package hw0123.SelectionSort;

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

	public static void SelectionSort(int[] arr, BufferedWriter bw) throws IOException {
		int len = arr.length;

		// len - 1 번 요소는 뒤에 비교할 요소가 없으므로 len - 2 까지만 반복
		for (int i = 0; i < len - 1; i++) {
			// i 번 요소가 최소값이라고 가정
			int min = i;
			// i 의 다음 요소부터 마지막 요소까지 반복
			for (int j = i + 1; j < len; j++) {
				// 더 작은 값이 발견되면 최소값 갱신
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			
			// i 위치와 최소값의 위치를 바꿈
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;

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
		SelectionSort(arr, bw);

		bw.flush();

		bw.close();
		br.close();
	}

}
