import struct.MinStack;

public class L155_Min_Stack {

    public static void main(String[] args) {

        L155_Min_Stack s = new L155_Min_Stack();
        long sysDate1 = System.currentTimeMillis();

        /**

         ["MinStack","push","push","push","push"
         ,"pop","getMin",
         -1024

         "pop","getMin",
         -1024

         "pop","getMin"]
         512



         [[],[512],[-1024],[-1024],[512],
         [],[],[],[],[],[]]



         */


        MinStack obj = new MinStack();

        System.out.println(obj.getMin());

        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);

        obj.pop();
        System.out.println(obj.getMin());

        obj.pop();
        System.out.println(obj.getMin());

        obj.pop();
        System.out.println(obj.getMin());

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}