public class InsertSort{

	public static void sort(int[] array){
		int length = array.length;
		if(length>1){
			for(int i=1; i<length; i++){
				if(array[i]<array[i-1]){
					int j=i-1;
					int num = array[i];
					for(; j>=0; j--){
						if(num>=array[j])
							break;
						array[j+1]=array[j];
					}
					array[j+1]=num;
				}
			}

		}
	}

	public static void main(String[] args){
		int [] array = {1,2,3,4,3,1,5};
		sort(array);
		for(int i: array)
			System.out.println(i);

	}
}