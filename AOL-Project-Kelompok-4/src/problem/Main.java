package problem;

/*
* Smell Code: Long Method  
* Reason: Abstraksi terlalu besar dan terlalu banyak responsibility  
* Solution: Extract Method  
* 
* Smell Code: Duplicate Code  
* Reason: Terdapat kode yang digunakan berulang kali  
* Solution: Extract Method
* 
* Smell Code: Switch Statements  
* Reason: Terdapat if else statement yang terlalu panjang/kompleks  
* Solution: Extract Method  
* 
* Smell Code: Comments  
* Reason: Terdapat comment yang tidak dibutuhkan  
* Solution: Remove Comments
* 
* Smell Code: Message Chain  
* Reason: Terdapat kode yang memanggil terlalu banyak function untuk melakukan sebuah tujuan  
* Solution: Extract Method  
* 
* Smell Code: Insufficient Modularization  
* Reason: Abstraksi terlalu besar dan terlalu banyak responsibility  
* Solution: Extract Class  
* 
* Smell Code: Feature Envy  
* Reason: Terlalu banyak memanipulasi data internal objek lain (misalnya, student.getGpa().add())  
* Solution: Extract Method  
* 
* Smell Code: Missing Encapsulation  
* Reason: Memanipulasi data internal objek lain secara langsung tanpa melalui antarmuka yang terkapsulasi dengan baik  
* Solution: Encapsulate Field
*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Initialize class

		Scanner scanner = new Scanner(System.in);

		StudentInfo student = new StudentInfo();

		to_do_list todoList = new to_do_list();
		Task task1 = new Task();
		Task task2 = new Task();
		Task task3 = new Task();
		Task task4 = new Task();
		Task task5 = new Task();
		TaskType typelist = new TaskType();
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);
		todoList.addTask(task4);
		todoList.addTask(task5);

		SetSchedule monday = new SetSchedule();
		Subject subject1m = new Subject();
		Lecturer lec1m = new Lecturer();

		SetSchedule tuesday = new SetSchedule();
		Subject subject1t = new Subject();
		Lecturer lec1t = new Lecturer();

		SetSchedule wednesday = new SetSchedule();
		Subject subject1w = new Subject();
		Lecturer lec1w = new Lecturer();

		SetSchedule thursday = new SetSchedule();
		Subject subject1th = new Subject();
		Lecturer lec1th = new Lecturer();

		SetSchedule friday = new SetSchedule();
		Subject subject1f = new Subject();
		Lecturer lec1f = new Lecturer();

		SetSchedule saturday = new SetSchedule();
		Subject subject1st = new Subject();
		Lecturer lec1st = new Lecturer();

		SetSchedule sunday = new SetSchedule();
		Subject subject1S = new Subject();
		Lecturer lec1S = new Lecturer();

		CGPA semester = new CGPA();
		ListOfCGPA User = new ListOfCGPA();

		student.setGpa(semester);
		student.setCgpa(User);
		student.AddSchedule(monday);
		student.AddSchedule(tuesday);
		student.AddSchedule(wednesday);
		student.AddSchedule(thursday);
		student.AddSchedule(friday);
		student.AddSchedule(saturday);
		student.AddSchedule(sunday);
		student.setToDoList(todoList);

		// start of interface

		System.out.println("First Name:");
		String firstName = scanner.nextLine();
		student.setfName(firstName);
		System.out.println("Middle Name:");
		String middName = scanner.nextLine();
		student.setmName(middName);
		System.out.println("Last Name:");
		String lastName = scanner.nextLine();
		student.setlName(lastName);
		System.out.println("Student ID:");
		String ID = scanner.nextLine();
		student.setStudentID(ID);

		for (int i = 0; i < 4;) { // 1st layer interface
			System.out.println("Enter Options:");
			System.out.println("1 - CGPA");
			System.out.println("2 - Task");
			System.out.println("3 - Schedule");
			System.out.println("4 - exit");
			int currtask = 0;
			i = scanner.nextInt();

			if (i == 1) { // for CGPA
				boolean calcgPa = true;
				int index = 0;
				while (calcgPa == true) {
					System.out.println("1 - Calculate GPA\n2 - Display GPA\n3 - Calculate CGPA \n4 - Return");
					System.out.println("Enter Option: ");
					int choiceGpa = scanner.nextInt();
					switch (choiceGpa) {
					case 1:
						System.out.print("What semester do you wish to calculate your gpa? ");
						index = scanner.nextInt();
						semester.add(semester.calcGPA(), (index - 1));
						break;
					case 2:
						student.getGpa().displayGPA();
						break;
					case 3:
						System.out.println("CGPA: " + student.getCgpa().calcCGPA());
						break;
					case 4:
						System.out.println("Returning...");
						calcgPa = false;
						break;
					default:
						System.out.println("Invalid choice. Try again.");
						break;
					}

				}
			} else if (i == 2) { // for the to do list function
				for (int k = 0; k < 6;) {

					System.out.println(
							"Enter Option:\n1 - Create Task\n2 - Delete Task\n3 -  Check Task\n4 - Display Tasks\n5 - Edit Task Type\n6 - Return\n");

					k = scanner.nextInt();

					if (k == 1) {
						if (currtask > 4) {
							System.out.println("\nList is full please complete and remove a task.");
							k = 2;
						} else {
							if (TaskType.getType().size() == 0) {
								System.out.println("No task type has been created. Go to Edit Task.");

							} else {
								todoList.getTaskindi(currtask).createTask();
								currtask++;
							}
							k = 0;
						}
					} else if (k == 2) {
						if (currtask == 0) {
							System.out.println("\nNo task created, returning...\n");
							k = 0;
						} else {
							for (int i1 = 0; i1 < currtask; i1++) {
								System.out.println(i1 + " - " + todoList.getTaskindi(i1).getDescription());
							}
							System.out.println("Enter number:");
							int removal = scanner.nextInt();
							todoList.removeTask(removal);
							currtask--;
						}
					} else if (k == 3) {
						if (currtask == 0) {
							System.out.println("\nNo task created, returning...\n");
							k = 0;
						} else {
							for (int i1 = 0; i1 < currtask; i1++) {
								System.out.println(i1 + " - " + todoList.getTaskindi(i1).getDescription());
							}
							System.out.println("Enter task number:");
							int taskNumber = scanner.nextInt();
							if (todoList.getTaskindi(taskNumber).getComplete()) {
								System.out.println("The task has been completed.\n");
							} else {
								Reminder.checkTaskStatus(todoList.getTaskindi(taskNumber));
								System.out.println("\n");
							}
						}
					} else if (k == 4) {
						if (currtask == 0) {
							System.out.println("\nNo task created, returning...\n");
							k = 0;
						} else {
							for (int i1 = 0; i1 < TaskType.getType().size(); i1++) {
								System.out.println("No. " + i1 + " - " + TaskType.getTypeindi(i1));
							}
							System.out.println("Enter choice of task type:");
							int choice = scanner.nextInt();
							for (int o = 0; o < currtask; o++) {
								if (TaskType.getTypeindi(choice).equals(todoList.list.get(o).gettaskType())) {
									todoList.list.get(o).displayTask();
									System.out.println("\n");

								}
							}
						}
					} else if (k == 5) {
						scanner.nextLine();
						typelist.tasktype();
					} else {
						k = 6;
					}

				}
			} else if (i == 3) {

				boolean schedule = true;
				while (schedule == true) {
					System.out
							.println("1 - Add class to schedule\n2 - Delete class\n3 - Display schedule\n4 - return ");
					System.out.println("Enter option: ");
					int input = scanner.nextInt();
					switch (input) {
					case 1:
						System.out.println("Choose day of the week: ");
						System.out.println(
								"1 - Monday\n2 - Tuesday\n3 - Wednesday\n4 - Thursday\n5 - Friday\n6 - Saturday\n7 - Sunday");
						int dayOfweek = scanner.nextInt();
						if (dayOfweek == 1) {
							monday.createSchedule(subject1m, lec1m);
						} else if (dayOfweek == 2) {
							tuesday.createSchedule(subject1t, lec1t);
						} else if (dayOfweek == 3) {
							wednesday.createSchedule(subject1w, lec1w);
						} else if (dayOfweek == 4) {
							thursday.createSchedule(subject1th, lec1th);
						} else if (dayOfweek == 5) {
							friday.createSchedule(subject1f, lec1f);
						} else if (dayOfweek == 6) {
							saturday.createSchedule(subject1st, lec1st);
						} else if (dayOfweek == 7) {
							sunday.createSchedule(subject1S, lec1S);
						} else {
							System.out.println("Invalide input, returning...");
						}
						break;
					case 2:
						System.out.println("Choose day of the week: ");
						System.out.println(
								"1 - Monday\n2 - Tuesday\n3 - Wednesday\n4 - Thursday\n5 - Friday\n6 - Saturday\n7 - Sunday");
						int delete = scanner.nextInt();
						if (delete == 1) {
							if (monday.getSubject().size() == 0) {
								System.out.println("No class to be deleted.");
							} else {
								for (int sub = 0; sub < monday.getSubject().size(); sub++) {
									System.out.println(sub + " - " + monday.getSubjectindi(sub).getSubjectName());
								}
								System.out.println("Enter Subject Index: ");
								int subjectint = scanner.nextInt();
								monday.getSubject().remove(subjectint);
							}
						} else if (delete == 2) {
							if (tuesday.getSubject().size() == 0) {
								System.out.println("No class to be deleted.");
							} else {
								for (int sub = 0; sub < tuesday.getSubject().size(); sub++) {
									System.out.println(sub + " - " + tuesday.getSubjectindi(sub).getSubjectName());
								}
								System.out.println("Enter Subject Index: ");
								int subjectint = scanner.nextInt();
								tuesday.getSubject().remove(subjectint);
							}
						} else if (delete == 3) {
							if (wednesday.getSubject().size() == 0) {
								System.out.println("No class to be deleted.");
							} else {
								for (int sub = 0; sub < wednesday.getSubject().size(); sub++) {
									System.out.println(sub + " - " + wednesday.getSubjectindi(sub).getSubjectName());
								}
								System.out.println("Enter Subject Index: ");
								int subjectint = scanner.nextInt();
								wednesday.getSubject().remove(subjectint);
							}
						} else if (delete == 4) {
							if (thursday.getSubject().size() == 0) {
								System.out.println("No class to be deleted.");
							} else {
								for (int sub = 0; sub < thursday.getSubject().size(); sub++) {
									System.out.println(sub + " - " + thursday.getSubjectindi(sub).getSubjectName());
								}
								System.out.println("Enter Subject Index: ");
								int subjectint = scanner.nextInt();
								thursday.getSubject().remove(subjectint);
							}
						} else if (delete == 5) {
							if (friday.getSubject().size() == 0) {
								System.out.println("No class to be deleted.");
							} else {
								for (int sub = 0; sub < friday.getSubject().size(); sub++) {
									System.out.println(sub + " - " + friday.getSubjectindi(sub).getSubjectName());
								}
								System.out.println("Enter Subject Index: ");
								int subjectint = scanner.nextInt();
								friday.getSubject().remove(subjectint);
							}
						} else if (delete == 6) {
							if (saturday.getSubject().size() == 0) {
								System.out.println("No class to be deleted.");
							} else {
								for (int sub = 0; sub < saturday.getSubject().size(); sub++) {
									System.out.println(sub + " - " + saturday.getSubjectindi(sub).getSubjectName());
								}
								System.out.println("Enter Subject Index: ");
								int subjectint = scanner.nextInt();
								saturday.getSubject().remove(subjectint);
							}
						} else if (delete == 7) {
							if (sunday.getSubject().size() == 0) {
								System.out.println("No class to be deleted.");
							} else {
								for (int sub = 0; sub < sunday.getSubject().size(); sub++) {
									System.out.println(sub + " - " + sunday.getSubjectindi(sub).getSubjectName());
								}
								System.out.println("Enter Subject Index: ");
								int subjectint = scanner.nextInt();
								sunday.getSubject().remove(subjectint);
							}
						} else {
							System.out.println("Invalide input, returning...");
						}
						break;
					case 3:
						System.out.println("Choose day of the week: ");
						System.out.println(
								"1 - Monday\n2 - Tuesday\n3 - Wednesday\n4 - Thursday\n5 - Friday\n6 - Saturday\n7 - Sunday");
						int displayday = scanner.nextInt();
						if (displayday == 1) {
							if (monday.getSubject().size() == 0) {
								System.out.println("No class.");
							} else {
								for (int p = 0; p < monday.getSubject().size(); p++) {
									monday.displaySchedule(monday.getSubjectindi(p), p);
								}
							}
						} else if (displayday == 2) {
							if (tuesday.getSubject().size() == 0) {
								System.out.println("No class.");
							} else {
								for (int p = 0; p < tuesday.getSubject().size(); p++) {
									tuesday.displaySchedule(tuesday.getSubjectindi(p), p);
								}
							}
						} else if (displayday == 3) {
							if (wednesday.getSubject().size() == 0) {
								System.out.println("No class.");
							} else {
								for (int p = 0; p < wednesday.getSubject().size(); p++) {
									wednesday.displaySchedule(wednesday.getSubjectindi(p), p);
								}
							}
						} else if (displayday == 4) {
							if (thursday.getSubject().size() == 0) {
								System.out.println("No class.");
							} else {
								for (int p = 0; p < thursday.getSubject().size(); p++) {
									thursday.displaySchedule(thursday.getSubjectindi(p), p);
								}
							}
						} else if (displayday == 5) {
							if (friday.getSubject().size() == 0) {
								System.out.println("No class.");
							} else {
								for (int p = 0; p < friday.getSubject().size(); p++) {
									friday.displaySchedule(friday.getSubjectindi(p), p);
								}
							}
						} else if (displayday == 6) {
							if (saturday.getSubject().size() == 0) {
								System.out.println("No class.");
							} else {
								for (int p = 0; p < saturday.getSubject().size(); p++) {
									saturday.displaySchedule(saturday.getSubjectindi(p), p);
								}
							}
						} else if (displayday == 7) {
							if (sunday.getSubject().size() == 0) {
								System.out.println("No class.");
							} else {
								for (int p = 0; p < sunday.getSubject().size(); p++) {
									sunday.displaySchedule(sunday.getSubjectindi(p), p);
								}
							}
						} else {
							System.out.println("Invalide input, returning...");
						}
						break;
					case 4:
						schedule = false;
						break;
					default:
						System.out.println("Invalid choice. Try again.");
						break;
					}

				}
			} else if (i == 4) {
				break;
			}

		}

	}
}