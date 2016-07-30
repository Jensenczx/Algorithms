public class Solution{
	static int [] transformArray;

	public static void mergeSortTop2Bottom(int []array,int low,int high){
		if(high<=low)
			return;
		int mid = low+(high-low)/2;
		mergeSortTop2Bottom(array,low,mid);
		mergeSortTop2Bottom(array,mid+1,high);
		merge(array,low,mid,high);
	}

	public static void mergeSortTop2Bottom (int[] array, int low, int high){
		if (high <= low) 
			return;
		int mid = low + (high-low)/2;
		mergeSortTop2Bottom(array, low, mid);
		mergeSortTop2Bottom(array, mid+1, high);
		merge(array, low, mid, high);
	}

	public static void mergeSortBottom2Top(int []array,int low,int high){
		for(int size=1; size<high;size=2*size){
			for(int i=0;i<high-size; i+=2*size){
				merge(array,i,i+size-1,Math.min(i+2*size-1,high-1));
			}
		}
	}
	public static void merge(int []array,int low,int mid,int high){
		for(int i=low; i<=high; i++)
			transformArray[i]=array[i];
		int lowFlag = low;
		int midFlag = mid+1;
		for(int k=low; k<=high; k++){
			if(lowFlag>mid) 
				array[k] = transformArray[midFlag++];
			else if(midFlag>high)
				array[k] = transformArray[lowFlag++];
			else{
				if(transformArray[midFlag]<transformArray[lowFlag]){
					array[k]=transformArray[midFlag];
					midFlag++;
				}else{
					array[k]=transformArray[lowFlag];
					lowFlag++;
				}

			}
		}
	}

	public static void main (String[]args){
		int [] array = {2,3,2,1,8};
		transformArray = new int[array.length];
		mergeSortBottom2Top(array,0,array.length-1);
		for(int i: array){
			System.out.println(i);
		}
	}
}
/*
If we want to merge two subArray, we need a array help us to realize.
Otherwise ,we will not move the elements in array.Then we return the 
customary array.
mid is the begging of the second subarray.
*/

