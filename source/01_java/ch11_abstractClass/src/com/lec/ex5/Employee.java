package com.lec.ex5;

public abstract class Employee {
	private String name;

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public abstract int computepay();

	public final int computeIncentive() {
		
		if (computepay() > 2000000) {
			return (int)(computepay() * 0.1);
		}
		return 0;
		 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
