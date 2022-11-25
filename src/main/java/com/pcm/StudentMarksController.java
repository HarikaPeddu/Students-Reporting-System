package com.pcm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentMarksController
{
	@GetMapping("/student-marks-card-json")
	@ResponseBody
	public StudentMarks displayMarks(@RequestParam(name="name", required=false, defaultValue="0") String name, @RequestParam(name="semester", required=false, defaultValue="0") float semester, @RequestParam(name="english", required=false, defaultValue="0") float english, @RequestParam(name="science", required=false, defaultValue="0") float science, @RequestParam(name="maths", required=false, defaultValue="0") float maths)
	{
		StudentMarks marks = new StudentMarks();
		marks.setName(name);
		marks.setSemester(semester);
		marks.setEnglish(english);
		marks.setScience(science);
		marks.setMaths(maths);
		
        marks.setTotal(marks.getEnglish() + marks.getScience() + marks.getMaths());
		
		marks.setAverage(marks.getTotal() / 3);
		
		if(marks.getAverage()>=80)
		{
			marks.setGrade('A');
		}
		else if(marks.getAverage()>=50)
		{
			marks.setGrade('B');
		}
		else
		{
			marks.setGrade('C');
		}
		
		marks.getName();
		marks.getSemester();
		marks.getEnglish();
		marks.getScience();
		marks.getMaths();
		marks.getTotal();
		marks.getGrade();
		marks.getAverage();
		
		
		return marks;
	}
	
	@GetMapping("/student-marks-card-html")
	public ModelAndView htmlView (Model model, @RequestParam(required=false, defaultValue="0") String name, @RequestParam(name="semester", required=false, defaultValue="0") float semester, @RequestParam(required=false, defaultValue="0") float english, @RequestParam(required=false, defaultValue="0") float science, @RequestParam(required=false, defaultValue="0") float maths)
	{
		StudentMarks marks = new StudentMarks();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("marks", marks);
		mav.setViewName("marksinput.html");
		return mav;
	}
	
	@GetMapping("/marks-output-html")
	public ModelAndView htmlProcess(Model model, @RequestParam(required=false) String name, @RequestParam(name="semester", required=false, defaultValue="0") float semester, @RequestParam(required=false) float english, @RequestParam(required=false) float science, @RequestParam(required=false) float maths)
	{
		StudentMarks marks = new StudentMarks();
		
		marks.setName(name);
		marks.setSemester(semester);
		marks.setEnglish(english);
		marks.setScience(science);
		marks.setMaths(maths);
		
		marks.setTotal(marks.getEnglish() + marks.getScience() + marks.getMaths());
		
		marks.setAverage(marks.getTotal() / 3);
		
		if(marks.getAverage()>=80)
		{
			marks.setGrade('A');
		}
		else if(marks.getAverage()>=50)
		{
			marks.setGrade('B');
		}
		else
		{
			marks.setGrade('C');
		}
		
		marks.getName();
		marks.getSemester();
		marks.getEnglish();
		marks.getScience();
		marks.getMaths();
		marks.getTotal();
		marks.getGrade();
		marks.getAverage();
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("marks", marks);
		mav.setViewName("mymarks.html");
		
		return mav;
	}
	
}