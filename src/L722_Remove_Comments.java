import java.util.ArrayList;
import java.util.List;

public class L722_Remove_Comments {

    /*
    Given a C++ program, remove comments from it. The program source is an array of string source
    where source[i] is the ith line of the source code. This represents the result of splitting the original source code string by the newline character '\n'.


    In C++, there are two types of comments, line comments, and block comments.

    */

    public List<String> removeComments(String[] source) {
        // 去除代码中的注释
        // 有两种注释 // 和 /* */
        // 第一个好处理，因为只在单行
        // 第二个稍微复杂，因为可以跨行，处理方式：用一个变量标记是否在注释中，如果是则在遇到 */ 时退出

        List<String> res = new ArrayList<>();

        boolean inBlockComment = false;
        StringBuilder sb = new StringBuilder();

        for (String line : source) {

            // 在非块注释状态下，清空StringBuilder
            if (!inBlockComment) {
                sb.setLength(0);
            }

            int i = 0;
            while (i < line.length()) {
                // 在非块注释状态下遇到单行注释，当前行后续全部忽略
                if (!inBlockComment && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
                }

                // 在非块注释状态下，遇到 /* 时，标记为在块注释中
                if (!inBlockComment) {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlockComment = true;
                        i += 2; // 跳过 /*
                        continue;
                    } else {
                        sb.append(line.charAt(i));
                        i++;
                    }
                    // 在块注释状态下，遇到 */ 时，标记为不在块注释中
                } else if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    inBlockComment = false;
                    i += 2; // 跳过 */
                } else {
                    i++;
                }
            }

            if (!inBlockComment && sb.length() > 0) {
                res.add(sb.toString());
            }
        }

        return res;
    }


    public List<String> removeComments2(String[] source) {
        // 标记当前是否处于块注释（/* ... */）中。
        // 初始为 false，因为还没有开始读取任何字符。
        boolean blockActive = false;


        List<String> result = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        // 逐行读取输入代码。

        for (String line : source) {
            // 每次进入新的一行，都先判断是否还在块注释中。
            // 如果仍在块注释中，说明要忽略换行带来的分隔，继续与后续行拼接。
            // 例如：
            // line1: "int a /*Block comment Started"
            // line2: "Block comment ends here */ b;"
            // line3: "int c;"
            // 结果应为 "int ab", "int c;"，而不是 "int a", "b;", "int c;"。
            if (!blockActive) {
                builder = new StringBuilder();
            }

            for (int i = 0; i < line.length(); i++) { // 逐字符扫描当前行
                char c = line.charAt(i);
                if (!blockActive) { // 当前不在块注释中

                    if (c == '/') { // 遇到 /，判断是 //、/* 还是普通字符

                        if (i < line.length() - 1 && line.charAt(i + 1) == '/') { // 单行注释
                            break; // 当前行后续内容全部忽略
                        } else if (i < line.length() - 1 && line.charAt(i + 1) == '*') { // 块注释开始
                            i++; // 跳过 *，避免重复读取
                            blockActive = true;
                        } else { // / 后不是 / 或 *，说明 / 是正常代码字符
                            builder.append(c);
                        }
                    } else { // 其余字符直接加入结果
                        builder.append(c);
                    }
                } else {
                    // 在块注释中时，忽略所有字符，仅查找块注释结束标记 */
                    if (c == '*') {
                        if (i < line.length() - 1 && line.charAt(i + 1) == '/') {
                            blockActive = false;
                            i++;
                        }
                    }
                }
            }

            // 仅在不处于块注释中且当前行有有效代码时，加入结果集。
            if (!blockActive && builder.length() != 0) {
                result.add(builder.toString());
            }

        }

        return result;
    }

    public static void main(String[] args) {

        L722_Remove_Comments s = new L722_Remove_Comments();

        long sysDate1 = System.currentTimeMillis();

        //        String[] source = new String[11];
        //        source[0] = "/*Test program */";
        //        source[1] = "int main()";
        //        source[2] = "{ ";
        //        source[3] = "  // variable declaration ";
        //        source[4] = "  int a, b, c;";
        //        source[5] = "  /* This is a test";
        //        source[6] = "   multiline  ";
        //        source[7] = "   comment for ";
        //        source[8] = "   multiline comment test */";
        //        source[9] = "  a = b + c;";
        //        source[10] = "}";

        String[] source = new String[3];
        source[0] = "a/*comment";
        source[1] = "line";
        source[2] = "more_comment*/b";

        List<String> res = s.removeComments(source);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}