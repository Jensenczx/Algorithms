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
    
    public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root!=null)
        	queryBST(list,root);
        System.out.println(list);
        for(int i=0; i<list.size(); i++){
        	if(list.get(i)<k1||list.get(i)>k2){
        		list.remove(i);
        		i--;
        	}
        }
        return list;
    }

	public static void queryBST(ArrayList<Integer> list,TreeNode node){
		if(node.left==null&&node.right==null)
			list.add(node.val);
		else{
			if(node.left!=null)
				queryBST(list,node.left);
		    list.add(node.val);
		    if(node.right!=null)
		    	queryBST(list,node.right);
       }
	}
	public static void main(String []args){
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node3.right = node4;
		System.out.println(searchRange(node1,2,2));
	}
}