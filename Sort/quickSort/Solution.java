public class Solution{
//If we use recurrence, we must set a event as the teminal condition.
	public static void quickSort(int[] array,int low,int high){
		if(high<=low)
			return;
		int mid = partition(array,low,high);
		quickSort(array,low,mid-1);
		quickSort(array,mid+1,high);
	}

	public static void quickThreeWaySort(int[] array,int low,int high){
		if(high<=low)
			return;
		int start = low, end = high, cursor=low+1;
		while(cursor<=end){
			int tmp = array[start];
			if(array[cursor]>tmp){
				exch(array,cursor,end--);
			}else if(array[cursor]<tmp){
				exch(array,cursor++,start++);
			}else{
				cursor++;
			}
		}
		quickThreeWaySort(array,low,start-1);
		quickThreeWaySort(array,end+1,high);

	}
//Get the partition of the array,we can use circulate to simulate the process of the moving of
	//the pointer,one is from the start to end ,another is from the end to the start.
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

	public static void main(String[]args){
		int[] array = {7,3,7,5,6,2};
		quickThreeWaySort(array,0,array.length-1);
		for(int i:array){
			System.out.println(i);
		}
	}


}