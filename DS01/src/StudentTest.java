
public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new Student("ȫ�浿", 1998, 30);
		UnderGraduate s2 = new UnderGraduate("������", 2015, true);
		Graduate s3 = new Graduate("���ڴ�", 2000, false);
		
		s1.graduate_year();
		System.out.println(s1);
		
		s2.graduate_year();
		s3.graduate_year();

	}

}
