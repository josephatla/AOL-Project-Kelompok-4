package solution;

import java.time.LocalDate;
import java.util.Scanner;

public class Task {
	private String description;
	private LocalDate dueDate;
	private boolean complete;
	private String taskType;

	public Task(String description, LocalDate dueDate, boolean complete, String taskType) {
		this.description = description;
		this.dueDate = dueDate;
		this.complete = complete;
		this.taskType = taskType;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public boolean isComplete() {
		return complete;
	}

	public String getTaskType() {
		return taskType;
	}

	public static Task createTask(Scanner scanner) {
		if (TaskType.getAllTypes().isEmpty()) {
			System.out.println("No task types available. Please create task types first.");
			return null;
		}

		System.out.println("Task types:");
		for (int i = 0; i < TaskType.getAllTypes().size(); i++) {
			System.out.println(i + ": " + TaskType.getAllTypes().get(i));
		}
		System.out.print("Enter task type index: ");
		int typeIndex = scanner.nextInt();
		scanner.nextLine();

		if (typeIndex < 0 || typeIndex >= TaskType.getAllTypes().size()) {
			System.out.println("Invalid task type index. Returning null task.");
			return null;
		}
		String selectedTaskType = TaskType.getTypeByIndex(typeIndex);

		System.out.print("Enter the task description: ");
		String description = scanner.nextLine();

		System.out.print("Enter due date (yyyy mm dd): ");
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int day = scanner.nextInt();
		LocalDate dueDate = LocalDate.of(year, month, day);

		scanner.nextLine();
		System.out.print("Is the task complete? (true/false): ");
		boolean complete = Boolean.parseBoolean(scanner.next());

		System.out.println("Task created successfully.");
		return new Task(description, dueDate, complete, selectedTaskType);
	}
}