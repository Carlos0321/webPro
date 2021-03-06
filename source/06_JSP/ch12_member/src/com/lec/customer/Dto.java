package com.lec.customer;

import java.sql.Date;
import java.sql.Timestamp;

public class Dto {
	private String cid;
	private String cpw;
	private String cname;
	private String ctel;
	private String cemail;
	private String caddress;
	private String cgender;
	private Timestamp cbirth;
	private Date   crdate;
	public Dto() {}
	public Dto(String cid, String cpw, String cname, String ctel, String cemail, String caddress, String cgender,
			Timestamp cbirth, Date crdate) {
		this.cid = cid;
		this.cpw = cpw;
		this.cname = cname;
		this.ctel = ctel;
		this.cemail = cemail;
		this.caddress = caddress;
		this.cgender = cgender;
		this.cbirth = cbirth;
		this.crdate = crdate;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCpw() {
		return cpw;
	}
	public void setCpw(String cpw) {
		this.cpw = cpw;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCgender() {
		return cgender;
	}
	public void setCgender(String cgender) {
		this.cgender = cgender;
	}
	public Timestamp getCbirth() {
		return cbirth;
	}
	public void setCbirth(Timestamp cbirth) {
		this.cbirth = cbirth;
	}
	public Date getCrdate() {
		return crdate;
	}
	public void setCrdate(Date crdate) {
		this.crdate = crdate;
	}
	@Override
	public String toString() {
		return "Dto [cid=" + cid + ", cpw=" + cpw + ", cname=" + cname + ", ctel=" + ctel + ", cemail=" + cemail
				+ ", caddress=" + caddress + ", cgender=" + cgender + ", cbirth=" + cbirth + ", crdate=" + crdate + "]";
	}
	
	
}
