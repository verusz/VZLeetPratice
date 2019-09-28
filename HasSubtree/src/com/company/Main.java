package com.company;




public class Main {
//      Definition for a binary tree node.




    public static void main(String[] args) {
	// write your code here


        Main m = new Main();

        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);

        TreeNode t = new TreeNode(1);

//        m.isSubtree(s, t, false);
        System.out.println(m.isSubtree(s, t));
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
    return helper(s, t, false);

    }

    public boolean helper(TreeNode s, TreeNode t, boolean result) {
        if (s == null) {
            return result;
        }

        if (result == true) {
            return true;
        }

        if (s.val == t.val) {
            result = isSameTree(s, t);
        }

        result = helper(s.left, t, result) || helper(s.right, t, result);

        return result;
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (
                (p == null && q != null) ||
                        (p != null && q == null) ||
                        p.val != q.val ||
                        !isSameTree(p.left, q.left) ||
                        !isSameTree(p.right, q.right)) {
            return false;
        } else {
            return true;
        }
    }
}
