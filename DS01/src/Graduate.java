
public class Graduate extends Student{
	
	boolean doctor;
	
	public Graduate(String name, int entYear, boolean d){
		super(name, entYear);
		doctor = d;
	}
	
	@Override
	public void graduate_year(){
		if(doctor == true) System.out.println(name+"의 졸업년도는 "+(entYear+5)+ "년");
		else System.out.println(name+"의 졸업년도는 "+(entYear+2)+ "년");
	}

}
