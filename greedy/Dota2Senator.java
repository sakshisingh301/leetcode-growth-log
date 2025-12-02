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
    //with one queue
    public static String predictPartyVictory1(String senate) {

        int r_count=0;
        int d_count=0;
        int r_floating=0;
        int d_floating=0;

        Queue<Character> queue=new LinkedList<>();

        for(int i=0;i<senate.length();i++)
        {
            queue.add(senate.charAt(i));
            if(senate.charAt(i)=='R')
            {
                r_count++;

            }
            else {
                d_count++;
            }
        }

        while(r_count>0 && d_count>0)
        {
            char curr= queue.poll();
            //check eligibilty to ban
            if(curr=='R')
            {
                if(r_floating>0)
                {
                    r_count--;
                    r_floating--;
                }
                else {
                    queue.add('R');
                    d_floating++;

                }
            }
            else {
                if(d_floating>0)
                {
                    d_count--;
                    d_floating--;

                }
                else {
                    queue.add('D');
                    r_floating++;
                }
            }

        }
        return r_count>0?"Radiant":"Dire";

    }



    public static void main(String[] args) {
      String senate = "RRDDD";
      System.out.println(predictPartyVictory1(senate));

    }
}
