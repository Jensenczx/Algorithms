###有序查找，无序查找

####有序查找

对于有序查找，通过一个平行数组来实现，一个数组来保存key，一个数组保存value，通过对于key进行排序，然后再去动态的更新value的值。

查找：O(lgn)  插入：O(2n)   

####无序查找

无序查找通过的是链表数据结构实现的，当我们要插入一个节点的时候，我们需要从开始结点，向尾结点进行一个比对，知道找到我们要查找的结点。

查找：O(n)  插入：O(n)

无序查找的插入效率要比有序查找的效率要高，但是对于查找的效率来说，在平行数组的基础上通过二分查找效率更高。