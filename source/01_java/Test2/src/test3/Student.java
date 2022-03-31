package test3;

public class Student extends Person {
	private String ban;

	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
	}

	@Override
	public String infoString() {
		return "(ID)" + getId() + "\t(¿Ã∏ß)" + getName()+"\t(π›)"+ban;
	}
}
