public class L1079_Letter_Tile_Possibilities {

    /*
    You have n  tiles, where each tile has one letter tiles[i] printed on it.

    Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.



    Example 1:

    Input: tiles = "AAB"
    Output: 8
    Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

    Example 2:

    Input: tiles = "AAABBC"
    Output: 188

    Example 3:

    Input: tiles = "V"
    Output: 1

    Constraints:

    1 <= tiles.length <= 7
    tiles consists of uppercase English letters.
     */

    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        return permute(0, arr);
    }

    public int permute(int start, char[] arr) {
        if (start == arr.length)
            return 0;

        int ans = 0;
        for (int i = start; i < arr.length; i++) {
            if (!isPermutedBefore(start, i - 1, arr[i], arr)) {
                swap(start, i, arr);
                ans += 1 + permute(start + 1, arr);
                swap(start, i, arr);
            }
        }

        return ans;
    }

    public boolean isPermutedBefore(int i, int j, char ch, char[] arr) {
        while (i <= j) {
            if (arr[i++] == ch) {
                return true;
            }
        }

        return false;
    }

    public void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        L1079_Letter_Tile_Possibilities s = new L1079_Letter_Tile_Possibilities();

        long sysDate1 = System.currentTimeMillis();

        String text = "AAB";

        int res = s.numTilePossibilities(text);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}