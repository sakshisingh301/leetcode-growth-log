package designQuestion;

import java.util.*;

public class Twitter {

    class Tweets{
        int tweetId;
        int timeStamps;
        public Tweets(int tweetId, int timeStamps)
        {
            this.tweetId=tweetId;
            this.timeStamps=timeStamps;

        }
    }

    int timestamp;
    HashMap<Integer, Set<Integer>> followMap;
    HashMap<Integer, List<Tweets>> tweets;

    public Twitter() {
        timestamp=0;
        followMap=new HashMap<>();
        tweets=new HashMap<>();

    }

    //Map to store users: all the users it follows

    public void postTweet(int userId, int tweetId) {
        //Hashmap to store the userId and tweetId && timestamp
        //{userId, Tweets(tweetId, timestamp)
        if(!tweets.containsKey(userId))
        {
            tweets.put(userId,new ArrayList<>());
        }
        tweets.get(userId).add(new Tweets(tweetId,timestamp));
        timestamp++;




    }

    public List<Integer> getNewsFeed(int userId) {
        //get tweet for the users and the followees and sort by timestamps (max_heap) and get top 10 tweetIds
        List<Integer> result=new ArrayList<>();


        Set<Integer> getfollowee=followMap.get(userId);
        PriorityQueue<Tweets> min_heap=new PriorityQueue<>((a,b)->a.timeStamps-b.timeStamps);
        //get all tweets and put it in priority queue
        Set<Integer> users=new HashSet<>();
        users.add(userId);

        if(getfollowee!=null)
        {
            users.addAll(getfollowee);
        }
        //go through the user set and add the tweets in max heap
        for(Integer user: users)
        {
           List<Tweets> tweetsList= tweets.get(user);
           if(tweetsList!=null) {
               for (Tweets tweet : tweetsList) {
                   if (tweet != null) {
                       min_heap.add(tweet);
                       if(min_heap.size()>10)
                       {
                           min_heap.poll();
                       }

                   }

               }
           }

        }


       while(!min_heap.isEmpty()  )
       {
           Tweets tweet1=min_heap.poll();
           result.add(tweet1.tweetId);

       }
        Collections.reverse(result);
       return result;



    }

    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId) && followerId!=followeeId)
        {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);


    }

    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId) && followerId!=followeeId)
        {
            followMap.get(followerId).remove(followeeId);
        }

    }
}
