import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1656_Design_an_Ordered_Stream {


    /*

    There is a stream of n (idKey, value) pairs arriving in an arbitrary order,
    where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.

    Design a stream that returns the values in increasing order of their IDs by returning a chunk (list) of values after each insertion.
    The concatenation of all the chunks should result in a list of the sorted values.

    Implement the OrderedStream class:

    OrderedStream(int n) Constructs the stream to take n values.
    String[] insert(int idKey, String value) Inserts the pair (idKey, value) into the stream,
    then returns the largest possible chunk of currently inserted values that appear next in the order.


    Example:
    Input
    ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
    [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
    Output
    [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]

    Explanation
    // Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
    OrderedStream os = new OrderedStream(5);
    os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
    os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
    os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
    os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
    os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
    // Concatentating all the chunks returned:
    // [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
    // The resulting order is the same as the order above.


    Constraints:

    1 <= n <= 1000
    1 <= id <= n
    value.length == 5
    value consists only of lowercase letters.
    Each call to insert will have a unique id.
    Exactly n calls will be made to insert.

     */
    class OrderedStream {

        int ptr;
        String[] res;

        public OrderedStream(int n) {
            ptr = 0;
            res = new String[n];
        }

        public List<String> insert(int id, String value) {
            List<String> list = new ArrayList<>();

            res[id - 1] = value;
            while (ptr < res.length && res[ptr] != null) {
                list.add(res[ptr]);
                ptr++;
            }

            return list;
        }
    }

    class OrderedStream2 {

        public OrderedStream2(int n) {
            arr = new String[n + 1];
        }

        public String[] insert(int idKey, String value) {
            arr[idKey] = value;
            if (arr[next] == null) return EMPTY;
            final int start = next;
            while (next < arr.length && arr[next] != null)
                next++;
            final String[] dst = new String[next - start];
            System.arraycopy(arr, start, dst, 0, next - start);
            return dst;
        }

        private int next = 1;
        private String[] arr;
        private final String[] EMPTY = new String[0];
    }

    public static void main(String[] args) {

        L1656_Design_an_Ordered_Stream s = new L1656_Design_an_Ordered_Stream();
        long sysDate1 = System.currentTimeMillis();

        OrderedStream o = s.new OrderedStream(5);
        System.out.println(o.insert(3, "ccccc"));
        System.out.println(o.insert(1, "aaaaa"));
        System.out.println(o.insert(2, "bbbbb"));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}