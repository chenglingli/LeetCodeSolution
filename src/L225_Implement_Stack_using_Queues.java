import struct.MyStack;

public class L225_Implement_Stack_using_Queues {


    public static void main(String[] args) {

        L225_Implement_Stack_using_Queues s = new L225_Implement_Stack_using_Queues();
        long sysDate1 = System.currentTimeMillis();

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}