import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Ratelimiter {
    //we are defining the rate limiter for single user
    //per user rate limiting means put a request limit on userid

    //user request(userid, requestId, timestamps)-> rate limiter--> api server or send a 429 response the the user
    int maxRequestAllowed=3;
    int windowSize=10;
    HashMap<Integer, Deque<Long>> userRequests;

    Ratelimiter(int maxRequestAllowed, int windowSize)
    {
        this.maxRequestAllowed=maxRequestAllowed;
        this.windowSize=windowSize;
        this.userRequests=new HashMap<>();
    }

    //1,5,10,11--> (11-1)=10

    public boolean allowedRequest(int userId, long timeStamps)
    {
        //if userRequests exists for that user? then create an empty queue
        if(!userRequests.containsKey(userId))
        {
            userRequests.put(userId,new LinkedList<>());
        }
        //get the size for that particular user
        Deque<Long> requests= userRequests.get(userId);
       //remove expired requests
        while(!requests.isEmpty() && timeStamps-requests.peekFirst()>windowSize)
        {
            requests.removeFirst();
        }

        //when the request received is lessthan max window
        if(requests.size()<maxRequestAllowed)
        {
            requests.offerLast(timeStamps);
            return true;
        }
        return false;


    }

    public static void main(String[] args) {
        Ratelimiter ratelimiter=new Ratelimiter(3,10);
        System.out.println(ratelimiter.allowedRequest(1, 1));   // true
        System.out.println(ratelimiter.allowedRequest(1, 2));   // true
        System.out.println(ratelimiter.allowedRequest(1, 4));   // true
        System.out.println(ratelimiter.allowedRequest(1, 5));
    }


}
