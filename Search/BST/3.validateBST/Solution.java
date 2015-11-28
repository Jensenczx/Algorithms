import java.util.ArrayList;
class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
}
 
public class Solution {
    
    public static boolean isValidBST(TreeNode root) {
        // write your code here
        ArrayList<Integer>list = new ArrayList<Integer>();
        if(root==null)
        	return true;
        else searchBST(root,list);
        System.out.println(list);
        for(int i=0; i<list.size()-1; i++){
        	if(list.get(i+1)<=list.get(i))
        		return false;
        }
        return true;
    }

    public static void searchBST(TreeNode root,ArrayList<Integer>list){
    	if(root.left==null&&root.right==null)
    		list.add(root.val);
    	else{
    		if(root.left!=null)
    			searchBST(root.left,list);
    		list.add(root.val);
    		if(root.right!=null)
    			searchBST(root.right,list);
    	}

    }

	public static void main(String []args){
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		System.out.println(isValidBST(node1));
	}
}