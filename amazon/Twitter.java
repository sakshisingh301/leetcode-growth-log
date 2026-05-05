import java.util.*;

class Twitter {
    int timeStamps=0;

    class Tweets{
        int tweetId;
        int timestamps;
        Tweets(int tweetId,int timestamps)
        {
            this.timestamps=timestamps;
            this.tweetId=tweetId;
        }



    }
   //users and their followers map
    HashMap<Integer,Set<Integer>> followMap;

    //users and their tweets
    HashMap<Integer, List<Tweets>> tweetMaps;



    public Twitter() {
        followMap=new HashMap<>();
        tweetMaps=new HashMap<>();


    }

    public void postTweet(int userId, int tweetId) {
        //add tweet to the data structure

        tweetMaps.putIfAbsent(userId, new ArrayList<>());
        tweetMaps.get(userId).add(new Tweets(tweetId,timeStamps++));


    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result=new ArrayList<>();

        PriorityQueue<Tweets> max_heap=new PriorityQueue<>((a,b)->b.timestamps-a.timestamps);
        //get the followers for userId
        Set<Integer> followers=followMap.get(userId);
        //get the tweet for each userId and put it in the priority queue
        if(!followers.isEmpty())
        {
        for(int follower: followers)
        {
            //get the the tweet for each user
            List<Tweets> tweetsPerUser=tweetMaps.get(follower);
            if(!tweetsPerUser.isEmpty()) {
                //add it to the priority queue
                for (Tweets tweet : tweetsPerUser) {
                    max_heap.add(tweet);

                }


            }
        }
        }

        while(!max_heap.isEmpty() &&result.size()<10)
        {
            result.add(max_heap.remove().tweetId);

        }


        return result;
    }

    public void follow(int followerId, int followeeId) {
       followMap.putIfAbsent(followerId,new HashSet<>());
       followMap.get(followerId).add(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {

        if(followMap.containsKey(followerId))
        {
            followMap.get(followerId).remove(followeeId);
        }

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */