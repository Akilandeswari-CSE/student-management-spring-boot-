package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="det")



public class Student {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;
	@Column
	private String name;
	@Column
	private String grade;
	
	public Student() {}

	
	public Student(int id, String name,String grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade=grade;
	}

	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
