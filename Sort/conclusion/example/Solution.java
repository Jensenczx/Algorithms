/*
1.求一个数组中的第k个小的元素，我们可以先对其进行一个排列，然后根据索引来获得，或者是通过我们的切分的方式，对于数组中的
元素，我们对其进行切分，每次切分后对于返回的数据进行一个判断，得到结果之后，做判断。如果先排序的话，我们的复杂度是要比这个
复杂度要高的，还可以将其应用于对于我们要求一个小的排序空间的计算。

2.对于两个数组中，其中的元素出现的先后次序的问题，通过一个距离来表示，实际的应用在搜索引擎中，对于给定的结果，我们做一个关键字
筛选，然后将关键字作为一个数组中的每一个位置的元素，然后和我们的目的文章的关键字的序列数组进行一个比对，距离最近的即为我们
要找的文章。此处实现的方式其复杂度比较高，达到O(n2),检测其和准确位置的偏离程度，最后求和之后再除以2得到我们所要得到的序列。
*/
public class Solution{

	public static int calKendallTueDis(int[] array, int[] criterion){
		if(array==null||criterion==null)
			return -1;
		int distance = 0;
		for(int i=0;i<array.length;i++){
			for(int j=0; j<criterion.length;j++){
				if(array[i]==criterion[j])
					distance += Math.abs(j-i);
			}
		}
		return distance/2;
	}

	public static int getKthMinNumber(int []array,int k){
		int high = array.length-1;
		int low = 0;
		int desIndex = k-1;
		while(low<=high){
			int j = partition(array,low,high);
			if(j==desIndex) return array[j];
			else if(j<desIndex) low = j+1;
			else if(j>desIndex) high = j-1; 
		}
		return -1;
	}

	public static int partition(int []array,int low,int high){
		int i=low,j=high+1;
		int tmp = array[low];
		while(true){
			while(array[++i]<=tmp)
				if(i==high)
					break;
			while(array[--j]>=tmp)
				if(j==low)
					break;
			if(i>=j)
				break;
			exch(array,i,j);
		}
		exch(array,low,j);
		return j;
	}

	public static void exch(int []array,int first, int second){
		int tmp = array[first];
		array[first] = array[second];
		array[second] = tmp;
	}

	public static void main(String[] args){
		int []array = {1,3,5,4,2};
		int []criterion = {1,3,4,2,5};
		System.out.println(calKendallTueDis(array,criterion));
	}
}