package com.lec.ex5;

public class TestMain {

	public static void main(String[] args) {
		Employee[] sawon = { new SalaryEmployee("홍길동", 24000000), // 이름, 연봉
				             new SalaryEmployee("강동원", 70000000), 
				             new SalaryEmployee("김고은", 12000000),
				             new HourlyEmployee("홍길구", 100, 7000), // 이름, 일한 시간, 시간당수당
				             new HourlyEmployee("김길자", 120, 8000) };
		
		for (Employee temp : sawon) {
			System.out.println("~ ~ ~ 월급명세서 ~ ~ ~");
			System.out.println("성 함 :" + temp.getName());
			System.out.println("월 급 : " + temp.computepay());
			//System.out.println("상 여 : "+ temp.computeIncentive());
			int tempIncen = temp.computeIncentive();
			if (tempIncen != 0) {
				System.out.println("상 여 :" + tempIncen);
			}
		}
	}

}
