package solution;

import java.time.LocalDate;

public class Reminder {
	public static String checkTaskStatus(Task task) {
		LocalDate now = LocalDate.now();
		LocalDate dueDate = task.getDueDate();
		int compareResult = now.compareTo(dueDate);

		if (compareResult == 0) {
			return ("The Duedate is TODAY!");
		} else if (compareResult > 0) {
			return ("Your Task is OVERDUE! On " + task.getDueDate());
		} else if (compareResult < 0) {
			return ("You have upcoming duedate! On " + task.getDueDate());
		}
		return null;
	}
}