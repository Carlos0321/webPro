package strategy3_modulaization;

import strategy3_interfaces.GetSalary;
import strategy3_interfaces.JobLec;

public class Lecturer extends Person {
	private String subject;
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject =subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t"+subject);
}
}