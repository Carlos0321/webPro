package com.lec.ch19.dto;

import lombok.Data;

@Data
// 매개변수를 받기 때문에 생성자함수 있어도되고 없어도되고
public class Member {
	private String mid;
	private String mpw;
	private String mname;
	private String mmail;
	private String mpost;
	private String maddress;
}
