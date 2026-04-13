import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L371_Sum_of_Two_Integers {

    /*
    Given two integers a and b, return the sum of the two integers without using the operators + and -.

    Example 1:
    Input: a = 1, b = 2
    Output: 3

    Example 2:
    Input: a = 2, b = 3
    Output: 5


    Constraints:

    -1000 <= a, b <= 1000

    思路分析
    这种题目与其他的题目有较大的区别，对于普通的题目来说，即使大家没有巧妙的思路，那么使用最基础的暴力遍历方法可能也能解决问题(暂不考虑时间与空间复杂度限制),但对于此类题目来说主要是要大家找到分析问题的原理，从较为深的原理层次来解决题目要求。下面看下这一题的思路历程:
    首先计算两数之和，但是不能使用+和-运算符，同样的相关Math的函数等也不能使用，因为内部也是这两种运算符实现的。那么应该怎么计算呢？熟悉计算机数字运算原理的各位都知道，实际上在整数加减运算时，底层都是二进制的在进行运算再转换位10进制来得到结果的，那么我们也将对其二进制的数字进行操作，对于二进制的操作运算很显然我们要使用位运算符来帮助我们实现。好，现在题目已经转换成了：使用加法来得到两数之和->使用位运算符来得到两数之和。有了目标方向之后我们先来探究二进制下加法是如何运作的：
    例如，a = 2，b =3，二进制的加法过程如下：
    0 0 1 0 (2)
    0 0 1 1 (3)
    ----------
    0 1 0 1 (5)
    从最低位开始相加 0 + 1 = 1, 高一位: 1 + 1 大于2进制的最大数1，需要向高一位进1，并把当前位置为0,接着高一位 0 + 1(进位) = 1,易得 0101即位十进制为5。从上述加法的流程来看，我们不难发现在两数相加的时候只会有两种情况发生：

    不需要进位(0+0, 0+1, 1+0)
    不用进位的三种情况列举出来即为0+0=0,0+1=1,1+0=1,不难发现规则为两数相同结果为0，不同结果为1，对应了位运算中的异或预算(^)，用代码可以表示为a^b为不需要进位的结果。
    需要进位(1+1)
    接下来看需要进位的情况, 1 + 1结果应该为当前位为0,高一位进1,对于两数都为1才会出现的结果来说对应的位运算符不难发现是与(&)，但是区别是当前位的结果应该是0并且向高一位进1，所以用代码表示位 (a&b)<<1。

    两种情况我们都已经解决，但是如何把这二者联系在一起呢？空想当然想不出来的，我们同样从十进制的数字例子入手：
    a = 29, b = 78,只考虑不需要的进位的结果为：97, 只考虑进位的结果为:10，显然将二者相加即可得到结果,对与我们的二进制结果来说同样相加即可.用代码表示上述过程即为
    public static int getSum(int a, int b) {
        return getSum(a^b, (a&b)<<1);
    }

    对于该函数来说我们会发现，这个递归没有出口，很明显还要知道如何判断递归达到了出口呢，继续分析上面十进制的例子我们发现得到的97和10依然可以相加（a代表不需要进位的结果，b为进位结果）
    97
    10
    ----------
    7 = a
    100 = b
    ----------
    107 = a
    0 = b
    ，此时可以发现107即是我们想要的结果，此刻进位的结果为0，不难得到，当进位的结果为0 时候，数字都已经加到不需要进位的结果，此刻a即为结果，也就是函数递归的出口，那么最后的代码也就完成了。

    最终代码：
    public static int getSum(int a, int b) {
	    return b==0?a:getSum(a^b, (a&b)<<1);
    }

     */
    public int getSum(int a, int b) {
        while (b != 0) {
            // 计算进位：a和b同时为1的位置产生进位
            int carry = a & b;

            // 异或计算不含进位的和
            a = a ^ b;

            // 将进位左移一位，移到下一位
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {

        L371_Sum_of_Two_Integers s = new L371_Sum_of_Two_Integers();

        long sysDate1 = System.currentTimeMillis();

        int a = 1;
        int b = 2;

        int res = s.getSum(a, b);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}