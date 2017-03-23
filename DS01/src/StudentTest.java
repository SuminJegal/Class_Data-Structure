
public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new Student("홍길동", 1998, 30);
		UnderGraduate s2 = new UnderGraduate("가나다", 2015, true);
		Graduate s3 = new Graduate("바자다", 2000, false);
		
		s1.graduate_year();
		System.out.println(s1);
		
		s2.graduate_year();
		s3.graduate_year();

	}

}
