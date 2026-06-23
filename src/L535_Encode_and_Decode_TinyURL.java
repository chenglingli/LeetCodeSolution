import java.util.HashMap;
import java.util.Map;


/*

   Note: This is a companion problem to the System Design problem: Design TinyURL.
   TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and
   it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.

   There is no restriction on how your encode/decode algorithm should work. You just need to ensure that
   a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

   Implement the Solution class:

   Solution() Initializes the object of the system.
   String encode(String longUrl) Returns a tiny URL for the given longUrl.
   String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.


   Example 1:

   Input: url = "https://leetcode.com/problems/design-tinyurl"
   Output: "https://leetcode.com/problems/design-tinyurl"

   Explanation:
   Solution obj = new Solution();
   string tiny = obj.encode(url); // returns the encoded tiny url.
   string ans = obj.decode(tiny); // returns the original url after decoding it.


   Constraints:

   1 <= url.length <= 10^4
   url is guranteed to be a valid URL.

    */


class Codec2 {

    HashMap<String, String> map = new HashMap<>();
    int id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = String.valueOf(id);
        map.put(shortUrl, longUrl);
        id++;
        return shortUrl;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);

    }
}

class Codec {

    Map<String, String> codeDB = new HashMap<>(), urlDB = new HashMap<>();
    static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private String getCode() {
        char[] code = new char[6];
        for (int i = 0; i < 6; i++)
            code[i] = chars.charAt((int) (Math.random() * 62));
        return "http://tinyurl.com/" + String.valueOf(code);
    }

    public String encode(String longUrl) {
        if (urlDB.containsKey(longUrl))
            return urlDB.get(longUrl);

        String code = getCode();
        while (codeDB.containsKey(code))
            code = getCode();
        codeDB.put(code, longUrl);
        urlDB.put(longUrl, code);

        return code;
    }

    public String decode(String shortUrl) {
        return codeDB.get(shortUrl);
    }
}

public class L535_Encode_and_Decode_TinyURL {

    public static void main(String[] args) {

        Codec s = new Codec();
        long sysDate1 = System.currentTimeMillis();

        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String res = s.encode(longUrl);
        System.out.println(res);

        String ans = s.decode(res);
        System.out.println(ans);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}