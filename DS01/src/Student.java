
public class Student {
	
	String name;
	int entYear;
	private double score=0;
	
	public Student(String name, int entYear) {
		this.name = name;
		this.entYear = entYear;
	}
	
	public Student(String name, int entYear, double score) {
		this.name = name;
		this.entYear = entYear;
		this.score = score;
	}
	
	public void graduate_year() {
		System.out.println(name+"�� �����⵵�� "+(entYear+4)+"��");
	}
	
	public String toString(){
		return name+"�� ������ "+score+"�Դϴ�.";
	}

}
