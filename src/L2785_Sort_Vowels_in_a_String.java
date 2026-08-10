import java.util.ArrayList;
import java.util.List;

public class L2785_Sort_Vowels_in_a_String {


    /*

    Given a 0-indexed string s, permute s to get a new string t such that:

    All consonants remain in their original places.

    More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
    The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels,
    then t[i] must not have a higher ASCII value than t[j].
    Return the resulting string.

    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.



    Example 1:

    Input: s = "lEetcOde"
    Output: "lEOtcede"
    Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants.
    The vowels are sorted according to their ASCII values, and the consonants remain in the same places.

    Example 2:
    Input: s = "lYmpH"
    Output: "lYmpH"
    Explanation: There are no vowels in s (all characters in s are consonants), so we return "lYmpH".


    Constraints:

    1 <= s.length <= 105
    s consists only of letters of the English alphabet in uppercase and lowercase.

     */
    public String sortVowels(String s) {
        // 给元音字母排序，辅音字母保持在原来位置
        List<Character> vowels = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        vowels.sort(null);

        StringBuilder sb = new StringBuilder();
        int vowelIndex = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append(vowels.get(vowelIndex++));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public String sortVowels2(String s) {

        /*
        charMap 表示元音字符集
        countIndexMap 表示某个字符是否是元音，=0就是辅音，>0 就是元音
        vowelCount 表示 charMap 中每个元音出现的次数
        result 表示最终的字符串，辅音不动，元音按序填回

        遍历result中每个字符，如果是元音，就从 vowelCount 中取出对应字符填入；
        譬如当前取到的字符为c（假设为'A'），是元音。
        则在 vowelCount 中，取出对应桶（譬如 1 号桶）中的一个字符填入。
         */


        // charMap: 按 ASCII 升序排列的全部元音，下标 0..9 对应 A..u
        char[] charMap = "AEIOUaeiou".toCharArray();

        // countIndexMap: ASCII 字符 -> 元音桶号；0 表示非元音，1..10 对应 charMap[0..9]
        int[] countIndexMap = new int[128];
        
        // vowelCount: 每种元音的出现次数；下标 0 不用，1..10 对应 charMap
        int[] vowelCount = new int[11];
        
        // result: 原地改写，辅音不动，元音位按序填回
        char[] result = s.toCharArray();

        // 建立「字符 -> 桶号」映射，例如 'A'->1, 'E'->2, ..., 'u'->10
        for (int i = 0; i < charMap.length; i++)
            countIndexMap[charMap[i]] = i + 1;

        // 统计各元音出现次数；非元音 countIndexMap[c]==0，会累加到 vowelCount[0]（忽略）
        for (char c : result)
            vowelCount[countIndexMap[c]]++;

        // j: 当前要放出的元音桶（1..10，从小到大）
        // i: result 中下一个待填的元音位置
        int j = 1;
        int i = 0;

        while (j < vowelCount.length) {
            if (vowelCount[j] > 0)
                // 桶 j 还有剩余：找到下一个元音位，填入 charMap[j-1]
                while (i < result.length) {
                    if (countIndexMap[result[i]] == 0) {
                        i++; // 辅音，跳过
                        continue;
                    }
                    vowelCount[j]--;
                    result[i++] = charMap[j - 1];
                    break;
                }
            else
                j++; // 当前桶用完，换下一个更大的元音
        }

        return new String(result);
    }

    public static void main(String[] args) {

        L2785_Sort_Vowels_in_a_String s = new L2785_Sort_Vowels_in_a_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "lEetcOde";
        String res = s.sortVowels(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}