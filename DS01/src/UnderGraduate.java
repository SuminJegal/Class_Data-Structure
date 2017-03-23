
public class UnderGraduate extends Student{
	
	boolean mil;
	
	public UnderGraduate(String name, int entYear, boolean mil) {
		super(name, entYear);
		this.mil = mil;
		
	}
	
	@Override
	public void graduate_year(){
		if(mil == true) System.out.println(name+"의 졸업년도는 "+(entYear+6)+"년");
		else System.out.println(name+"의 졸업년도는 "+(entYear+4)+"년");
	}

}
