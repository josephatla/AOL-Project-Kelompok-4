package solution;

import java.util.ArrayList;
import java.util.List;

public class TaskType {
	private static ArrayList<String> types = new ArrayList<>();

	public static List<String> getAllTypes() {
		return new ArrayList<>(types);
	}

	public static String getTypeByIndex(int index) {
		if (index >= 0 && index < types.size()) {
			return types.get(index);
		}
		return "Unknown";
	}

	public static void addType(String type) {
		types.add(type);
	}

	public static void removeType(int index) {
		if (index >= 0 && index < types.size()) {
			types.remove(index);
		} else {
			System.out.println("Invalid task type index to remove.");
		}
	}
}
