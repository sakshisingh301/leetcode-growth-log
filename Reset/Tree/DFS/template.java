//package Tree.DFS;
//
//public class template {
//    class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        public TreeNode() {
//        }
//
//        public TreeNode(int val) {
//            this.val = val;
//        }
//
//        public TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//
//        }
//
//
//        int answer = 0;
//
//        public int solve(TreeNode root) {
//            if (root == null) {
//                return 0;
//            }
//
//            dfs(root);
//
//            return answer;
//        }
//
//        private void dfs(TreeNode node) {
//            // Base case
//            if (node == null) {
//                return;
//            }
//
//            // 1. Process current node
//            // Do your work here
//
//            // 2. Go left
//            dfs(node.left);
//
//            // 3. Go right
//            dfs(node.right);
//        }
//
//        int answer = 0;
//
//        public int solve(TreeNode root) {
//
//            if (root == null) {
//                return 0;
//            }
//
//            dfs(root, initialValue);
//
//            return answer;
//        }
//
//        private void dfs(TreeNode node, int state) {
//
//            if (node == null) {
//                return;
//            }
//
//            // Process current node using state
//
//            // Update state
//            int newState = ...;
//
//            dfs(node.left, newState);
//            dfs(node.right, newState);
//        }
//    }
//}
//
//
