import java.util.Arrays;

public class L1409_Queries_on_a_Permutation_With_Key {

    /*

    Given the array queries of positive integers between 1 and m, you have to process all queries[i] (from i=0 to i=queries.length-1) according to the following rules:

    In the beginning, you have the permutation P=[1,2,3,...,m].
    For the current i, find the position of queries[i] in the permutation P (indexing from 0) and then move this at the beginning of the permutation P.
    Notice that the position of queries[i] in P is the result for queries[i].
    Return an array containing the result for the given queries.



    Example 1:

    Input: queries = [3,1,2,1], m = 5
    Output: [2,1,2,1]
    Explanation: The queries are processed as follow:
    For i=0: queries[i]=3, P=[1,2,3,4,5], position of 3 in P is 2, then we move 3 to the beginning of P resulting in P=[3,1,2,4,5].
    For i=1: queries[i]=1, P=[3,1,2,4,5], position of 1 in P is 1, then we move 1 to the beginning of P resulting in P=[1,3,2,4,5].
    For i=2: queries[i]=2, P=[1,3,2,4,5], position of 2 in P is 2, then we move 2 to the beginning of P resulting in P=[2,1,3,4,5].
    For i=3: queries[i]=1, P=[2,1,3,4,5], position of 1 in P is 1, then we move 1 to the beginning of P resulting in P=[1,2,3,4,5].
    Therefore, the array containing the result is [2,1,2,1].

    Example 2:
    Input: queries = [4,1,2,2], m = 4
    Output: [3,1,2,0]

    Example 3:
    Input: queries = [7,5,5,8,3], m = 8
    Output: [6,5,0,7,5]


    Constraints:
    1 <= m <= 10^3
    1 <= queries.length <= m
    1 <= queries[i] <= m

     */

    public int[] processQueries(int[] queries, int m) {
        int [] res = new int[queries.length];
        int[] P = new int[m];
        for (int i = 0; i < m; i++) {
            P[i] = i + 1;
        }

        for (int i = 0; i < queries.length; i++) {
            int index = -1;
            for (int j = 0; j < P.length; j++) {
                if (P[j] == queries[i]) {
                    index = j;
                    break;
                }
            }
            res[i] = index;
            for (int j = index; j > 0; j--) {
                P[j] = P[j - 1];
            }
            P[0] = queries[i];
        }

        return res;
    }



    int[] fenwickTree;
    int size;

    public void update(int index, int val) {
        while (index <= size) {
            fenwickTree[index] += val;
            index += index & (-index);
        }
    }

    public int query(int index) {
        int ans = 0;
        while (index > 0) {
            ans += fenwickTree[index];
            index -= index & (-index);
        }
        return ans;
    }

    public int[] processQueries2(int[] queries, int m) {
        int front = queries.length;
        int arr[] = queries.clone();
        int res[] = new int[queries.length];
        int[] position = new int[m + 1];
        size = m+m;
        fenwickTree = new int[size+1];
        for (int value = 1; value <= m; value++) {
            position[value] = queries.length + value;
            update(position[value], 1);
        }
        int i = 0;
        for (int query : queries) {
            int pos = position[query];
            int ans = query(pos - 1);
            update(pos, -1);
            position[query] = front;
            update(front, 1);
            front--;
            res[i++] = ans;
        }
        return res;
    }

    public static void main(String[] args) {

        L1409_Queries_on_a_Permutation_With_Key s = new L1409_Queries_on_a_Permutation_With_Key();
        long sysDate1 = System.currentTimeMillis();

        int[] queries = {3, 1, 2, 1};
        int m = 5;

        int[] res = s.processQueries(queries, m);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}