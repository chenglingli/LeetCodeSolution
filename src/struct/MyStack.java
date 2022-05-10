package struct;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.add(x);
        } else if (q1.isEmpty()) {
            q1.add(x);
            while (!q2.isEmpty()) {
                q1.add(q2.peek());
                q2.poll();
            }
        } else {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.poll();
            }
        }
    }

    public int pop() {
        int val = 0;

        if (!q1.isEmpty()) {
            val = q1.peek();
            q1.poll();
        } else {
            val = q2.peek();
            q2.poll();
        }

        return val;
    }

    public int top() {
        if (!q1.isEmpty())
            return q1.peek();
        else if (!q2.isEmpty())
            return q2.peek();
        else
            return 0;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
