class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
 
public class Solution {
   
    public static TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if(root==null)
        	return root;
        if(value >root.val)
        	root.right=removeNode(root.right,value);
        else if(value<root.val)
        	root.left=removeNode(root.left,value);
        else if(value==root.val){
        	if(root.right==null&&root.left==null)
        		return null;
        	if(root.right==null&&root.left!=null)
        		return root.left;
        	if(root.left==null&&root.right!=null)
        		return root.right;
        	if(root.left!=null&&root.right!=null){
        		TreeNode tmpNode = nextMinNode(root.right);
        		if(tmpNode==root.right)
        			tmpNode.right=null;
        		else
        			tmpNode.right = root.right;
        		tmpNode.left = root.left;
        		return tmpNode;
        	}
        }
        return root;
    }

    public static TreeNode nextMinNode(TreeNode root){
    	TreeNode tmpNode;
    	while(root.left!=null){
    		tmpNode = root.left;
    		if(tmpNode.left==null){
    			root.left=null;
    			return tmpNode;
    		}
    	}
    	return root;
    }

    public static void main(String[] args){
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node4 = new TreeNode(4);
    	node1.right = node2;
    	node2.right = node3;
    	node3.right = node4;
    	System.out.println(removeNode(node1,2).right.val);
 } 

}