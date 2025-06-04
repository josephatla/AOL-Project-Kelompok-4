package solution;

import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentInfo student = initializeStudent(scanner);

        while (true) {
            displayMainMenu();
            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    handleCGPA(scanner, student);
                    break;
                case 2:
                    handleTasks(scanner, student.getTodoList());
                    break;
                case 3:
                    handleSchedule(scanner, student);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1 - CGPA");
        System.out.println("2 - Tasks");
        System.out.println("3 - Schedule");
        System.out.println("4 - Exit");
        System.out.print("Enter option: ");
    }

    private static StudentInfo initializeStudent(Scanner scanner) {
        StudentInfo student = new StudentInfo();

        System.out.println("=== Student Information ===");
        System.out.print("First Name: ");
        student.setfName(scanner.nextLine());
        System.out.print("Middle Name: ");
        student.setmName(scanner.nextLine());
        System.out.print("Last Name: ");
        student.setlName(scanner.nextLine());
        System.out.print("Student ID: ");
        student.setStudentID(scanner.nextLine());

        student.setGpa(new CGPA());
        student.setTodoList(new TodoList());

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : days) {
            student.addSchedule(new Schedule(day));
        }

        return student;
    }

    private static void handleCGPA(Scanner scanner, StudentInfo student) {
        CGPA gpa = student.getGpa();

        while (true) {
            System.out.println("\nCGPA Menu:");
            System.out.println("1 - Calculate Semester GPA");
            System.out.println("2 - Display All GPAs");
            System.out.println("3 - Calculate Overall CGPA");
            System.out.println("4 - Return to Main Menu");
            System.out.print("Enter option: ");
            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter semester number (1-10): ");
                    int semester = readInt(scanner);
                    if (semester >= 1 && semester <= 10) {
                        double semesterGPA = gpa.calcGPA();
                        gpa.addSemesterGPA(semesterGPA, semester);
                        System.out.printf("GPA for semester %d: %.2f%n", semester, semesterGPA);
                    } else {
                        System.out.println("Invalid semester number.");
                    }
                    break;
                case 2:
                    gpa.displaySemesterGPAs();
                    break;
                case 3:
                    double overallCGPA = gpa.calcCGPA();
                    System.out.printf("\nCurrent CGPA: %.2f%n", overallCGPA);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void handleTasks(Scanner scanner, TodoList todoList) {
        while (true) {
            System.out.println("\nTask Menu:");
            System.out.println("1 - Create Task");
            System.out.println("2 - Delete Task");
            System.out.println("3 - Check Task Status");
            System.out.println("4 - Display Tasks");
            System.out.println("5 - Manage Task Types");
            System.out.println("6 - Return to Main Menu");
            System.out.print("Enter option: ");
            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    if (Task.getTaskTypes().isEmpty()) {
                        System.out.println("No task types defined. Please create task types first (option 5).");
                    } else if (todoList.size() >= 5) {
                        System.out.println("Task list is full. Please complete or delete tasks.");
                    } else {
                        Task task = new Task();
                        task.createTask(scanner);
                        todoList.addTask(task);
                    }
                    break;
                case 2:
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println(i + " - " + todoList.getTask(i).getDescription());
                    }
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = readInt(scanner);
                    if (deleteIndex >= 0 && deleteIndex < todoList.size()) {
                        todoList.removeTask(deleteIndex);
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 3:
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println(i + " - " + todoList.getTask(i).getDescription());
                    }
                    System.out.print("Enter task number to check: ");
                    int checkIndex = readInt(scanner);
                    if (checkIndex >= 0 && checkIndex < todoList.size()) {
                        Reminder.checkTaskStatus(todoList.getTask(checkIndex));
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 4:
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println("--- Task " + (i + 1) + " ---");
                        todoList.getTask(i).displayTask();
                    }
                    break;
                case 5:
                    Task.manageTaskTypes();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void handleSchedule(Scanner scanner, StudentInfo student) {
        while (true) {
            System.out.println("\nSchedule Menu:");
            System.out.println("1 - Add Class");
            System.out.println("2 - Remove Class");
            System.out.println("3 - View Schedule");
            System.out.println("4 - Return to Main Menu");
            System.out.print("Enter option: ");
            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    String day = readDayOfWeek(scanner);
                    Schedule schedule = student.getScheduleByDay(day);
                    if (schedule != null) {
                        Lecturer lecturer = new Lecturer("", "", "", "", "", "", "");
                        Subject subject = new Subject("", "", lecturer, "", 0);
                        subject.createSubject(lecturer);
                        System.out.print("Enter start time (HH:MM): ");
                        LocalTime start = LocalTime.parse(scanner.nextLine());
                        System.out.print("Enter end time (HH:MM): ");
                        LocalTime end = LocalTime.parse(scanner.nextLine());
                        schedule.addScheduleEntry(new ScheduleEntry(subject, start, end));
                    } else {
                        System.out.println("Invalid day.");
                    }
                    break;
                case 2:
                    day = readDayOfWeek(scanner);
                    schedule = student.getScheduleByDay(day);
                    if (schedule != null) {
                        for (int i = 0; i < schedule.getEntries().size(); i++) {
                            System.out.println(i + " - " + schedule.getEntries().get(i).getSubject().getSubjectName());
                        }
                        System.out.print("Enter class number to remove: ");
                        int index = readInt(scanner);
                        if (index >= 0 && index < schedule.getEntries().size()) {
                            schedule.removeEntryAt(index);
                            System.out.println("Class removed.");
                        } else {
                            System.out.println("Invalid class number.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter day (e.g., Monday) or 'all': ");
                    String inputDay = scanner.nextLine();
                    if (inputDay.equalsIgnoreCase("all")) {
                        for (Schedule s : student.getSchedules()) {
                            s.displaySchedule();
                        }
                    } else {
                        Schedule s = student.getScheduleByDay(inputDay);
                        if (s != null) {
                            s.displaySchedule();
                        } else {
                            System.out.println("Invalid day.");
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    private static String readDayOfWeek(Scanner scanner) {
        System.out.print("Enter day of the week: ");
        return scanner.nextLine();
    }
}
