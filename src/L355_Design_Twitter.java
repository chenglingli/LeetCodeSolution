import java.util.*;

public class L355_Design_Twitter {


    public static void main(String[] args) {

        L355_Design_Twitter s = new L355_Design_Twitter();
        long sysDate1 = System.currentTimeMillis();

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 3);
        // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));
        // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]

        // twitter.follow(2, 1);    // User 1 follows user 2.

        twitter.postTweet(1, 5);
        // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));
        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.


        // twitter.unfollow(2, 1);  // User 1 unfollows user 2.
        // System.out.println(twitter.getNewsFeed(2));
        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.

        System.out.println();

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

class Twitter {

    // 关注关系，key为用户id，value为关注id set
    Map<Integer, Set<Integer>> followMap;

    // 发帖关系，key为用户id，value为发帖id list
    Map<Integer, List<Integer>> tweetMap;

    // 帖子顺序，key为帖子id，value为帖子顺序
    Map<Integer, Integer> indexMap;

    int index;

    /*
    构造函数，初始化
     */
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        indexMap = new HashMap<>();
        index = 1;
    }

    /*
    发帖
     */
    public void postTweet(int userId, int tweetId) {

        indexMap.put(tweetId, index++);

        if (tweetMap.containsKey(userId)) {
            tweetMap.get(userId).add(tweetId);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(tweetId);
            tweetMap.put(userId, list);
        }
    }

    /*
    查询帖子
     */
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();

        // 添加自己的帖子
        if (tweetMap.containsKey(userId)) {
            res.addAll(tweetMap.get(userId));
        }
        // 添加关注者的帖子
        Set<Integer> followeeSet = followMap.get(userId);
        if (followeeSet != null) {
            for (Integer followeeID : followeeSet) {
                if (tweetMap.containsKey(followeeID)) {
                    res.addAll(tweetMap.get(followeeID));
                }
            }
        }

        // 排序
        Integer[] array = new Integer[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        Arrays.sort(array, (a, b) -> indexMap.get(b) - indexMap.get(a));
        res.clear();
        for(int i = 0; i < Math.min(10, array.length); i++) {
            res.add(array[i]);
        }

        // 返回结果
        return res;
    }

    /*
    前者follow后者
     */
    public void follow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followMap.put(followerId, set);
        }
    }

    /*
    前者unfollow后者
     */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/*
另一种解决思路
    存储关注关系，被关注关系，发帖关系，帖子顺序


 */
class Twitter2 {

    // 发帖关系，key为帖子id，value为发帖用户id
    HashMap<Integer, Integer> postedTweets = new HashMap<>();

    // 关注关系，follower.get(i)关注followee.get(i)
    List<Integer> follower = new ArrayList<>();
    List<Integer> followee = new ArrayList<>();

    // 所有帖子，顺次存储
    List<Integer> allTweets = new ArrayList<>();

    public Twitter2() {

    }

    public void postTweet(int userId, int tweetId) {
        //Since I have a unique tweetId, I can use it as key and the user that posted it as value
        postedTweets.put(tweetId, userId);
        allTweets.add(tweetId);
    }

    // 查询帖子
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();
        List<Integer> validFollowers = new ArrayList<>();

        // 寻找user id的关注者
        // followee.get(i) 存储了follower.get(i)关注的人
        for(int i = 0; i < follower.size(); i++){
            if(follower.get(i) == userId){
                validFollowers.add(followee.get(i));
            }
        }

        // 从后往前遍历所有帖子，找到userId和他的关注者的帖子
        int counter = 0;
        for(int i = allTweets.size() - 1; i >= 0; i--){

            int tweetPoster = postedTweets.get(allTweets.get(i));
            if(tweetPoster == userId || validFollowers.contains(tweetPoster)){
                if(counter < 10){
                    res.add(allTweets.get(i));
                    counter++;
                }
            }
        }

        // 返回结果
        return res;
    }

    public void follow(int followerId, int followeeId) {
        follower.add(followerId);
        followee.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        for(int i = 0; i < follower.size(); i++){
            if(follower.get(i) == followerId && followee.get(i) == followeeId){
                follower.remove(i);
                followee.remove(i);
            }
        }
    }
}