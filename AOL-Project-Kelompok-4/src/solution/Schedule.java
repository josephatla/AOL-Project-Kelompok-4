package solution;

import java.util.ArrayList;

public class Schedule {
	private String day;
	private ArrayList<ScheduleEntry> entries = new ArrayList<>();

	public Schedule(String day) {
		this.day = day;
		this.entries = new ArrayList<>();
	}

	public String getDay() {
		return day;
	}

	public ArrayList<ScheduleEntry> getEntries() {
		return entries;
	}

	public void addScheduleEntry(ScheduleEntry entry) {
		entries.add(entry);
	}

	public void removeEntryAt(int index) {
		entries.remove(index);
	}

}
