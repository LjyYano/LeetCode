/**
 * https://leetcode.cn/problems/design-twitter/
 * 
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，
 * 能够看见关注人（包括自己）的最近 10 条推文。
 * 
 * 实现 Twitter 类：
 * - Twitter() 初始化简易版推特对象
 * - void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。
 *   每次调用此函数都会使用一个不同的 tweetId 。
 * - List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近 10 条推文的 ID 。
 *   新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。
 *   推文必须 按照时间顺序由最近到最远排序 。
 * - void follow(int followerId, int followeeId) ID为 followerId 的用户开始关注 ID 为 followeeId 的用户。
 * - void unfollow(int followerId, int followeeId) ID为 followerId 的用户不再关注 ID 为 followeeId 的用户。
 */
import java.util.*;

public class L0355_DesignTwitter {
    
    private int timestamp;
    private Map<Integer, User> userMap;
    
    /** 推文类 */
    private class Tweet {
        int id;
        int time;
        Tweet next;
        
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    
    /** 用户类 */
    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;
        
        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // 关注自己
            tweetHead = null;
        }
        
        public void follow(int userId) {
            followed.add(userId);
        }
        
        public void unfollow(int userId) {
            followed.remove(userId);
        }
        
        public void post(int tweetId, int time) {
            Tweet tweet = new Tweet(tweetId, time);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }
    
    public L0355_DesignTwitter() {
        timestamp = 0;
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId, timestamp++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return result;
        }
        
        // 使用优先队列合并多个用户的推文列表
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        
        User user = userMap.get(userId);
        for (int followeeId : user.followed) {
            if (userMap.containsKey(followeeId)) {
                Tweet tweet = userMap.get(followeeId).tweetHead;
                if (tweet != null) {
                    pq.offer(tweet);
                }
            }
        }
        
        // 取出最近的 10 条推文
        while (!pq.isEmpty() && result.size() < 10) {
            Tweet tweet = pq.poll();
            result.add(tweet.id);
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
        }
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }

    public static void main(String[] args) {
        L0355_DesignTwitter twitter = new L0355_DesignTwitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); // [5]
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1)); // [6, 5]
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // [5]
    }
}
