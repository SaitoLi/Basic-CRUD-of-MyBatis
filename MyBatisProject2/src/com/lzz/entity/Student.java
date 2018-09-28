package com.lzz.entity;

public class Student {
	private int id;
	private String stuName;
	private int age;
	private int score;

	public Student() {

	}

	public Student(int id, String stuName, int age, int score) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String toString() {
		return this.id + "-" + this.stuName + "-" + this.age + "-" + this.score;
	}
}
