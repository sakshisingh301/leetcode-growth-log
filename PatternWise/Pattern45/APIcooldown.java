//package Pattern45;
//
////we process millions of API requests through a gateway service.
////
////To prevent abuse and reduce backend load, the gateway enforces a cooldown policy:
////
////After processing a request for a particular API endpoint, the same endpoint cannot be processed again for the next cooldown seconds.
////
////Requests arrive in a fixed order and cannot be reordered.
////
////Every second:
////
////the gateway may process the next request
////or remain idle if the next request violates cooldown rules
////
////Return the minimum number of seconds required to process all requests.
//
//public class APIcooldown {
//
//    public long minimumProcessingTime(int[] requests, int cooldown)
//    {
//
//    }
//}
