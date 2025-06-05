package solution;

import java.util.ArrayList;

public class StudentInfo extends Name {
	private String studentID;
	private TodoList todoList;
	private CGPA gpa;
	private ArrayList<Schedule> schedules;

	public StudentInfo(String fName, String mName, String lName, String studentID, TodoList todoList, CGPA gpa,
			ArrayList<Schedule> schedules) {
		super(fName, mName, lName);
		this.studentID = studentID;
		this.todoList = todoList;
		this.gpa = gpa;
		this.schedules = schedules;
	}

	public String getStudentID() {
		return studentID;
	}

	public TodoList getTodoList() {
		return todoList;
	}

	public CGPA getGpa() {
		return gpa;
	}

	public void addSchedule(Schedule schedule) {
		schedules.add(schedule);
	}

	public ArrayList<Schedule> getSchedules() {
		return new ArrayList<>(schedules);
	}

	public Schedule getScheduleByDay(String day) {
		for (Schedule schedule : getSchedules()) {
			if (schedule.getDay().equalsIgnoreCase(day)) {
				return schedule;
			}
		}
		return null;
	}
}
