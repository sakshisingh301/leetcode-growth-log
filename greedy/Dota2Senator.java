import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senator {

    public String predictPartyVictory(String senate) {

        Queue<Integer> r_queue=new LinkedList<>();
        Queue<Integer> d_queue=new LinkedList<>();

        for(int i=0;i<senate.length();i++)
        {
            if(senate.charAt(i)=='R')
            {
                r_queue.add(i);
            }
            else if(senate.charAt(i)=='D')
            {
                d_queue.add(i);

            }
        }

        while (!r_queue.isEmpty() && !d_queue.isEmpty())
        {
            int r_index= r_queue.poll();
            int d_index=d_queue.poll();
            if(r_index<d_index)
            {
                //R is dominating
                r_queue.add(r_index+senate.length());
            }
            else {
                d_queue.add(d_index+senate.length());
            }

        }

        return !r_queue.isEmpty() ? "Radiant": "Dire";

    }

    public static void main(String[] args) {
        //senate = "RRDDD"
    }
}
