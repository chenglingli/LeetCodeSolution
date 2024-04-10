import java.util.*;

public class L284_Peeking_Iterator {

    public static void main(String[] args) {

        long sysDate1 = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> input = list.iterator();

        PeekingIterator peekingIterator = new PeekingIterator(input); // [1,2,3]

        // return 1, the pointer moves to the next element [1,2,3].
        System.out.println(peekingIterator.next());

        // return 2, the pointer does not move [1,2,3].
        System.out.println(peekingIterator.peek());

        // return 2, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.next());

        // return 3, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.next());

        // return False
        System.out.println(peekingIterator.hasNext());

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

class PeekingIterator implements Iterator<Integer> {

    private Queue<Integer> queue;

    public PeekingIterator(Iterator<Integer> iterator) {

        queue = new LinkedList<>();
        while (iterator.hasNext()) {
            queue.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return queue.remove();
    }

    @Override
    public boolean hasNext() {
        return queue.size() > 0;
    }
}


class PeekingIterator2 implements Iterator<Integer> {
    private Integer next = null;//缓冲变量
    private Iterator<Integer> iter;

    public PeekingIterator2(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}