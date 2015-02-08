package solutions;

public class LengthOfLastWord {

	int lengthOfLastWord(String s) {
		int len = s != null ? s.length() : 0;
		int rear = len;
		while (rear - 1 >= 0 && s.charAt(rear - 1) == ' ') {
			--rear;
		}
		int front = rear;
		while (front - 1 >= 0 && s.charAt(front - 1) != ' ') {
			--front;
		}
		return rear - front;
	}

}
