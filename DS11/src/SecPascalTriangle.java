
public class SecPascalTriangle {
	
	static int[][] triangle = new int[10][10];
	static int[][] counting = new int[10][10];
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		if(triangle[num1][num2]!=0){
			return triangle[num1][num2];
		}
		else{
			count++;
			if(num2==0 || num1==num2) {
				triangle[num1][num2] = 1;
				return 1;
			}
			else {
				triangle[num1][num2] = c(num1-1, num2-1)+c(num1-1, num2);
				return triangle[num1][num2];
			}
		}
		
	}
	
}
