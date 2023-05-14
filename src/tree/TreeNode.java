package tree;

//
//public class TreeNode {
//
//    // Поиск пути по дереву с максимальной суммой от корня и до листа
//    int maxPathSumRL(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int maxLeftPath = maxPathSumRL(root.left);
//        int maxRightPath = maxPathSumRL(root.right);
//        return Math.max(maxLeftPath, maxRightPath) + root.val;
//    }
//
//    // Поиск пути по дереву с максимальной суммой
//    int answer = 0;
//    int maxPathSum(TreeNode root) {
//        helper(root);
//        return answer;
//    }
//    int helper(TreeNode root) {
//        if (root == null) {
//            return 0;}
//        int maxLeftPath = Math.max(helper(node.left), 0);
//        int maxRightPath = Math.max(helper(node.right), 0);
//        answer = Math.max(answer, maxLeftPath + maxRightPath + node.val);
//        return Math.max(maxLeftPath, maxRightPath) + node.val;
//    }
//}
