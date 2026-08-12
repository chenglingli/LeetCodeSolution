import java.util.Arrays;

public class L3016_Minimum_Number_of_Pushes_to_Type_Word_II {

    /*
    You are given a string word containing lowercase English letters.

    Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them.
    For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .

    It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters,
    but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.

    Return the minimum number of pushes needed to type word after remapping the keys.

    An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map to any letters.




    Example 1:


    Input: word = "abcde"
    Output: 5
    Explanation: The remapped keypad given in the image provides the minimum cost.
    "a" -> one push on key 2
    "b" -> one push on key 3
    "c" -> one push on key 4
    "d" -> one push on key 5
    "e" -> one push on key 6
    Total cost is 1 + 1 + 1 + 1 + 1 = 5.
    It can be shown that no other mapping can provide a lower cost.
    Example 2:


    Input: word = "xyzxyzxyzxyz"
    Output: 12
    Explanation: The remapped keypad given in the image provides the minimum cost.
    "x" -> one push on key 2
    "y" -> one push on key 3
    "z" -> one push on key 4
    Total cost is 1 * 4 + 1 * 4 + 1 * 4 = 12
    It can be shown that no other mapping can provide a lower cost.
    Note that the key 9 is not mapped to any letter: it is not necessary to map letters to every key, but to map all the letters.
    Example 3:


    Input: word = "aabbccddeeffgghhiiiiii"
    Output: 24
    Explanation: The remapped keypad given in the image provides the minimum cost.
    "a" -> one push on key 2
    "b" -> one push on key 3
    "c" -> one push on key 4
    "d" -> one push on key 5
    "e" -> one push on key 6
    "f" -> one push on key 7
    "g" -> one push on key 8
    "h" -> two pushes on key 9
    "i" -> one push on key 9
    Total cost is 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 2 * 2 + 6 * 1 = 24.
    It can be shown that no other mapping can provide a lower cost.


    Constraints:

    1 <= word.length <= 10^5
    word consists of lowercase English letters.

     */
    public int minimumPushes(String word) {
        // 26个字母，每个字母映射到1-9中的一个数字键上。一共有8个键，所以有6个是3个字母，有2个是4个字母。
        // 题目目的是，基于给出的字符串，如何映射，才能使按键次数最少。最终按键最少多少次？
        // 思路：统计 26 个字母的频次
        // 1，按频次降序排序
        // 2，依次分配到按键代价：前 8 个字母代价 1，接着 8 个字母代价 2，再 8 个字母代价 3，最后最多 2 个字母代价 4
        // 3，答案 = 频次 × 代价 求和

        int res = 0;
        int[] cost = {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4};

        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        Arrays.sort(count);
        
        for (int i = 25; i >= 0; i--) {
            if (count[i] == 0) {
                break;
            }
            res += count[i] * cost[25 - i];
        }

        return res;
    }

    public static void main(String[] args) {

        L3016_Minimum_Number_of_Pushes_to_Type_Word_II s = new L3016_Minimum_Number_of_Pushes_to_Type_Word_II();
        long sysDate1 = System.currentTimeMillis();

        String word = "aabbccddeeffgghhiiiiii";
        int res = s.minimumPushes(word);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}