import struct.MyQueue;
import struct.MyStack;

public class L232_Implement_Queue_using_Stacks {


    public static void main(String[] args) {

        L232_Implement_Queue_using_Stacks s = new L232_Implement_Queue_using_Stacks();
        long sysDate1 = System.currentTimeMillis();

        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}