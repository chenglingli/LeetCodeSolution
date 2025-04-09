

/*

    You have a RecentCounter class which counts the number of recent requests within a certain time frame.

    Implement the RecentCounter class:

    RecentCounter() Initializes the counter with zero recent requests.
    int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
    and returns the number of requests that has happened in the past 3000 milliseconds (including the new request).

    Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
    It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.



    Example 1:

    Input
    ["RecentCounter", "ping", "ping", "ping", "ping"]
    [[], [1], [100], [3001], [3002]]
    Output
    [null, 1, 2, 3, 3]

    Explanation
    RecentCounter recentCounter = new RecentCounter();
    recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
    recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
    recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
    recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3


    Constraints:

    1 <= t <= 10^9
    Each test case will call ping with strictly increasing values of t.
    At most 10^4 calls will be made to ping.

     */
class RecentCounter {

    private static final int[] records = new int[10000]; //
    private int start;
    private int end;

    public RecentCounter() {
        start = 0;
        end = 0;
    }

    /*
    records 记录每一次ping的时间戳
    start 记录当前窗口的开始时间
    end 记录当前窗口的结束时间

    end - start 就是当前窗口的大小

    每次调用ping时，先判断当前时间cur和开始时间start是否已经超过了3000ms，
    如果不是，则只需要，记录请求记录到record中，并且将end往后移动
    如果是，则将start往后移动，直到当前窗口的时间跨度 = 3000ms

    最后返回窗口大小即可。

    举例，
    1. 第一次调用ping(1)
    start = 0, end = 1，records = [1]

    2. 第二次调用ping(100)
    start = 0, end = 2, records = [1, 100]

    3. 第三次调用ping(3001)
    start = 0, end = 3, records = [1, 100, 3001]

    4, 第四次调用ping(3002)
    start = 1, end = 4, records = [1, 100, 3001, 3002]

     */
    public int ping(int t) {

        int cur = t;

        // 如果当前时间和开始时间差大于3000ms，则移动开始时间直到小于等于3000ms
        while (start < end && (cur - records[start] > 3000)) {
            start++;
        }

        // 插入当前时间戳到数组中
        records[end] = cur; // Inserting the current time at the end

        // 移动时间窗口的结束位置
        end ++;

        // 返回当前窗口的大小，包括刚刚插入的元素
        return end - start; // Returning the answer including the element added just now.
    }
}

public class L933_Number_of_Recent_Calls {




    public static void main(String[] args) {

        L933_Number_of_Recent_Calls s = new L933_Number_of_Recent_Calls();
        long sysDate1 = System.currentTimeMillis();

        RecentCounter recentCounter1 = new RecentCounter();

        int res = recentCounter1.ping(1);
        System.out.println(res);
        res = recentCounter1.ping(300);
        System.out.println(res);
        res = recentCounter1.ping(3001);
        System.out.println(res);
        res = recentCounter1.ping(3002);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}