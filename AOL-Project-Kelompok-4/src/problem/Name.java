package problem;

/*
 * Smell Code: Data Class
 * Reason: Function createname() dan displayName() bisa dilakukan dengan getter dan setter
 * Solution: Use Getter, Use Setter, Remove Redundant Methods
 * 
 * Smell Code: Deficient Encapsulation
 * Reason: Adanya private attribute dan setter
 * Solution: Remove Setter, Make Field Final, Encapsulate Field
 * 
 * Smell Code: Leaky Encapsulation
 * Reason: Adanya displayName() dan getter
 * Solution: Hide Internal Data, Limit Getter Exposure, Use Read-Only Access
*/

import java.util.Scanner;

public class Name {
	private String fName;
	private String mName;
	private String lName;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void createname() {
		Scanner scanner = new Scanner(System.in);
		String userInput;

		// Prompt the user for the values of the attributes
		System.out.print("Enter first name: ");
		userInput = scanner.nextLine();
		setfName(userInput);

		System.out.print("Enter the middle name: ");
		userInput = scanner.nextLine();
		setmName(userInput);

		System.out.print("Enter the last name: ");
		userInput = scanner.nextLine();
		setlName(userInput);

		scanner.close();

		System.out.println("Values set successfully.");
	}

	public void displayName() {
		System.out.println("Mame: " + this.getfName() + " " + this.mName + " " + this.lName);
	}

	public static void main(String[] args) {
		Name test = new Name();
		test.createname();
		test.displayName();

	}

}
