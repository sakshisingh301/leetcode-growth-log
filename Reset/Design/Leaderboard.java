package Design;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;

public class Leaderboard {
    class Board
    {
        int playerId;
        int score;
        public Board(int playerId, int score)
        {
            this.playerId=playerId;
            this.score=score;
        }

    }

    //We will be using TreeSet in java where we store keys and value and
    // we can write a lambda function to sort it by values
    TreeSet<Board> treeSet;
    HashMap<Integer, Integer> map;


    public Leaderboard() {

        //sorting it by score decreasing order if the score differs else by playerId increasing order
        treeSet=new TreeSet<>((a,b)->
        {
            if(a.score!=b.score)
            {
                return Integer.compare(b.score,a.score);
            }
            else {
                return Integer.compare(a.playerId,b.playerId);
            }
        });
        map=new HashMap<>();

    }
    //nlogn
    public void addScore(int playerId, int score) {
      //if the player is not there then create entry in both hashmap and treeset
        if(!map.containsKey(playerId))
        {
            map.put(playerId,score);
            treeSet.add(new Board(playerId, score));
        }
        else {
            int currentScore=map.get(playerId);
            int newScore=currentScore+score;
            map.put(playerId, newScore);
            //remove the entry from treeset

            treeSet.remove(new Board(playerId,currentScore));
            //add a new entry in the treeset
            treeSet.add(new Board(playerId, newScore));
        }


    }
    //logk
    public int top(int K) {

        //iterate through the treeSet and sum up top k scores
        int sum=0;
        int count=0;

        for(Board player: treeSet)
        {
            //get player's score
            int score= player.score;
            count++;
            sum=sum+score;
            if(count==K)
            {
                break;
            }

        }
        return sum;

    }
    //logk
    public void reset(int playerId) {

        //remove from both the treeset and map
        int oldScore=map.get(playerId);
        map.remove(playerId);
        treeSet.remove(new Board(playerId, oldScore));

    }
}
