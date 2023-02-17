import java.util.Objects;

public class L1592_Rearrange_Spaces_Between_Words {


    public String reorderSpaces(String text) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();

        int textLen = text.length();

        int totalWordLen = 0;
        int wordCount = 0;
        for (String w : words) {
            if (!Objects.equals(w, "")) {
                totalWordLen += w.length();
                wordCount++;
            }
        }

        int totalSpaceLen = textLen - totalWordLen;
        if (totalSpaceLen == 0) {
            return text;
        }

        int singleSpaceLen = wordCount != 1 ? (totalSpaceLen / (wordCount - 1)) : totalSpaceLen;
        int remainSpaceLen = wordCount != 1 ? totalSpaceLen - (wordCount - 1) * singleSpaceLen : totalSpaceLen;
        StringBuilder spaceBuild = new StringBuilder();
        for (int i = 0; i < singleSpaceLen; i++) {
            spaceBuild.append(" ");
        }
        StringBuilder spaceRemain = new StringBuilder();
        for (int i = 0; i < remainSpaceLen; i++) {
            spaceRemain.append(" ");
        }

        boolean first = true;
        for (String w : words) {
            if (!Objects.equals(w, "")) {
                if (first) {
                    sb.append(w);
                    first = false;
                } else {
                    sb.append(spaceBuild);
                    sb.append(w);
                }
            }
        }
        sb.append(spaceRemain);

        return sb.toString();
    }

    public String reorderSpaces2(String text) {
        int words = 0;
        int spaces = 0;
        boolean isWord = false;

        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == ' ') {
                ++spaces;
                if (isWord) ++words;
                isWord = false;
            } else isWord = true;
        }
        if (isWord) ++words;

        if (spaces == 0) return text;

        int space = words > 1 ? spaces / (words - 1) : spaces;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) != ' ') {
                while (i < text.length() && text.charAt(i) != ' ') {
                    sb.append(text.charAt(i++));
                }
                --words;
                if (words > 0) {
                    for (int j = 0; j < space; ++j) sb.append(' ');
                    spaces -= space;
                }
            }
        }

        while (spaces-- > 0) sb.append(' ');

        return sb.toString();
    }

    public static void main(String[] args) {

        L1592_Rearrange_Spaces_Between_Words s =
                new L1592_Rearrange_Spaces_Between_Words();
        long sysDate1 = System.currentTimeMillis();

        String text = " practice   ";
        String res = s.reorderSpaces(text);
        System.out.print(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("time ");
        System.out.print(sysDate2 - sysDate1);
    }
}