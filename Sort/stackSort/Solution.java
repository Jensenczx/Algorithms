public class Solution{

	public static void stackSort(int[] array){
		int length = array.length;
		int [] newArray = new int [length+1];
		for(int i=1;i<length+1;i++)
			newArray[i] = array[i-1];
		for(int k=length/2;k>=1;k--){
			sink(newArray,k,length);
		}
		int index=0;
		while(length!=0){
			array[index++] = newArray[1];
			exch(newArray,1,length--);
			sink(newArray,1,length); 
		}
	}

	public static void exch(int[] array,int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
 	}
//关键在于下沉方法，下沉的过程不断的和其子结点进行比较
	public static void sink(int[] array,int k,int len){
		while(2*k<=len){
			int tmp;
			if((2*k+1<=len)&&array[2*k]>array[2*k+1])
				tmp = 2*k+1;
			else tmp = 2*k;
			if(array[k]>array[tmp]){
				exch(array,k,tmp);
				k = tmp;
			}else break;
		}
	}


	public static void sink(int[]array,int k,int len){
		while(2*k<=len){
			int tmp;
			if((2*k+1<=len)&&array[2*k]>array[2*k+1])
				tmp = 2*k+1;
			else tmp = 2*k;
			if(array[k]>array[tmp]){
				exch(array,k,tmp);
				k = tmp;
			}else break;
		}
	}

	public static void main(String[] args){
		int [] array = {7,1,3,9,3,4,0,7}; 
		stackSort(array);
		for(int i:array){
			System.out.println(i);
		}

	}
}