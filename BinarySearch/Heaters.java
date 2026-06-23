//import java.util.Arrays;
//
//public class Heaters {
//
//    public static int findRadius(int[] houses, int[] heaters) {
//        //for each house find the closest house at the left and right and take the minimum
//        //repeat the process for each house and take the max out of all
//        //question will be solved via binary search
//        //find inserted position
//        Arrays.sort(heaters);
//        int leftClosestHouse=Integer.MAX_VALUE;
//        int rightClosestHouse=Integer.MAX_VALUE;
//        //iterate through the house and find where would you insert it in heaters
//
//        for(int currHouse: houses)
//        {
//            int insertionPoint=findInsertedPosition(currHouse,heaters);
//            if(insertionPoint-1>=0)
//            {
//                leftClosestHouse=heaters[insertionPoint]
//
//            }
//
//
//
//        }
//
//
//
//    }
//
//    public static int findInsertedPosition(int house, int [] heaters)
//    {
//
//        int start=0;
//        int end=heaters.length-1;
//
//        while(start<=end)
//        {
//            int mid=(start+end)/2;
//
//            if(heaters[mid]==house)
//            {
//                return mid;
//            }
//            else if(heaters[mid]<house)
//            {
//                start=mid+1;
//            }
//            else if(heaters[mid]>house)
//            {
//                end=mid-1;
//            }
//        }
//        return start;
//
//    }
//}
//
////Input: houses = [1,2,3,4], heaters = [1,4]
////Output: 1
////Explanation: The two heaters were placed at positions 1 and 4. We need to use a radius 1 standard, then all the houses can be warmed.
