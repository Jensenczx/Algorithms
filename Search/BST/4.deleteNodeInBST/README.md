###删除查找二叉树中的节点

在解决这个问题的时候，首先要知道的是当我们删除了一个节点之后，如何将该节点替换上，代替它的数据是在右子树的一个最左结点，然后将其替换之后，一些细节问题是我们在返回最小节点之后，我们会忽略掉一个特殊情况，如果返回的是我们根节点的右子树，那么可能会将其做为根节点的时候，还会将其作为根节点的右子树进行另一次的连接，为了解决这个问题，我们需要在得到子结点之后，做一个判断。