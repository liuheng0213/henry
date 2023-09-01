package basic.knowledge.henry.algorithm.InterviewExperience.tiktok;

import basic.knowledge.henry.algorithm.InterviewExperience.TreeNode;

public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(s == null && t == null){
            return true;
        }
        if(s != null && t == null){
            return false;
        }
        if(s == null && t != null){
            return false;
        }
        if(isSame(s,t)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    private boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s != null && t == null){
            return false;
        }
        if(s == null && t != null){
            return false;
        }
        if(s.value != t.value){
            return false;
        }

        return isSame(s.left,t.left) && isSame(s.right,t.right);
    }
}
