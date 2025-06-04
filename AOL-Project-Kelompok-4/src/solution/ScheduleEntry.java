package solution;

import java.time.LocalTime;

public class ScheduleEntry {
    private Subject subject;
    private LocalTime startTime;
    private LocalTime endTime;

    public ScheduleEntry(Subject subject, LocalTime startTime, LocalTime endTime) {
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Subject getSubject() {
        return subject;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
