package collectionsPkg;

import java.util.*;
import java.io.*;

/**
 * Creates or finds a contact list .txt file and allows modifications to be made
 * to the contact list
 * 
 * @author Wesley Chan
 *
 */
public class ContactListDriver {

	// Scanner object outside of main method since other methods can utilize
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		// Prompt user for the contact list file name
		System.out.print("Please enter contact list file name: ");
		String fileName = input.nextLine();

		// Check if .txt extension is used
		if (!fileName.substring(fileName.length() - 4, fileName.length()).equals(".txt")) {
			fileName = fileName.concat(".txt");
		}

		// Try to create or find the file of specified name
		try {
			File f = new File(fileName);

			if (f.createNewFile()) {
				System.out.println("A new Contact List called " + fileName + " has been created.");
			} else {
				System.out.println("A Contact List called " + fileName + " has been found.");

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		// Prompt user to make choice of modifications to the list
		try {
			ContactList contactListOb = new ContactList(fileName);

			String choice = new String();

			// Loop until user decides to quit and save changes
			while (!choice.equals("Q")) {
				System.out.println("\nMenu: ");
				System.out.println("Enter (A) to add a contact.");
				System.out.println("Enter (D) to delete a contact.");
				System.out.println("Enter (P) to display the contact list.");
				System.out.println("Enter (Q) to quit and save any changes.");

				// Prompt user for choice
				System.out.print("Enter Choice: ");

				choice = input.nextLine();

				// Perform modification based on user's input
				switch (choice) {
					case "A":
					case "a":
						Contact newContact = new Contact(createNewContact());
						contactListOb.addContact(newContact);
						break;
					case "D":
					case "d":
						System.out.print("\nEnter full name of contact to delete: ");
						contactListOb.removeContact(input.nextLine());
						break;
					case "P":
					case "p":
						System.out.println();
						contactListOb.displayContactList();
						break;
					case "Q":
					case "q":
						choice = "Q";
						break;
					default:
						System.out.print("Please select a valid option.");
				}
			}

			// Writes any changes to contact list to the specified file
			contactListOb.writeContactList();
			System.out.println("\nChanges have been saved to " + fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}

		input.close(); // close out scanner
	}

	/**
	 * Creates a new contact based on user input
	 * 
	 * @return c Contact with details specified by user
	 */
	public static Contact createNewContact() {

		Contact c = new Contact();

		System.out.print("\nEnter full name of contact: ");

		String[] fullName = input.nextLine().split(" ");
		c.setFirstName(fullName[0]);
		c.setLastName(fullName[1]);

		System.out.print("Enter phone number of contact: ");
		c.setPhoneNum(input.nextLong());
		input.nextLine();

		System.out.print("Enter email address of contact: ");
		c.setEmail(input.nextLine());

		return c;
	}
}
