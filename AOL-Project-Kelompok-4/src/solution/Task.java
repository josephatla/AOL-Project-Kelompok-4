package solution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Task {
	private static ArrayList<String> taskTypes = new ArrayList<>();

	private String description;
	private LocalDate dueDate;
	private boolean complete;
	private String taskType;

	public static ArrayList<String> getTaskTypes() {
	    return new ArrayList<>(taskTypes);
	}

	public static String getTaskType(int index) {
		return taskTypes.get(index);
	}

	public static void addTaskType(String type) {
		taskTypes.add(type);
	}

	public static void removeTaskType(int index) {
		taskTypes.remove(index);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(int year, int month, int dayMonth) {
		this.dueDate = LocalDate.of(year, month, dayMonth);
	}

	public boolean getComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String getTaskTypeValue() {
		return this.taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public void createTask(Scanner scanner) {
		if (taskTypes.isEmpty()) {
			System.out.println("No task types available. Please create task types first.");
			return;
		}

		System.out.println("Task types:");
		for (int i = 0; i < taskTypes.size(); i++) {
			System.out.println(i + ": " + taskTypes.get(i));
		}
		System.out.print("Enter task type index: ");
		int typeIndex = scanner.nextInt();
		if (typeIndex < 0 || typeIndex >= taskTypes.size()) {
			System.out.println("Invalid task type index.");
			return;
		}
		this.setTaskType(taskTypes.get(typeIndex));

		scanner.nextLine(); 
		System.out.print("Enter the task description: ");
		String userInput = scanner.nextLine();
		this.setDescription(userInput);

		System.out.print("Enter due date (yyyy mm dd): ");
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int day = scanner.nextInt();
		this.setDueDate(year, month, day);

		System.out.print("Is the task complete? (true/false): ");
		userInput = scanner.next();
		this.setComplete(Boolean.parseBoolean(userInput));

		System.out.println("Task created successfully.");
	}


	public void displayTask() {
		System.out.println("Task type: " + this.getTaskTypeValue());
		System.out.println("Task description: " + this.getDescription());
		System.out.println("Due date: " + this.getDueDate());
		System.out.println("Completion: " + (this.complete ? "Done" : "Not done"));
	}

	public static void manageTaskTypes() {
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("Choose an option:");
			System.out.println("1. Add task type");
			System.out.println("2. Remove task type");
			System.out.println("3. View task types");
			System.out.println("4. Return");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter task type: ");
				scanner.nextLine();
				String type = scanner.nextLine();
				addTaskType(type);
				System.out.println(type + " added.");
				break;
			case 2:
				System.out.print("Enter task type index: ");
				int index = scanner.nextInt();
				removeTaskType(index);
				System.out.println("Task type removed.");
				break;
			case 3:
				System.out.println("Task types:");
				for (int i = 0; i < taskTypes.size(); i++) {
					System.out.println(i + ": " + taskTypes.get(i));
				}
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
}
