package test;

public class CustomerDto {
	private int cno;
	private String phone;
	private String name;
	private int point;
	
	public CustomerDto(int cno, String phone, String name, int point) {
		this.cno = cno;
		this.phone = phone;
		this.name = name;
		this.point = point;
	}

	@Override
	public String toString() {
		return cno +"\t"+ phone +"\t"+ name +"\t"+ point ;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	

}
