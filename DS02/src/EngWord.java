import java.util.Scanner;

public class EngWord {
	
	String[] a;
	String x;
	int size;
	
	public EngWord(int n){
		a = new String[n];
		size = n;
		
		
		for(int i =0; i<100; i++){
		System.out.println("단어를 입력하시오 : ");
		Scanner scan = new Scanner(System.in);
		x = scan.nextLine();
		
		input(x);
		}
		
		
	}
	
	public String[] resize(String[] a){
		String[] aa = new String[size*2];
		System.arraycopy(a,0,aa,0,size);
		size = 2*size;
		return aa;
	}
	
	public void input(String x){
		if(a[0]==null){ a[0]=x;}
		else{
			for(int i=0; i<a.length; i++){
				if(x.equals(a[i])){ remove(i); break;}
				else{
					if(a[size-1]==null){
						if(x.compareTo(a[i])<0){
							System.arraycopy(a, i, a, i+1, a.length-i-1);
							a[i] = x;
							break;
						}
						else if(x.compareTo(a[i])>0 && a[i+1]==null){
							a[i+1]=x;
							break;
						}
					}
					else{
						a = resize(a);
						i--;
					}
				}
			}
		}
	}
	
	public void remove(int i){
			System.arraycopy(a, i+1, a, i, a.length-i-1);
			a[a.length-1] = null;
			System.out.println("입력하신 단어는 : ");
			for(int j=0; j<a.length; j++)
				System.out.print(a[j]+" ");
			System.out.println();
	}

}
