import java.util.HashMap;

public class L2325_Decode_the_Message {

    /*
    26 <= key.length <= 2000
    key consists of lowercase English letters and ' '.
    key contains every letter in the English alphabet ('a' to 'z') at least once.
    1 <= message.length <= 2000
    message consists of lowercase English letters and ' '.
     */
    public String decodeMessage(String key, String message) {

        HashMap<Character, Character> dict = new HashMap<>();

        char[] keyArray = key.toCharArray();
        char cur = 0;
        for (char c : keyArray) {
            if (c != ' ' && !dict.containsKey(c)) {
                dict.put(c, (char) ('a' + cur));
                cur++;
            }
        }

        StringBuilder res = new StringBuilder();
        char[] messageArray = message.toCharArray();
        for (char c : messageArray) {
            if (c != ' ') {
                res.append(dict.get(c));
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }

    public String decodeMessage2(String key, String message) {

        byte[] map = new byte[123];
        map[' '] = ' ';
        byte cur = 'a';

        byte[] keyBytes = key.getBytes();
        for (byte keyByte : keyBytes) {
            char c = (char) keyByte;
            if (map[c] == 0) {
                map[c] = cur;
                cur++;
            }
        }

        byte[] msgBytes = message.getBytes();
        byte[] output = new byte[message.length()];
        for (int i = 0; i < msgBytes.length; i++) {
            output[i] = (map[msgBytes[i]]);
        }

        return new String(output);
    }

    public static void main(String[] args) {

        L2325_Decode_the_Message s =
                new L2325_Decode_the_Message();
        long sysDate1 = System.currentTimeMillis();

        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String res = s.decodeMessage(key, message);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}