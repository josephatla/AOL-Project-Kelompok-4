package solution;

import java.util.Scanner;

public class Subject {
    private String subjectName;
    private String description;
    private Lecturer lecturer;
    private String venue;
    private int creditHr;

    public Subject(String subjectName, String description, Lecturer lecturer, String venue, int creditHr) {
        this.subjectName = subjectName;
        this.description = description;
        this.lecturer = lecturer;
        this.venue = venue;
        this.creditHr = creditHr;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getCreditHr() {
        return creditHr;
    }

    public void setCreditHr(int creditHr) {
        this.creditHr = creditHr;
    }

    public void createSubject(Lecturer lec) {
        System.out.println("----------------Subject's Details----------------");
        Scanner scanner = new Scanner(System.in);
        setLecturer(lec);
        System.out.print("Subject Name: ");
        String subjectName = scanner.nextLine();
        setSubjectName(subjectName);
        System.out.print("Subject Description: ");
        String description = scanner.nextLine();
        setDescription(description);
        lec.createLecturer();
        System.out.print("\nVenue: ");
        String venue = scanner.nextLine();
        setVenue(venue);
        System.out.print("Credit Hour: ");
        int creditHr = scanner.nextInt();
        setCreditHr(creditHr);
        System.out.println("Subject's details created successfully.\n");
    }

    public void displaySubject() {
        System.out.println("Subject: " + getSubjectName());
        System.out.println("Description: " + getDescription());
        System.out.println("\nLecturer's information: ");
        this.getLecturer().displayLecturer();
        System.out.println("\nVenue: " + getVenue());
        System.out.println("Credit Hour: " + getCreditHr());
        System.out.println("\n");
    }
}
