package problem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class SetSchedule {
	// ATTRIBUTES
	private String day = new String();
	private ArrayList<LocalTime> startTime = new ArrayList<LocalTime>();
	private ArrayList<LocalTime> endTime = new ArrayList<LocalTime>();
	private ArrayList<Subject> subjectName = new ArrayList<Subject>();

	// METHODS

	public void addStartTime(LocalTime startTime) {
		this.startTime.add(startTime);
	}

	public void addEndTime(LocalTime endTime) {
		this.endTime.add(endTime);
	}

	public void setday(String day) {
		this.day = day;
	}

	public String getDay() {
		return day;
	}

	public LocalTime getStartTime(int i) {
		return this.startTime.get(i);
	}

	public LocalTime getEndTime(int i) {
		return this.endTime.get(i);
	}

	public ArrayList<Subject> getSubject() {
		return subjectName;
	}

	public Subject getSubjectindi(int i) {
		return this.subjectName.get(i);
	}

	public void addSubject(Subject subjectName) {
		this.subjectName.add(subjectName);
	}

	public void removeSubject(int index) {
		this.subjectName.remove(index);
	}

	public int getindexsubject(Subject subjectname) {
		return this.subjectName.indexOf(subjectname);
	}

	public void createSchedule(Subject subject, Lecturer lecturer) { // add subject into a day schedule
		Scanner scanner = new Scanner(System.in);
		String input = new String();

		System.out.println("Enter Subject: ");
		subject.createSubject(lecturer);
		this.addSubject(subject);

		scanner.nextLine();
		System.out.print("Enter Start time (hh:mm:ss): ");
		input = scanner.nextLine();
		LocalTime startTime = LocalTime.parse(input);
		this.addStartTime(startTime);

		System.out.print("Enter End time (hh:mm:ss): ");
		input = scanner.nextLine();
		LocalTime endTime = LocalTime.parse(input);
		this.addEndTime(endTime);
	}

	public void displaySchedule(Subject subject, int i) { // only display individual subject
		System.out.println("Subject Information: ");
		subject.displaySubject();
		System.out.println("Start time: " + this.getStartTime(i));
		System.out.println("End time: " + this.getEndTime(i));

	}

	// UNIT TESTING
	public static void main(String[] args) {
		SetSchedule monday = new SetSchedule();
		Subject subject1 = new Subject();
		Lecturer lec1 = new Lecturer();
		monday.createSchedule(subject1, lec1);
		monday.displaySchedule(monday.getSubjectindi(0), 0);

	}

}