public class SumRoottoLeafNumbers {

    class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //followed the same logic as smallest String starting from leaf question
    int sum=0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int currentNumber) {
        //iterate through the tree and get keep appending in current number and lastly update sum too
        if(root==null)
        {
            return;
        }
        //did mistake here
        currentNumber = currentNumber * 10 + root.val;
        //When we reach to the leaf, we take the number and add it to the sum ex- in case 1, we reach to 2 and
        //current number becomes 12 and now the sum will be 12
        if(root.left==null && root.right==null)
        {
            sum=sum+currentNumber;
        }
        helper(root.left, currentNumber);
        helper(root.right,currentNumber);

    }
}
