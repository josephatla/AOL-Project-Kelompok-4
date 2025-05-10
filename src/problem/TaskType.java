package problem;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskType {
	private static ArrayList<String> type;

	public TaskType() {
		type = new ArrayList<>();
	}

	public static ArrayList<String> getType() {
		return type;
	}

	public static String getTypeindi(int index) {
		return type.get(index);
	}

	public void removeType(int index) {
		type.remove(index);
	}

	public void addType(String type1) {
		type.add(type1);
	}

	// to call TaskType.tasktype();
	public void tasktype() {
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop == true) {
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
				this.addType(type);
				System.out.println(type + " added.");
				break;
			case 2:
				System.out.print("Enter task type index: ");
				int index = scanner.nextInt();
				this.removeType(index);
				System.out.println("Task type removed.");
				break;
			case 3:
				System.out.println("Task types:");
				for (int i = 0; i < TaskType.type.size(); i++) {
					System.out.println(i + ": " + TaskType.type.get(i));
				}
				break;
			case 4:
				System.out.println("Returning...");
				loop = false;
				break;
			default:
				System.out.println("Invalid choice. Try again.");
				break;
			}

		}
	}
}
