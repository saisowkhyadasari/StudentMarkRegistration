package org.deloitte.sms.studentmarkregistration.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="student_info")
@Component
public class Student {
	
@Id
private String studentid;
@Column
	private String category;
@Column
	private String studentname;
@Column
	private String studentstandard;
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStudentstandard() {
		return studentstandard;
	}
	public void setStudentstandard(String studentstandard) {
		this.studentstandard = studentstandard;
	}
}



