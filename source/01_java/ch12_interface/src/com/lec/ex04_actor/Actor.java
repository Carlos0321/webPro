package com.lec.ex04_actor;

public class Actor implements IFireFighter, IPoliceMan, IChef {
	private String name;

	public Actor(String name) {
		this.name = name;
	}
	
	
	@Override
	public void makePizza() {
		System.out.println(name + "은 피자를 요리할 수 있습니다");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name + "은 스파게티를 요리할 수 있습니다");
	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name + "은 범인을 잡습니다");
	}

	@Override
	public void canSearch() {
		System.out.println(name + "은 찾을 수 있습니다");
	}

	@Override
	public void outFire() {
		System.out.println(name + "은 불을 끌 수 있습니다 ");
	}

	@Override
	public void saveMan() {
		System.out.println(name + "은 사람을 구할 수 있습니다");
	}


	public String getName() {
		return name;
	}
	

}
