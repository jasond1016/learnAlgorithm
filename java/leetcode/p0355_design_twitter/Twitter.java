package leetcode.p0355_design_twitter;

import java.util.*;

public class Twitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); // 5
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1)); // 6 5
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // 5
    }

    // 全局时间戳，递增
    private static int timestamp = 0;

    private static class User {
        private int id;
        // 关注用户，自动关注自己，去重
        private Set<Integer> followed;
        // 用户发布的 tweets
        private Tweet head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            head = null;
            // 关注自己
            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            // 不能取关自己
            if (userId != id) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }

    }

    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    // 用户 ID 和用户对象的关联
    private HashMap<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            // 如果用户不存在则创建
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    // 利用 Priority Queue 对多个有序链表排序
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }

        Set<Integer> followed = userMap.get(userId).followed;
        // 按时间降序排列，最顶部的是最近的 tweet
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int followedUser : followed) {
            Tweet tweet = userMap.get(followedUser).head;
            if (tweet == null) {
                continue;
            }
            pq.add(tweet);
        }

        while (!pq.isEmpty()) {
            // 只取最近 10 条
            if (res.size() == 10) {
                break;
            }
            // 最近发表的 tweet
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            if (tweet.next != null) {
                // 想下一条 tweet 排序
                pq.add(tweet.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }

        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}
