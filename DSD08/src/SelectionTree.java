
public class SelectionTree {
	
	int kWay;
	int subFileNum=0; //���������� ������ �� �ʿ��� �ε���
	int sortNum = 0; //sorted�迭���� �ϳ��� �߰��Ҷ����� �÷��ִ� �ε���
	Queue[] subFile; //���ĵǾ��ִ� �������ϵ�
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
		for(int i=0; i<kWay; i++){ //���������� ���� ���� ������ ����Ʈ���� �ִ´�.
			sTree[i+kWay-1].value = (int)subFile[i].remove();
			sTree[i+kWay-1].index = i+kWay-1;
		}
		for(int i=sTree.length-1;i>0;i-=2){ //����Ʈ���� ��� ä���
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
			if((i%2)==0){ //i�� ¦����� ���ʰ� ��
				if(sTree[i].value > sTree[i-1].value){
					sTree[(i-1)/2].value=sTree[i-1].value;
					sTree[(i-1)/2].index=i-1;
				}
				else{
					sTree[(i-1)/2].value=sTree[i].value;
					sTree[(i-1)/2].index=i;
				}
			}
			else{ //i�� Ȧ����� �����ʰ� ��
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
