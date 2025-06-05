package problem;

import java.util.ArrayList;

public class StudentInfo extends Name {

	private String StudentID; // Student ID
	private to_do_list ToDoList;
	private CGPA gpa;
	private ListOfCGPA cgpa;
	private ArrayList<SetSchedule> listofschedule;

	public StudentInfo() {
		this.listofschedule = new ArrayList<SetSchedule>();
	}

	/* Setter method */
	public void setStudentID(String StudentID) {
		this.StudentID = StudentID;
	}

	public void setToDoList(to_do_list ToDoList) {
		this.ToDoList = ToDoList;
	}

	public void setGpa(CGPA gpa) {
		this.gpa = gpa;
	}

	public void setCgpa(ListOfCGPA cgpa) {
		this.cgpa = cgpa;
	}

	/* getter method */

	public String getStudentID() {
		return StudentID;
	}

	public to_do_list getToDoList() {
		return ToDoList;
	}

	public CGPA getGpa() {
		return gpa;
	}

	public ListOfCGPA getCgpa() {
		return cgpa;
	}

	// Add SetSchedule
	public void AddSchedule(SetSchedule schedule) {
		listofschedule.add(schedule);
	}

}