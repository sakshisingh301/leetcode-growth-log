package Pattern12;

import java.util.HashMap;




public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder--> root--> left--> right
        //inorder--> left--> root-->right
        //to build tree we need the root first

        HashMap<Integer, Integer> inorderMap=new HashMap<>();
        if(inorder.length!=preorder.length) return null;

        for(int i=0;i<inorder.length;i++)
        {
            inorderMap.put(inorder[i],i);
        }

        return buildTreeRecursively(preorder, 0,preorder.length-1, inorder, 0, inorder.length-1, inorderMap);

    }

    private TreeNode buildTreeRecursively(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, HashMap<Integer, Integer> inorderMap) {
        if(preorderStart>preorderEnd || inorderStart>inorderEnd) return null;
        //find the root && build tree
        TreeNode root=new TreeNode(preorder[preorderStart]);
        int rootIndexInOrder=inorderMap.get(preorder[preorderStart]);
        int leftSubtreeFromInorder=rootIndexInOrder-inorderStart;
        root.left=buildTreeRecursively(preorder,preorderStart+1,preorderStart+leftSubtreeFromInorder,
                inorder, inorderStart,rootIndexInOrder-1,inorderMap);
        root.right=buildTreeRecursively(preorder,preorderStart+leftSubtreeFromInorder+1,preorderEnd,
                inorder,rootIndexInOrder+1,inorderEnd,inorderMap);
        return root;
    }

    //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //Output: [3,9,20,null,null,15,7]
}
