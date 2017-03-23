
public class PascalTriangle {
	
	static int[][] counting = new int[10][10];
	static int count = 0;
	
	public static void main(String[] args) {
		for(int i=0; i<10; i++){
			for(int j=0;j<=i; j++){
				System.out.print(c(i, j)+" ");
				counting[i][j] = count;
				count = 0;
			}
			System.out.println();
		}
		for(int i=0; i<10; i++){
			for(int j=0;j<=i; j++){		
				System.out.print("["+counting[i][j]+"ȸ] ");
			}
			System.out.println();
		}
	}
	
	static int c(int num1, int num2){
		count++;
		if(num2==0 || num1==num2) return 1;
		else return c(num1-1, num2-1)+c(num1-1, num2);
	}

}
