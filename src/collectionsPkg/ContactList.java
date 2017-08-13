package collectionsPkg;

import java.io.*;
import java.util.*;

/**
 * Creates a List of Contacts
 * 
 * @author Wesley Chan
 *
 */
public class ContactList {

	private File contactListFile;
	private TreeMap<String, Contact> contactListMap;

	/**
	 * Constructor for ContactList that takes a String as an argument.
	 * 
	 * @param fileName
	 *            this is the the filename of the Contact List.
	 * @throws IOException
	 *             a file cannot be found/created.
	 */
	ContactList(String fileName) throws IOException {
		contactListFile = new File(fileName);
		contactListMap = new TreeMap<String, Contact>(new TComp());
		importContactList();
	}

	/**
	 * Returns the Contact List file.
	 * 
	 * @return contactListFile of type File.
	 */
	public File getContactListFile() {
		return contactListFile;
	}

	/**
	 * Returns all contacts in a TreeMap.
	 * 
	 * @return contactListMap of type TreeMap.
	 */
	public TreeMap<String, Contact> getContactListMap() {
		return contactListMap;
	}

	/**
	 * Puts all the contacts from the contactListFile into the TreeMap
	 * contactListMap.
	 * 
	 * @throws IOException
	 *             if a file cannot be found.
	 */
	private void importContactList() throws IOException {
		Contact c;

		FileReader fr = new FileReader(contactListFile);
		BufferedReader input = new BufferedReader(fr);

		String record;

		while ((record = input.readLine()) != null) {
			c = new Contact(record);
			contactListMap.put(c.getName(), c);
		}

		input.close();
	}

	/**
	 * Adds a contact to the contact list.
	 * 
	 * @param c
	 *            contact to be added to the list.
	 */
	public void addContact(Contact c) {
		contactListMap.put(c.getName(), c);
		System.out.println("Contact info. has been added to the list.");
	}

	/**
	 * Removes a contact from the contact list.
	 * 
	 * @param s
	 *            full name of the contact to be removed.
	 */
	public void removeContact(String s) {
		contactListMap.remove(s);
		System.out.println("Contact has been removed from the list.");
	}

	/**
	 * Displays all the contacts in the contact list.
	 */
	public void displayContactList() {
		displayHeader();
		for (Map.Entry<String, Contact> mapEntry : contactListMap.entrySet()) {
			System.out.println(mapEntry.getValue().getLastName() + "\t\t" + mapEntry.getValue().getFirstName()
					+ "\t\t\t" + mapEntry.getValue().getPhoneNum() + "\t" + mapEntry.getValue().getEmail());
		}
	}

	/**
	 * Displays the header for the contact list.
	 */
	private void displayHeader() {
		System.out.println("Last Name\tFirst Name\t\tPhone Number\tEmail Address");
	}

	/**
	 * Writes the contents of the contactListMap TreeMap to the file specified
	 * in contactListFile using "|" as a separator for the contact fields.
	 * 
	 * @throws IOException
	 *             if the file cannot be found.
	 */
	public void writeContactList() throws IOException {
		FileWriter outFile = new FileWriter(contactListFile.getName());
		PrintWriter printFile = new PrintWriter(outFile);

		for (Map.Entry<String, Contact> mapEntry : contactListMap.entrySet()) {
			printFile.println(mapEntry.getValue().getFirstName() + "|" + mapEntry.getValue().getLastName() + "|"
					+ mapEntry.getValue().getPhoneNum() + "|" + mapEntry.getValue().getEmail());
		}

		printFile.close();
	}

	/**
	 * Custom comparator class that sorts the keys in a TreeMap by the last name
	 * 
	 * @author Wesley
	 *
	 */
	private class TComp implements Comparator<String> {
		public int compare(String s1, String s2) {
			int i, j, k;

			// Find index of beginning of last name
			i = s1.lastIndexOf(' ');
			j = s2.lastIndexOf(' ');

			k = s1.substring(i).compareToIgnoreCase(s2.substring(j));

			if (k == 0) { // last names match, check entire name
				return s1.compareToIgnoreCase(s2);
			} else {
				return k;
			}
		}
	}
}
