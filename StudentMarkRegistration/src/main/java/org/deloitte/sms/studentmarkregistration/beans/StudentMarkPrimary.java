package org.deloitte.sms.studentmarkregistration.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="student_mark_primary")
@Component
public class StudentMarkPrimary {
	@Id
	private int studentid;
	@Column(name="english_mark")
	private int english;
	@Column(name="hindi_mark")
	private int hindi;
	@Column(name="science_mark")
	private int science;
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
public int getHindi() {
	return hindi;
}
public void setHindi(int hindi) {
	this.hindi = hindi;
}
public int getScience() {
	return science;
}
public void setScience(int science) {
	this.science = science;
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