class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
 
public class Solution {

    public static TreeNode insertNode(TreeNode root, TreeNode node) {
    	if(root==null)
    		return node;
    	if(node.val==root.val)
    		return root;
    	else if(node.val>root.val)
    		root.right = insertNode(root.right,node);
    	else if(node.val<root.val)
    		root.left = insertNode(root.left,node);
    	return root;
    }

    public static void insertNode(TreeNode root,TreeNode node){
      if(root==null)
        return;
      if(node.val==root.val)
        return;
      if(node.val>root.val){
        if(root.right==null)
          root.right = node;
        else insertNode(root.right,node);
      }else if(node.val<root.val){
        if(root.left==null)
          root.left = node;
        else insertNode(root.left,node);
      }
    }
    
    public static void main(String []args){
    	TreeNode node = new TreeNode(1);
    	TreeNode node1 = new TreeNode(2);
    	node1.left = node;
    	TreeNode node2 = new TreeNode(3);
    	System.out.println(insertNode(node1,node2).right.val);
    }

	
}
