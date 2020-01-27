package hw0123.IronStick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int len = str.length();

		int count = 0;
		char prev_c = '(';
		int result = 0;
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);

			// ( 가 입력되면 count 올리고 이 값 저장하기
			if (c == '(') {
				count++;
				prev_c = c;
			}
			// ) 가 입력되면 이전 입력에 따라 처리하고 이 값 저장하기
			else {
				// 먼저 카운트 내리기
				count--;
				// 이전 값이 '(' 이라면 레이저이므로 결과에 자른 쇠막대기 수 넣기
				if (prev_c == '(') {
					result += count;
				}
				// 이전 값이 ')' 이라면 막대기의 끝이므로 결과에 1 더하기
				else {
					result++;
				}
				prev_c = c;
			}
		}

		// 결과 출력
		bw.write(result + "");

		bw.flush();

		bw.close();
		br.close();
	}

}
