
public class UnderGraduate extends Student{
	
	boolean mil;
	
	public UnderGraduate(String name, int entYear, boolean mil) {
		super(name, entYear);
		this.mil = mil;
		
	}
	
	@Override
	public void graduate_year(){
		if(mil == true) System.out.println(name+"�� �����⵵�� "+(entYear+6)+"��");
		else System.out.println(name+"�� �����⵵�� "+(entYear+4)+"��");
	}

}
