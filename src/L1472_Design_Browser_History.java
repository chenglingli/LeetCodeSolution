import java.util.Arrays;


class BrowserHistory {

    String[] history;
    int current;
    int size;

    public BrowserHistory(String homepage) {
        history = new String[101];
        history[0] = homepage;
        current = 0;
        size = 1;
    }

    public void visit(String url) {

        history[++current] = url;
        size = current + 1;
    }

    public String back(int steps) {
        int s = Math.min(current, steps);
        current -= s;
        return history[current];
    }

    public String forward(int steps) {
        int s = Math.min(size - current - 1, steps);
        current += s;
        return history[current];
    }
}

public class L1472_Design_Browser_History {

    /*

    You have a browser of one tab where you start on the homepage and you can visit another url,
        get back in the history number of steps or move forward in the history number of steps.

    Implement the BrowserHistory class:

    BrowserHistory(string homepage) Initializes the object with the homepage of the browser.

    void visit(string url) Visits url from the current page. It clears up all the forward history.

    string back(int steps) Move steps back in history.
        If you can only return x steps in the history and steps > x, you will return only x steps.
        Return the current url after moving back in history at most steps.

    string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x,
        you will forward only x steps. Return the current url after forwarding in history at most steps.


    Example:

    Input:
    ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
    [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
    Output:
    [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

    Explanation:
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
    browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
    browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
    browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
    browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
    browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
    browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
    browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
    browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
    browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
    browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"


    Constraints:

    1 <= homepage.length <= 20
    1 <= url.length <= 20
    1 <= steps <= 100
    homepage and url consist of  '.' or lower case English letters.
    At most 5000 calls will be made to visit, back, and forward.

     */


    public static void main(String[] args) {

        long sysDate1 = System.currentTimeMillis();
        String homepage = "leetcode.com";
        BrowserHistory browserHistory = new BrowserHistory(homepage);
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");

        String[] res = new String[6];
        res[0] = browserHistory.back(1);
        res[1] = browserHistory.back(1);
        res[2] = browserHistory.forward(1);
        browserHistory.visit("linkedin.com");
        res[3] = browserHistory.forward(2);
        res[4] = browserHistory.back(2);
        res[5] = browserHistory.back(7);

        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}