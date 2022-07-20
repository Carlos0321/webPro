package com.lec.ch14.service;

import java.util.List;

import com.lec.ch14.dto.Dept;
import com.lec.ch14.dto.Emp;

public interface EmpService {
	public List<Dept> deptlist();
	public List<Emp> emplist(Emp schEmp);
}
