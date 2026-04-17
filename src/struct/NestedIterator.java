package struct;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }
        return !stack.isEmpty();
    }

    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}

class NestedIterator2 implements Iterator<Integer> {
    private int cursor = 0;
    private List<Integer> nestedList = new ArrayList();

    public NestedIterator2(List<NestedInteger> nestedList1) {
        plain(nestedList1);
    }

    public void plain(List<NestedInteger> nested) {
        for (NestedInteger n : nested) {
            if (n.isInteger()) {
                nestedList.add(n.getInteger());
            } else {
                plain(n.getList());
            }
        }
    }

    @Override
    public Integer next() {
        int i = cursor;
        cursor = i + 1;
        return nestedList.get(i);
    }

    @Override
    public boolean hasNext() {
        return cursor != nestedList.size();
    }
}
