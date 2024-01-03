package com.spring.models;

public class Student {

	private Integer id;
	private String name;

	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;

	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
