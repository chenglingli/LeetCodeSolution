import java.util.ArrayList;
import java.util.List;

public class L068_Text_Justification {

    /*
    1 <= words.length <= 300
    1 <= words[i].length <= 20
    words[i] consists of only English letters and symbols.
    1 <= maxWidth <= 100
    words[i].length <= maxWidth
     */
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();

        List<String> temp = new ArrayList<>();
        int tempLen = 0;

        // 处理前n-1行
        for (String str : words) {
            if (tempLen + str.length() > maxWidth) {
                res.add(convertToString(temp, maxWidth, tempLen, false));
                temp.clear();
                tempLen = 0;
            }

            temp.add(str);
            tempLen += str.length();
            tempLen += 1;
        }

        // 最后一行处理
        if (tempLen > 0) {
            res.add(convertToString(temp, maxWidth, tempLen, true));
        }

        return res;
    }

    private String convertToString(List<String> temp, int maxWidth, int tempLen, boolean lastLine) {

        StringBuilder sb = new StringBuilder();

        // 总的空格数
        int space = maxWidth - tempLen + temp.size();

        // 一个单词的特殊处理
        if (temp.size() == 1) {
            sb.append(temp.get(0));
            for (int i = 0; i < space; i++) sb.append(" ");
            // System.out.println(sb + "END");
            return sb.toString();
        }

        // 最后一行处理
        if (lastLine) {
            for (int i = 0; i < temp.size(); i++) {
                sb.append(temp.get(i));
                if (i != temp.size() - 1) {
                    sb.append(" ");
                    space--;
                }
            }
            for (int i = 0; i < space; i++) sb.append(" ");
            // System.out.println(sb + "END");
            return sb.toString();
        }

        // 非最后一行处理
        int spaceLen = space / (temp.size() - 1); // 每个单词后
        int spaceRemain = space % (temp.size() - 1); // 前面多几个空格
        for (int i = 0; i < temp.size(); i++) {
            sb.append(temp.get(i));
            if (i != temp.size() - 1) {
                for (int j = 0; j < spaceLen; j++)
                    sb.append(" ");
                if (spaceRemain > 0) {
                    sb.append(" ");
                    spaceRemain--;
                }
            }
        }

        // System.out.println(sb + "END");
        return sb.toString();
    }

    public static void main(String[] args) {

        L068_Text_Justification s = new L068_Text_Justification();

        long sysDate1 = System.currentTimeMillis();

        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        List<String> res = s.fullJustify(words, maxWidth);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}