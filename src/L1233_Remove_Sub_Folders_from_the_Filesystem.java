import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class L1233_Remove_Sub_Folders_from_the_Filesystem {

    /*
    Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.

    If a folder[i] is located within another folder[j], it is called a sub-folder of it.
        A sub-folder of folder[j] must start with folder[j], followed by a "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".

    The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.

    For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.


    Example 1:
    Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
    Output: ["/a","/c/d","/c/f"]
    Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.

    Example 2:
    Input: folder = ["/a","/a/b/c","/a/b/d"]
    Output: ["/a"]
    Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".

    Example 3:
    Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
    Output: ["/a/b/c","/a/b/ca","/a/b/d"]

    Constraints:
    1 <= folder.length <= 4 * 10^4
    2 <= folder[i].length <= 100
    folder[i] contains only lowercase letters and '/'.
    folder[i] always starts with the character '/'.
    Each folder name is unique.
     */
    public List<String> removeSubfolders(String[] folder) {
        /*
        题意：
        给定一组文件夹路径，需要去掉所有的子文件夹
        判断一个文件夹是子文件夹，只需要判断路径是否包含在另外一个文件夹的路径中即可

        解法：
        1. 先对文件夹路径进行排序
        2. 然后遍历文件夹路径，判断当前文件夹是否包含在之前的某个文件夹的路径中
        3. 如果包含，则去掉当前文件夹
        4. 如果不包含，则保留当前文件夹

         */

        List<String> res = new ArrayList<>();

        Arrays.sort(folder);
        for (int i = 0; i < folder.length; i++) {
            if (i == 0 || !folder[i].startsWith(res.get(res.size() - 1) + "/")) {
                res.add(folder[i]);
            }
        }

        return res;
    }

    /*
    解法2：
    用一个set来存储所有的文件夹路径
    然后遍历文件夹路径，判断当前路径是否包含在之前的某个文件夹的路径中
        判断方式：取当前路径对应的前缀串，看是否存在于set中
    如果包含，则去掉当前文件夹
    如果不包含，则保留当前文件夹

     */
    public List<String> removeSubfolders2(String[] folder) {
        Set<String> set = Arrays.stream(folder).collect(Collectors.toSet());

        List<String> result = new ArrayList<>();

        for (String f : folder) {
            boolean isSub = false;
            String str = f;

            while (!str.isEmpty()) {
                int pos = str.lastIndexOf('/');
                str = str.substring(0, pos);
                if (set.contains(str)) {
                    isSub = true;
                    break;
                }
            }

            if (!isSub) {
                result.add(f);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        L1233_Remove_Sub_Folders_from_the_Filesystem s = new L1233_Remove_Sub_Folders_from_the_Filesystem();
        long sysDate1 = System.currentTimeMillis();

        String[] folder = new String[]{"/a", "/a/b/c", "/a/b/d"};
        List<String> res = s.removeSubfolders(folder);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}