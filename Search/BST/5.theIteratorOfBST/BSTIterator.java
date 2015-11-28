import java.util.ArrayList;

class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
 }
 
public class BSTIterator {

    private int position;
    private ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    public BSTIterator(TreeNode root) {
        // write your code here
        traversalBST(root);
    }

    public void traversalBST(TreeNode root){
        if(root!=null){
            if(root.left!=null)
                traversalBST(root.left);
            list.add(root);
            if(root.right!=null)
                traversalBST(root.right);
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write youdr code here
        if(list.size()==0||position==list.size())
            return false;
        return true;
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        if(list.size()>0&&position<list.size()){
            position++;
            return list.get(position-1);
        }
        return null;
    }

    public static void main(String[]args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node2.left=node1;
        BSTIterator iterator = new BSTIterator(node2);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next().val);
        System.out.println(iterator.next().val);

    }
}
