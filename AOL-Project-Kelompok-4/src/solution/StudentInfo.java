package solution;

import java.util.ArrayList;

public class StudentInfo extends Name {
    private String studentID;
    private TodoList todoList;
    private CGPA gpa; 
    private ArrayList<Schedule> schedules;

    public StudentInfo() {
        this.schedules = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }

    public CGPA getGpa() {
        return gpa;
    }

    public void setGpa(CGPA gpa) {
        this.gpa = gpa;
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
