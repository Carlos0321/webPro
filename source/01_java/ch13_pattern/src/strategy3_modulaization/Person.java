package strategy3_modulaization;

import strategy3_interfaces.Iget;
import strategy3_interfaces.Ijob;

public class Person {
	private Iget get;
	private Ijob job;
	private String id;
	private String name;
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
		
	}
	public void job() {
		job.job();
	}
	public void get() {
		get.get();
	}
	public void print() {
		System.out.print(getId()+"\t"+getName());
	}
	public Iget getGet() {
		return get;
	}

	public void setGet(Iget get) {
		this.get = get;
	}

	public Ijob getJob() {
		return job;
	}

	public void setJob(Ijob job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
