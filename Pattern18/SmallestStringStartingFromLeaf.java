public class SmallestStringStartingFromLeaf {

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
    String smallest="";
    public String smallestFromLeaf(TreeNode root) {

         helper(root, "");
         return smallest;

    }

    private void helper(TreeNode root, String currentString) {
        //base condition
        if(root==null)
        {
            return;
        }

        currentString= (char)(root.val+'a')+currentString;
        //when do we stop and check the smallest lexicographical currentString
        if(root.left==null && root.right==null)
        {
            if(smallest.isEmpty()|| smallest.compareTo(currentString)>0)
            {
                smallest=currentString;
            }

        }

        //hypothesis
        if(root.left!=null)
        {
            helper(root.left,currentString);
        }
        if(root.right!=null)
        {
            helper(root.right,currentString);
        }




    }
    //
}
