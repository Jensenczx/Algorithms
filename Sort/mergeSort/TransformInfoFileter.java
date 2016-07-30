class TransformInfo{
	private String mContent;
	private long mTime;

	public long getTime(){
		return mTime;
	}

	public String getContent(){
		return mContent;
	}
}

public class TransformInfoFilter{

	private List<TransformInfo> transformList = new LinkedList<TransformInfo>();

	public void filterAndSort(List<TransformInfo> list){
		if(list==null||list.size()<=1)
			return;
		filter(list);
		sort(list);
	}


	private void filter(List<TransformInfo> list){
		Set<TransformInfo> toDelete = new HashSet<TransformInfo>();
		for(int i=0; i<list.size(); i++){
			TransformInfo tmp = list.get(i);
			for(int j=i+1; j<list.size(); j++){
				TransformInfo t = list.get(j);
				if(t.getContent().equals(tmp.getContent())){
					set.add(oldTime(tmp,t));
				}
			}
		}
		for(int k=0; k<toDelete.size(); k++){
			list.remove(toDelete.get(k));
		}
	}

	private void sort(List<TransformInfo> list){
		mergeSortBottom2Top(list,0,list.size()-1);
	}


	private void mergeSortBottom2Top(List<TransformInfo> list,int low,int high){
		for(int size=1; size<high;size=2*size){
			for(int i=0;i<high-size; i+=2*size){
				merge(list,i,i+size-1,Math.min(i+2*size-1,high-1));
			}
		}
	}
	public static void merge(List<TransformInfo> list,int low,int mid,int high){
		for(int i=low; i<=high; i++){
			transformList.set(i,list.get(i));
		}
		int lowFlag = low;
		int midFlag = mid+1;
		for(int k=low; k<=high; k++){
			if(lowFlag>mid) 
				list.set(k,transformList.get(midFlag++));
			else if(midFlag>high)
				list.set(k,transformList.get(lowFlag++));
			else{
				if(transformList.get(midFlag).getTime()>transformList.get(lowFlag).getTime){
					list.set(k,transformList.get(midFlag));
					midFlag++;
				}else{
					list.set(k,transformList[lowFlag]);
					lowFlag++;
				}

			}
		}
	}


	private TransformInfo oldTime(TransformInfo info1,TransformInfo info2){
		return info1.getTime()<info2.getTime()?info2:info1;
	}
}