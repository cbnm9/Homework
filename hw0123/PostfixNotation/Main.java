package hw0123.PostfixNotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < M; i++) {
			char c = st.nextToken().charAt(0);

			// 연산자가 입력되면 스택에서 숫자 두개를 꺼내고 연산한 후 다시 스택에 넣기
			if (c == '+') {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(a + b);
			} else if (c == '/') {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(a / b);
			} else if (c == '*') {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(a * b);
			} else if (c == '-') {
				int b = stack.pop();
				int a = stack.pop();
				stack.add(a - b);
			}
			// 숫자가 입력되면 스택에 쌓기
			else {
				stack.add(Integer.parseInt(String.valueOf(c)));
			}
		}

		// 출력 할 정답은 스택에 있는 값
		bw.write(stack.pop() + "");

		bw.flush();

		bw.close();
		br.close();
	}

}
