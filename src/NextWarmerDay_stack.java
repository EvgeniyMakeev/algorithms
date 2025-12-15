import java.util.Arrays;
import java.util.Stack;

// Через сколько дней будет день, который теплее текущего O(n)

public class NextWarmerDay_stack {
    public static void main(String[] args) {
        int[] t = {13, 12, 15, 11, 9, 12, 16};
        System.out.println(Arrays.toString(temperatures(t)));
    }
    public static int[] temperatures(int[] t) {
        Stack<C> stack = new Stack<>();
        int[] answer = new int[t.length];
        for (int i = t.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && stack.peek().value <= t[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek().index - i;
            }
            stack.push(new C(t[i], i));
        }
        return answer;
    }
}
class C {
    int value;
    int index;

    public C(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
