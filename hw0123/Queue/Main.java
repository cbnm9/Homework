package hw0123.Queue;

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
	
	public void setLink(LinkedObject<T> p) {
		link = p;
	}
}

class Queue<T> {
	private LinkedObject<T> front;
	private LinkedObject<T> end;
	private int number_of_data;
	
	public Queue() {
		front = null;
		end = null;
		number_of_data = 0;
	}
	
	public void push(T data) {
		LinkedObject<T> node = new LinkedObject<>(data, null);
		if(front == null)
			front = node;
		else
			end.setLink(node);
		end = node;
		number_of_data++;
	}
	
	public T pop() {
		T val = front.val;
		front = front.link;
		number_of_data--;
		return val;
	}
	
	public boolean isEmpty() {
		return (front == null)?true:false;
	}
	
	public int getNumberOfData() {
		return number_of_data;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Queue<Integer> queue = new Queue<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char operation = st.nextToken().charAt(0);

			// 각 명령 별 처리
			// 명령 i : 데이터 추가
			if (operation == 'i') {
				int num = Integer.parseInt(st.nextToken());
				queue.push(num);
			}
			// 명령 o : 데이터 꺼내기
			else if (operation == 'o') {
				if (queue.isEmpty()) {
					bw.write("empty\n");
				} else {
					bw.write(queue.pop() + "\n");
				}
			}
			// 명령 c : 데이터의 수 출력
			else {
				bw.write(queue.getNumberOfData() + "\n");
			}
		}

		bw.flush();

		bw.close();
		br.close();
	}

}
