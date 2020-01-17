package org.deloitte.sms.studentmarkregistration.dao.impl;



import java.util.List;

import org.deloitte.sms.studentmarkregistration.beans.Student;
import org.deloitte.sms.studentmarkregistration.beans.StudentMarkHigher;
import org.deloitte.sms.studentmarkregistration.beans.StudentMarkPrimary;
import org.deloitte.sms.studentmarkregistration.beans.StudentMarkSecondary;
import org.deloitte.sms.studentmarkregistration.dao.StudentMarkDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
@Repository
public class StudentMarkDaoImpl implements StudentMarkDao {
@Autowired
SessionFactory sessionFactory;
public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

public void addMarkPrimary(StudentMarkPrimary primary) {
Session session=sessionFactory.openSession();
Transaction tx=session.beginTransaction();
session.save(primary);
tx.commit();
session.close();
}
public void addMarkSecondary(StudentMarkSecondary secondary) {
Session session=sessionFactory.openSession();
Transaction tx=session.beginTransaction();
session.save(secondary);
tx.commit();
session.close();
}
public void addMarkHigher(StudentMarkHigher higher) {
Session session=sessionFactory.openSession();
Transaction tx=session.beginTransaction();
session.save(higher);
tx.commit();
session.close();

}
public String gradeCal(double avg)
{
	String grd ="";
	if(avg<50)
	grd="F";
	else if(avg>=90)
	grd="A";
	else if(avg>=70&&avg<90)
	grd="B";
	else if(avg>=50&&avg<70)
	grd="C";
	return grd;
	
}

public String validationForPrimary(int a, int b, int c, int d) {
	if((a<0||a>100||b<0||b>100||c<0||c>100||d<0||d>100))
	{
		return "false";
	}
	return "true" ;
}

public String validationForSecondary(int a, int b, int c, int d, int e) {
if(a>100||a<0||b>100||b<0||c>100||c<0||d>100||d<0||e>100||e<0)
return "false";
else
return "true";
}

public String validationForHigher(int a, int b, int c, int d, int e, int f) {
if(a>100||a<0||b>100||b<0||c>100||c<0||d>100||d<0||e>100||e<0||f>100||f<0)
return "false";
else
return "true";
}

public List<Student> getStudents() {
	Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Student> list=session.createQuery("from StudentInfo").list();
		for(Student std : list)
			System.out.println(std.getCategory()+ std.getStudentid()+std.getStudentname()+std.getStudentname()); 
		return list;
		}
		
	
public Student getStudents(String code) {
	Session session=sessionFactory.openSession();
	Student stud= (Student) session.get(Student.class, code);
	return stud;
}
	

}