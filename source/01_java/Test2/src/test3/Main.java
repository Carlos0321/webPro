package test3;

public class Main {

	public static void main(String[] args) {
		Person st1 = new Student("A01", "나학생","JAVA반");
		Person st2 = new Student("A02", "홍길동","C++반");
		Person sf1=  new Staff("S01", "나직원", "교무팀");
		Person sf2=  new Staff("S02", "나도요", "취업지원팀");
		Person ga1 = new Gangsa("G01", "나선생", "프로그래밍");
		
		Person[] p = {st1,st2,sf1,sf2,ga1};
		for(Person person : p)
			System.out.println(person.infoString());
	}

}
