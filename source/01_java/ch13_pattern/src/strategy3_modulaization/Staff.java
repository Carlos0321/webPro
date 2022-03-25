package strategy3_modulaization;

import strategy3_interfaces.GetSalary;
import strategy3_interfaces.JobMng;

public class Staff extends Person {
	private String part;

	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());

	}

	@Override
	public void print() {
		super.print();
		System.out.println("\t"+part);
	}
}
