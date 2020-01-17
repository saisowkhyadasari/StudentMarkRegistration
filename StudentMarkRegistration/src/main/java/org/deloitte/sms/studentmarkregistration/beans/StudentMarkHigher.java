package org.deloitte.sms.studentmarkregistration.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="student_mark_higher")
@Component
public class StudentMarkHigher {
	@Id
	private int studentid;
	@Column(name="english_mark")
	private int english;
	@Column(name="tamil_mark")
	private int tamil;
	@Column(name="physics_mark")
	private int physics;
	@Column(name="chemistry_mark")
	private int chemistry;
	@Column(name="computer_mark")
	private int computer;
	@Column(name="maths_mark")
	private int maths;
	@Column(name="total_mark")
	private int total;
	@Column(name="average_mark")
	private double average;
	@Column(name="grade")
	private String grade;
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getTamil() {
		return tamil;
	}
	public void setTamil(int tamil) {
		this.tamil = tamil;
	}
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getChemistry() {
		return chemistry;
	}
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
