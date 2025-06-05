package solution;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

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
				System.out.println("Exiting program. Thank you!!");
				scanner.close();
				return;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	public static void manageTaskTypes(Scanner scanner) {
		boolean loop = true;
		while (loop) {
			System.out.println("Choose an option:");
			System.out.println("1. Add task type");
			System.out.println("2. Remove task type");
			System.out.println("3. View task types");
			System.out.println("4. Return");

			int choice = readInt(scanner);

			switch (choice) {
			case 1:
				System.out.print("Enter task type: ");
				String type = scanner.nextLine();
				TaskType.addType(type);
				System.out.println(type + " added.");
				break;
			case 2:
				System.out.print("Enter task type index: ");
				int index = readInt(scanner);
				TaskType.removeType(index);
				System.out.println("Task type removed.");
				break;
			case 3:
				displayTaskTypes();
				break;
			case 4:
				loop = false;
				break;
			default:
				System.out.println("Invalid choice. Try again.");
				break;
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
		System.out.println("=== Student Information ===");
		System.out.print("First Name: ");
		String firstName = scanner.nextLine();
		System.out.print("Middle Name: ");
		String middleName = scanner.nextLine();
		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();
		System.out.print("Student ID: ");
		String studentID = scanner.nextLine();

		CGPA gpa = new CGPA();
		TodoList todoList = new TodoList();
		ArrayList<Schedule> schedules = new ArrayList<>();

		String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		for (String day : days) {
			schedules.add(new Schedule(day));
		}

		StudentInfo student = new StudentInfo(firstName, middleName, lastName, studentID, todoList, gpa, schedules);

		return student;
	}

	private static void displayLecturerDetails(Lecturer lecturer) {
		if (lecturer == null) {
			System.out.println("No lecturer information available.");
			return;
		}
		System.out.println("Name: " + lecturer.getfName() + " " + lecturer.getmName() + " " + lecturer.getlName());
		System.out.println("Office room: " + lecturer.getOfficeAddr());
		System.out.println("Office number: " + lecturer.getOfficeNum());
		System.out.println("Phone number: " + lecturer.getPhoneNum());
		System.out.println("Email: " + lecturer.getEmail());
	}

	private static void displaySubjectDetails(Subject subject) {
		if (subject == null) {
			System.out.println("No subject information available.");
			return;
		}
		System.out.println("Subject: " + subject.getSubjectName());
		System.out.println("Description: " + subject.getDescription());
		System.out.println("\nLecturer's information: ");
		displayLecturerDetails(subject.getLecturer());
		System.out.println("\nVenue: " + subject.getVenue());
		System.out.println("Credit Hour: " + subject.getCreditHr());
		System.out.println("\n");
	}

	private static void displayScheduleEntryDetails(ScheduleEntry entry) {
		if (entry == null) {
			System.out.println("No schedule entry details.");
			return;
		}
		displaySubjectDetails(entry.getSubject());
		System.out.println("Start time: " + entry.getStartTime());
		System.out.println("End time: " + entry.getEndTime());
	}

	private static void displayScheduleForDay(Schedule schedule) {
		if (schedule == null) {
			System.out.println("Invalid day selected or no schedule available.");
			return;
		}
		System.out.println("\n=== Schedule for " + schedule.getDay() + " ===");
		if (schedule.getEntries().isEmpty()) {
			System.out.println("No classes scheduled.");
		} else {
			for (int i = 0; i < schedule.getEntries().size(); i++) {
				System.out.println("--- Class " + (i + 1) + " ---");
				displayScheduleEntryDetails(schedule.getEntries().get(i));
				System.out.println("----------------------------------");
			}
		}
	}

	private static void displayAllSchedules(StudentInfo student) {
		System.out.println("\n=== All Schedules ===");
		for (Schedule schedule : student.getSchedules()) {
			displayScheduleForDay(schedule);
		}
	}

	private static void displayTaskDetails(Task task) {
		if (task == null || task.getDescription() == null || task.getDescription().isEmpty()) {
			System.out.println("No task details available (or task is empty).");
			return;
		}
		System.out.println("Task type: " + task.getTaskType());
		System.out.println("Task description: " + task.getDescription());
		System.out.println("Due date: " + task.getDueDate());
		System.out.println("Completion: " + (task.isComplete() ? "Done" : "Not done"));
	}

	private static void displayAllTasks(TodoList todoList) {
		if (todoList.isEmpty()) {
			System.out.println("No tasks in the list.");
		} else {
			for (int i = 0; i < todoList.size(); i++) {
				System.out.println("--- Task " + (i + 1) + " ---");
				displayTaskDetails(todoList.getTask(i));
				System.out.println("--------------------");
			}
		}
	}

	private static void displayTaskTypes() {
		ArrayList<String> types = (ArrayList<String>) TaskType.getAllTypes();
		if (types.isEmpty()) {
			System.out.println("No task types available.");
		} else {
			System.out.println("Current Task Types:");
			for (int i = 0; i < types.size(); i++) {
				System.out.println(i + ": " + types.get(i));
			}
		}
	}

	private static void displaySemesterGPAs(CGPA gpa) {
		if (gpa.getCurrentSemester() == 0) {
			System.out.println("No semester GPA records found.");
			return;
		}
		System.out.println("\nSemester GPA Records:");
		for (int i = 0; i < gpa.getCurrentSemester(); i++) {
			System.out.printf("Semester %d: %.2f%n", (i + 1), gpa.getSemesterGPAs()[i]);
		}
	}

	private static void displayOverallCGPA(double cgpa) {
		if (cgpa == 0.0) {
			System.out.println("No CGPA data available to calculate.");
			return;
		}
		System.out.printf("\nCurrent CGPA: %.2f%n", cgpa);
	}

	private static void displayTaskStatus(Task task) {
		String statusMessage = Reminder.checkTaskStatus(task);
		System.out.println(statusMessage);
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
				displaySemesterGPAs(gpa);
				break;
			case 3:
				double overallCGPA = gpa.calcCGPA();
				displayOverallCGPA(overallCGPA);
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
				if (TaskType.getAllTypes().isEmpty()) {
					System.out.println("No task types defined. Please create task types first (option 5).");
				} else if (todoList.size() >= 5) {
					System.out.println("Task list is full. Please complete or delete tasks.");
				} else {
					Task task = Task.createTask(scanner);
					if (task != null) {
						todoList.addTask(task);
					} else {
						System.out.println("Failed to create task.");
					}
				}
				break;
			case 2:
				if (todoList.isEmpty()) {
					System.out.println("No tasks to delete.");
				} else {
					System.out.println("Enter task number to delete:");
					for (int i = 0; i < todoList.size(); i++) {
						System.out.println(i + " - " + todoList.getTask(i).getDescription());
					}
					int deleteIndex = readInt(scanner);
					if (deleteIndex >= 0 && deleteIndex < todoList.size()) {
						todoList.removeTask(deleteIndex);
						System.out.println("Task deleted.");
					} else {
						System.out.println("Invalid task number.");
					}
				}
				break;
			case 3:
				if (todoList.isEmpty()) {
					System.out.println("No tasks to check.");
				} else {
					System.out.println("Enter task number to check:");
					for (int i = 0; i < todoList.size(); i++) {
						System.out.println(i + " - " + todoList.getTask(i).getDescription());
					}
					int checkIndex = readInt(scanner);
					if (checkIndex >= 0 && checkIndex < todoList.size()) {
						displayTaskStatus(todoList.getTask(checkIndex));
					} else {
						System.out.println("Invalid task number.");
					}
				}
				break;
			case 4:
				displayAllTasks(todoList);
				break;
			case 5:
				manageTaskTypes(scanner);
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
					Subject subject = Subject.createSubject(scanner);

					System.out.print("Enter start time (HH:MM): ");
					LocalTime start = LocalTime.parse(scanner.nextLine());
					System.out.print("Enter end time (HH:MM): ");
					LocalTime end = LocalTime.parse(scanner.nextLine());
					schedule.addScheduleEntry(new ScheduleEntry(subject, start, end));
					System.out.println("Class added successfully.");
				} else {
					System.out.println("Invalid day.");
				}
				break;
			case 2:
				String dayToDelete = readDayOfWeek(scanner);
				Schedule scheduleToDelete = student.getScheduleByDay(dayToDelete);
				if (scheduleToDelete != null) {
					if (scheduleToDelete.getEntries().isEmpty()) {
						System.out.println("No classes to delete on " + dayToDelete + ".");
					} else {
						System.out.println("Classes for " + dayToDelete + ":");
						for (int i = 0; i < scheduleToDelete.getEntries().size(); i++) {
							System.out.println(
									i + " - " + scheduleToDelete.getEntries().get(i).getSubject().getSubjectName());
						}
						System.out.print("Enter class number to remove: ");
						int index = readInt(scanner);
						scheduleToDelete.removeEntryAt(index);
						System.out.println("Class removed successfully.");
					}
				} else {
					System.out.println("Invalid day.");
				}
				break;
			case 3:
				System.out.print("Enter day (e.g., Monday) or 'all': ");
				String inputDay = scanner.nextLine();
				if (inputDay.equalsIgnoreCase("all")) {
					displayAllSchedules(student);
				} else {
					Schedule s = student.getScheduleByDay(inputDay);
					displayScheduleForDay(s);
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid option.");
			}
		}
	}

	public static int readInt(Scanner scanner) {
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
