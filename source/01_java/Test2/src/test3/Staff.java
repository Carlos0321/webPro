package test3;

public class Staff extends Person{
	private String department;

	public Staff(String id, String name,String department) {
		super(id,name);
		this.department = department;
	}
	@Override
	public String infoString() {
		return  "(ID)" + getId() + "\t(이름)" +getName()+"\t(부서)"+department;
	}
}
