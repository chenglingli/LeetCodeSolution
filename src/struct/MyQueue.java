package struct;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();

    }

    public void push(int x) {
        while (!s2.empty()) {
            s1.push(s2.peek());
            s2.pop();
        }
        s2.push(x);
        while (!s1.empty()) {
            s2.push(s1.peek());
            s1.pop();
        }
    }

    public int pop() {
        if (!s2.empty()) {
            return s2.pop();
        }
        return 0;
    }

    public int peek() {
        if (!s2.empty()) {
            return s2.peek();
        }
        return 0;
    }

    public boolean empty() {
        return s2.empty();
    }
}
