package struct;

import java.util.Objects;
import java.util.Stack;

public class MinStack {

    Stack<Integer> data;
    Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        data.push(val);

        if(min.empty() || val<=getMin())
            min.push(val);
    }

    public void pop() {
        if(Objects.equals(data.peek(), min.peek())) {
            min.pop();
        }

        data.pop();
    }

    public int top() {
        if (data.empty()) {
            return 0;
        }
        return data.peek();
    }

    public int getMin() {
        if (min.empty()) {
            return 0;
        }
        return min.peek();
    }
}
