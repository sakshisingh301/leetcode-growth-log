public class MergeTripletstoFormTargetTriplet {

    public static boolean mergeTriplets(int[][] triplets, int[] target) {

        //skip bad triplets(If any number(x,y,z) is greater than the target then those one will be the bad triplets
        boolean x_found=false;
        boolean y_found=false;
        boolean z_found=false;

        for(int [] curr: triplets)
        {
            int x=curr[0];
            int y= curr[1];
            int z=curr[2];
            if(x>target[0] || y>target[1] || z> target[2])
            {
                continue;
            }
            if(x==target[0]) x_found=true;
            if(y==target[1]) y_found=true;
            if(z==target[2]) z_found=true;

        }
        return x_found &&y_found &&z_found;

    }

    public static void main(String[] args) {
       int [] [] triplets= {{2,5,3},{1,8,4},{1,7,5}};
       int [] target={2,7,5};
       System.out.println(mergeTriplets(triplets,target));

    }
}
