
public class Graduate extends Student{
	
	boolean doctor;
	
	public Graduate(String name, int entYear, boolean d){
		super(name, entYear);
		doctor = d;
	}
	
	@Override
	public void graduate_year(){
		if(doctor == true) System.out.println(name+"�� �����⵵�� "+(entYear+5)+ "��");
		else System.out.println(name+"�� �����⵵�� "+(entYear+2)+ "��");
	}

}
