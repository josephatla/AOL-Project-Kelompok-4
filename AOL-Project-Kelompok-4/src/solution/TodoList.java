package solution;

import java.util.ArrayList;

public class TodoList {
	private ArrayList<Task> tasks = new ArrayList<>();

	public ArrayList<Task> getTasks() {
	    return new ArrayList<>(tasks);
	}

	public Task getTask(int i) {
		return this.tasks.get(i);
	}

	public void addTask(Task task) {
		this.tasks.add(task);
	}

	public void removeTask(int i) {
		this.tasks.remove(i);
	}

	public void editTask(Task task, int i) {
		this.tasks.set(i, task);
	}

	public int size() {
		return tasks.size();
	}

	public boolean isEmpty() {
		return tasks.isEmpty();
	}
}