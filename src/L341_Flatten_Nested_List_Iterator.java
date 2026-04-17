import struct.NestedInteger;
import struct.NestedIntegerImpl;
import struct.NestedIterator;
import struct.TreeNode;

import java.util.*;


/*

    You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
    Implement an iterator to flatten it.

    Implement the NestedIterator class:

    NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
    int next() Returns the next integer in the nested list.
    boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
    Your code will be tested with the following pseudocode:

    initialize iterator with nestedList
    res = []
    while iterator.hasNext()
        append iterator.next() to the end of res
    return res
    If res matches the expected flattened list, then your code will be judged as correct.



    Example 1:

    Input: nestedList = [[1,1],2,[1,1]]
    Output: [1,1,2,1,1]
    Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

    Example 2:
    Input: nestedList = [1,[4,[6]]]
    Output: [1,4,6]
    Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].


    Constraints:

    1 <= nestedList.length <= 500
    The values of the integers in the nested list is in the range [-10^6, 10^6].

 */

public class L341_Flatten_Nested_List_Iterator {

    public static void main(String[] args) {

        // [[1,1],2,[1,1]] -> [1,1,2,1,1]
        List<NestedInteger> ex1 = new ArrayList<>();
        List<NestedInteger> inner1 = new ArrayList<>();
        inner1.add(new NestedIntegerImpl(1));
        inner1.add(new NestedIntegerImpl(1));
        ex1.add(new NestedIntegerImpl(inner1));
        ex1.add(new NestedIntegerImpl(2));
        List<NestedInteger> inner2 = new ArrayList<>();
        inner2.add(new NestedIntegerImpl(1));
        inner2.add(new NestedIntegerImpl(1));
        ex1.add(new NestedIntegerImpl(inner2));

        NestedIterator s = new NestedIterator(ex1);

        long sysDate1 = System.currentTimeMillis();

        List<Integer> res = new ArrayList<>();
        while (s.hasNext()) {
            res.add(s.next());
        }
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}