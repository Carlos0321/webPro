package com.lec.ex03_student;

public class StudentDto {
	private int rank;
	private int sNo;
	private String sName;
	private String mName;
	private int score;
	
	public StudentDto() {}

	public StudentDto(int sNo, String sName, String mName,  int score) {
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}

	public StudentDto(int rank, int sNo, String sName, String mName,  int score) {
		this.rank = rank;
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}

	@Override
	public String toString() {
		if(rank!=0) {
			return  rank + "µî\t"  + "\t"+ sName + "\t" + mName + "\t" 
					+ "\t" + score + "\n";
		}else {
			return sNo + "\t"+ sName + "\t" + mName + "\t" 
					+ "\t" + score + "\n";
		}
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}
		
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
