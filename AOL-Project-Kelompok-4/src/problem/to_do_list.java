package problem;

/*
 * Smell Code: Deficient Encapsulation
 * Reason: Terdapat class yang bisa diakses dari class lain
 * Solution: Change Access Modifier
 * 
 * Smell Code: Comments
 * Reason: Terdapat comments
 * Solution: Remove Comments
 */


import java.util.ArrayList;
import java.util.Scanner;

public class to_do_list {
    ArrayList<Task> list = new ArrayList<Task>();

    public ArrayList<Task> getTask(){
    	return this.list;
    }
    
    public Task getTaskindi(int i){
        return this.list.get(i);
    }
    public void addTask(Task task){
        this.list.add(task);
    }
    public void removeTask(int i){
        this.list.remove(i);
    }
    public void editTask(Task task,int i){
        this.list.set(i,task);
    }
/*public static void main(String[] args) {
	
	Task task = new Task();
	to_do_list todoList = new to_do_list();
	for(int k=0;k<6;) {
		Scanner scanner = new Scanner(System.in);
		
	System.out.println("Enter Option:\n1 - Create Task\n2 - Delete Task\n3 -  Check Task\n4 - Display Tasks\n5 - Create Task Type\n6 - Return\n");
	
		
		 k = scanner.nextInt();
		
		
	
	
	if(k==1) {
		
		task.createTask();
		todoList.addTask(task);
		k=0;

		}
	else if(k==2) {
		for(int i=0;i<todoList.list.size();i++) {
		System.out.println(i +" - "+ todoList.getTask(i).getDescription());
		}
		System.out.println("Enter number:");
		int removal = scanner.nextInt();
		todoList.removeTask(removal);
	}
	else if(k==3) {
		for(int i=0;i<todoList.list.size();i++) {
			System.out.println(i +" - "+ todoList.getTask(i).getDescription());
			}
		System.out.println("Enter task number:");
		int taskNumber=scanner.nextInt();
		if(todoList.getTask(taskNumber).getComplete()) {
			System.out.println("The task has been completed.\n");
		}
		else {
		Reminder.checkTaskStatus(todoList.getTask(taskNumber));
		System.out.println("\n");
		}
	}
	else if(k==4) {
		for(int i=0;i<todoList.list.size();i++) {
			System.out.println("No. "+i);
			todoList.getTask(i).displayTask();
			System.out.println("\n");
			
		}
	}
	else if(k==5) {
		scanner.nextLine();
		System.out.println("Enter new task type:");
		String typeuserInput = scanner.nextLine();
		task.addType(typeuserInput);
	}
	else {
		k=6;
	}
    
   }
}*/}