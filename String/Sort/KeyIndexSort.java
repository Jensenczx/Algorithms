int N = a.length;
String[] aux = new String[N];
int[] count = new int[R+1];
//计算每个键出现频率
for(int i=0; i<N; i++)
	count[a[i].key+1]++;
//将频率转化为索引
for(int r=0; r<R; r++)
	count[r+1] += count[r];
//根据索引进行排序
for(int i=0; i<N; i++)
	aux[count[a[i].key]++] = a[i];
//数据回填到原来的数组中
for(int i=0; i<N; i++)
	a[i] = aux[i];