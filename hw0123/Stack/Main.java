package hw0123.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class LinkedObject<T> {
	public T val;
	public LinkedObject<T> link;

	public LinkedObject(T v, LinkedObject<T> p) {
		val = v;
		link = p;
	}
}

class Stack<T> {
	private LinkedObject<T> top;
	private int number_of_data;

	public Stack() {
		top = null;
		number_of_data = 0;
	}

	public void push(T val) {
		LinkedObject<T> obj = new LinkedObject<>(val, top);
		top = obj;
		number_of_data++;
	}

	public T pop() {
		T val = top.val;
		top = top.link;
		number_of_data--;
		return val;
	}

	public T peek() {
		return top.val;
	}

	public boolean isEmpty() {
		return (top == null) ? true : false;
	}

	public int getNumberOfData() {
		return number_of_data;
	}
}

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		// 입출력용 버퍼 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 문제 해결을 위한 스택 생성
		Stack<Integer> stack = new Stack<>();

		// 명령의 수 입력
		int N = Integer.parseInt(br.readLine());

		// 명령의 수 만큼 반복
		for (int i = 0; i < N; i++) {
			// 명령 한줄 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			char operation = st.nextToken().charAt(0);

			// 각 명령 별 처리
			// 명령 i : 데이터 추가
			if (operation == 'i') {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}
			// 명령 o : 데이터 꺼내기
			else if (operation == 'o') {
				if (stack.isEmpty()) {
					bw.write("empty\n");
				} else {
					bw.write(stack.pop() + "\n");
				}
			}
			// 명령 c : 데이터의 수 출력
			else {
				bw.write(stack.getNumberOfData() + "\n");
			}
		}

		bw.flush();
		
		bw.close();
		br.close();
	}

}
