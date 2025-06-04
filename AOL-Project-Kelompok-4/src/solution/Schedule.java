package solution;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private String day;
    private ArrayList<ScheduleEntry> entries = new ArrayList<>();

    public Schedule(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void addScheduleEntry(ScheduleEntry entry) {
        entries.add(entry);
    }

    public void removeEntryAt(int index) {
        entries.remove(index);
    }

    public List<ScheduleEntry> getEntries() {
        return entries;
    }

    public void displaySchedule() {
        System.out.println("\n=== Schedule for " + day + " ===");
        if (entries.isEmpty()) {
            System.out.println("No classes scheduled.");
        } else {
            for (ScheduleEntry entry : entries) {
                entry.getSubject().displaySubject();
                System.out.println("Start Time: " + entry.getStartTime());
                System.out.println("End Time: " + entry.getEndTime());
                System.out.println("----------------------------------");
            }
        }
    }
}
