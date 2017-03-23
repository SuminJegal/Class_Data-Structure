
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
		System.out.println(name+"의 졸업년도는 "+(entYear+4)+"년");
	}
	
	public String toString(){
		return name+"의 학점은 "+score+"입니다.";
	}

}
