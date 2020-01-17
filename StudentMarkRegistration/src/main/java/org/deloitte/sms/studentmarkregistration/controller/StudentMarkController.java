package org.deloitte.sms.studentmarkregistration.controller;

import org.deloitte.sms.studentmarkregistration.beans.Student;
import org.deloitte.sms.studentmarkregistration.beans.StudentMarkHigher;
import org.deloitte.sms.studentmarkregistration.beans.StudentMarkPrimary;
import org.deloitte.sms.studentmarkregistration.beans.StudentMarkSecondary;
import org.deloitte.sms.studentmarkregistration.dao.StudentMarkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentMarkController {
@Autowired
StudentMarkDao dao;

@RequestMapping(value="/details",method=RequestMethod.GET)
public String  showViewScreen(){
	return "details";
	}
//for displaying studentinfo table
@RequestMapping(value="/details",method=RequestMethod.POST)
public ModelAndView getStudents(@RequestParam("studentid")String id){
	
	ModelAndView mav=new ModelAndView();
	Student std=dao.getStudents(id); 
	mav.addObject("std",std.getStudentstandard());
	mav.addObject("name",std.getStudentname());
	mav.addObject("cate",std.getCategory());
	mav.addObject("id",std.getStudentid());
	mav.setViewName("ViewDetails");
	return mav;
}
	



@RequestMapping(value="/admin",method=RequestMethod.GET)
public String showStudentSelectionForm(){
return "StudentSelection";
}
@RequestMapping(value="/primary",method=RequestMethod.GET)
public ModelAndView showPrimaryForm(@RequestParam("studentid")String  studentid,@RequestParam("standard")String standard)
{
ModelAndView mav=new ModelAndView();
mav.addObject("studentid",studentid);
mav.addObject("standard",standard);
mav.setViewName("MarkEntryPrimary");
return mav;
}
@RequestMapping(value="/secondary",method=RequestMethod.GET)
public ModelAndView showSecondaryForm(@RequestParam("studentid")String  studentid,@RequestParam("standard")String standard)

{
	ModelAndView mav=new ModelAndView();
	mav.addObject("studentid",studentid);
	mav.addObject("standard",standard);
	mav.setViewName("MarkEntrySecondary");
    return mav;
}
@RequestMapping(value="/higher",method=RequestMethod.GET)
public ModelAndView showHigherMarksForm(@RequestParam("studentid")String  studentid,@RequestParam("standard")String standard)

{
ModelAndView mav=new ModelAndView();
mav.addObject("studentid",studentid);
mav.addObject("standard",standard);
mav.setViewName("MarkEntryHigher");
return mav;

}
@RequestMapping(value="/admin",method=RequestMethod.POST)
public ModelAndView categoryValidation(@RequestParam("category")String Category,@RequestParam("studentid")String  studentid,@RequestParam("standard")String standard){

ModelAndView mav=new ModelAndView();
mav.addObject("studentid",studentid);
mav.addObject("standard",standard);
if(Category.equals("P"))
mav.setViewName("redirect:primary");
if(Category.equals("S"))
mav.setViewName("redirect:secondary");
if(Category.equals("H"))
mav.setViewName("redirect:higher");
return mav;

}
@RequestMapping(value="/primary",method=RequestMethod.POST)
public ModelAndView addMarkPrimary(@RequestParam("english")int e,@RequestParam("hindi")int h,@RequestParam("science")int s,@RequestParam("maths")int m,@RequestParam("studentid")int stu,@RequestParam("standard")int std){
	 ModelAndView mav=new ModelAndView();
	 String val =dao.validationForPrimary(e,h,s,m);
	 if(val.equals("true"))
	 {
	int total = (e+h+s+m);
	double avg =total/4;
	String grade = dao.gradeCal(avg);
	StudentMarkPrimary primary =new StudentMarkPrimary();
	primary.setEnglish(e);
	primary.setHindi(h);
	primary.setMaths(m);
	primary.setScience(s);
	primary.setAverage(avg);
	primary.setGrade(grade);
	primary.setStudentid(stu);
	primary.setTotal(total);
    dao.addMarkPrimary(primary);
   mav.setViewName("redirect:welcome");
   return mav;
	 }
	 else
		 System.out.println("ERROR CODE 510");
	 return null;

}
@RequestMapping(value="/welcome",method=RequestMethod.GET)
public String showWelcomForm(){
return "welcome";
}
@RequestMapping(value="/secondary",method=RequestMethod.POST)
public ModelAndView addMarkSecondary(@RequestParam("english")int e,@RequestParam("social")int so,@RequestParam("hindi")int h,@RequestParam("science")int s,@RequestParam("maths")int m,@RequestParam("studentid")int stu,@RequestParam("standard")int std){
ModelAndView mav=new ModelAndView();
String validate=dao.validationForSecondary(e,h,s,m,so);
if(validate.equals("true")){
int total = (e+h+s+m+so);
double avg =total/5;
String grade=dao.gradeCal(avg);
StudentMarkSecondary secondary =new StudentMarkSecondary();
secondary.setEnglish(e);
secondary.setHindi(h);
secondary.setMaths(m);
secondary.setSocial(so);
secondary.setScience(s);
secondary.setAverage(avg);
secondary.setGrade(grade);
secondary.setStudentid(stu);
secondary.setTotal(total);
   dao.addMarkSecondary(secondary);
  mav.setViewName("redirect:welcome");
  return mav;
  }
else
System.out.println("Invalid marks,ERROR CODE 510)");
return null;

}
@RequestMapping(value="/higher",method=RequestMethod.POST)
public ModelAndView addMarkHigher(@RequestParam("english")int e,@RequestParam("computer")int c,@RequestParam("chemistry")int ch,@RequestParam("tamil")int t,@RequestParam("physics")int p,@RequestParam("maths")int m,@RequestParam("studentid")int stu,@RequestParam("standard")int std){
ModelAndView mav=new ModelAndView();
String validate=dao.validationForHigher(e,t,ch,p,m,c);
if(validate.equals("true")){
int total = (e+t+ch+p+m+c);
double avg =total/6;
String grade=dao.gradeCal(avg);
StudentMarkHigher higher =new StudentMarkHigher();
higher.setEnglish(e);
higher.setTamil(t);
higher.setMaths(m);
higher.setPhysics(p);
higher.setChemistry(ch);
higher.setAverage(avg);
higher.setGrade(grade);
higher.setStudentid(stu);
higher.setTotal(total);
   dao.addMarkHigher(higher);
  mav.setViewName("redirect:welcome");
  return mav;}
else
System.out.println("Invalid marks,ERROR CODE 510)");
return null;
}

}