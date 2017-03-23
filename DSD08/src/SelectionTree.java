
public class SelectionTree {
	
	int kWay;
	int subFileNum=0; //서브파일을 삽입할 때 필요한 인덱스
	int sortNum = 0; //sorted배열에서 하나씩 추가할때마다 늘려주는 인덱스
	Queue[] subFile; //정렬되어있는 서브파일들
	BinaryTree sTree[];
	int[] sorted;
	
	public SelectionTree(){
		kWay = 8;
		subFile = new Queue[kWay];
		sTree = new BinaryTree[kWay*2-1];
		for(int i =0; i<kWay*2-1; i++){
			if(i<kWay)
				subFile[i] = new Queue();
			sTree[i] = new BinaryTree();
		}
		sorted = new int[kWay*10];
	}
	
	public void addSub(int[] n){
		for(int i=0; i<n.length*2; i++){
			if(i<n.length)
				subFile[subFileNum].add(n[i]);
			else
				subFile[subFileNum].add(Integer.MAX_VALUE);
		}
		subFileNum++;
	}

	public void sort(){
		for(int i=0; i<kWay; i++){ //서브파일의 가장 작은 값들을 이진트리에 넣는다.
			sTree[i+kWay-1].value = (int)subFile[i].remove();
			sTree[i+kWay-1].index = i+kWay-1;
		}
		for(int i=sTree.length-1;i>0;i-=2){ //이진트리를 모두 채운다
			if(sTree[i].value > sTree[i-1].value){
				sTree[(i-1)/2].value=sTree[i-1].value;
				sTree[(i-1)/2].index=i-1;
			}
			else{
				sTree[(i-1)/2].value=sTree[i].value;
				sTree[(i-1)/2].index=i;
			}
		}
		while(sTree[0].value<Integer.MAX_VALUE){
			pop();
		}
	}
	
	public void printSort(){
		for(int i=0; i<sortNum; i++){
			if(i<9)
				System.out.print(" "+sorted[i]+" ");
			else
				System.out.print(sorted[i]+" ");
			if(((i+1)%10)==0) System.out.println();
		}
		System.out.println();
	}
	
	private void pop(){
		sorted[sortNum++] = sTree[0].value;
		int k;
		for(k = sTree[0].index; k<kWay-1; k = sTree[k].index) ;
		sTree[k].value = (int)subFile[k-kWay+1].remove();
		for(int i=k; i>0; i=(i-1)/2){
			if((i%2)==0){ //i가 짝수라면 왼쪽과 비교
				if(sTree[i].value > sTree[i-1].value){
					sTree[(i-1)/2].value=sTree[i-1].value;
					sTree[(i-1)/2].index=i-1;
				}
				else{
					sTree[(i-1)/2].value=sTree[i].value;
					sTree[(i-1)/2].index=i;
				}
			}
			else{ //i가 홀수라면 오른쪽과 비교
				if(sTree[i].value > sTree[i+1].value){
					sTree[i/2].value=sTree[i+1].value;
					sTree[i/2].index=i+1;
				}
				else{
					sTree[i/2].value=sTree[i].value;
					sTree[i/2].index=i;
				}
			}
		}
	}
	
	
	private class BinaryTree{
		int value;
		int index=16;
		
		public String toString(){
			return value+"";
		}
	}

}
