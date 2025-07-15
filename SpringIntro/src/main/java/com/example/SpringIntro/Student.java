package com.example.SpringIntro;

public class Student {
	
	private College college;
	
	public void setCollege(College college) {
		this.college = college;
	}
	
	public void displayCollege() {
		System.out.println("Students is from " + college.getCollgeName());
	}
}
