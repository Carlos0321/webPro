package quiz;

public class Member {
	private String name;
	private String tel;
	private String address;
	public Member(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	@Override
	public String toString() {
		return name +"의 연락처 : "+tel+","+"주소 : "+address;
	}
}
