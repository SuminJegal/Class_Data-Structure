
public class MyLength implements Length{
	
	private double inch;
	private double centi;
	
	public MyLength(int start, int end, int gap){
		for(int i=0; i<=(end-start)/gap; i++){
			setCenti(start+(i*gap));
			System.out.println((int)centi+"cm = "+round(getInch())+"inch");
		}
		for(int i=0; i<=(end-start)/gap; i++){
			setInch(start+(i*gap));
			System.out.println((int)inch+"inch = "+round(getCenti())+"cm");
		}
	}
	
	public double getInch(){
		return centi/2.54;
	}
	
	public double getCenti(){
		return inch*2.54;
	}
	
	public void setInch(double inch){
		this.inch = inch;
	}
	
	public void setCenti(double centi){
		this.centi = centi;
	}
	
	private double round(double x) {
		return Math.round(10*x)/10.0;
	}

}
