###二叉查找树中插入结点

此处通过两种方式来实现的，其中第一种方式可以避免当我们的根节点为空结点的情况，同时代码也相比第二种方式更清晰。算法之美，再次就可以看出来了。

```
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
```

```
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
```
