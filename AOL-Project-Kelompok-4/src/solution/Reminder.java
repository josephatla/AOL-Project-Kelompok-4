package solution;

import java.time.LocalDate;

public class Reminder {
	public static void checkTaskStatus(Task task) {
		LocalDate now = LocalDate.now();
		LocalDate dueDate = task.getDueDate();
		int compareResult = now.compareTo(dueDate);

		if (compareResult == 0) {
			System.out.println("The Duedate is TODAY!");
		} else if (compareResult > 0) {
			System.out.println("Your Task is OVERDUE! On " + task.getDueDate());
		} else if (compareResult < 0) {
			System.out.println("You have upcoming duedate! On " + task.getDueDate());
		}
	}
}