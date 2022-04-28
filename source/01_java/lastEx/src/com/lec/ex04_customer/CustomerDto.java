package com.lec.ex04_customer;

public class CustomerDto {
	private int cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int camount;
	private String levelname;
	private String forLevelup;
	
	public CustomerDto() {}

	public CustomerDto(int cid, String ctel, String cname,int cpoint, int camount, String levelname, String forLevelup) {
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint=cpoint;
		this.camount = camount;
		this.levelname = levelname;
		this.forLevelup = forLevelup;
	}

	@Override
	public String toString() {
		return cid + "\t"+ ctel +"\t\t"+ cname +"\t"+cpoint+"\t"+ camount+"\t"+ levelname +"\t"+forLevelup;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCamount() {
		return camount;
	}

	public void setCamount(int camount) {
		this.camount = camount;
	}

	
	public String getForLevelup() {
		return forLevelup;
	}

	public void setForLevelup(String forLevelup) {
		this.forLevelup = forLevelup;
	}

	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public int getCpoint() {
		return cpoint;
	}

	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}
	
	
	
	
	}
	
	

