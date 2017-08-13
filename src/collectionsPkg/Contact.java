package collectionsPkg;

/**
 * Creates a Contact
 * 
 * @author Wesley Chan
 *
 */
public class Contact {

	private String firstName;
	private String lastName;
	private long phoneNum;
	private String email;

	/**
	 * Default constructor for Contact class.
	 */
	Contact() {
		firstName = new String();
		lastName = new String();
		phoneNum = 0;
	}

	/**
	 * Constructor with each field as an argument.
	 * 
	 * @param fn
	 *            contact's first name of type String.
	 * @param ln
	 *            contact's last name of type String.
	 * @param phone
	 *            contact's phone number of type long.
	 * @param em
	 *            contact's email of type String.
	 */
	Contact(String fn, String ln, long phone, String em) {
		firstName = fn;
		lastName = ln;
		phoneNum = phone;
		email = em;
	}

	/**
	 * Constructor used for imported contacts from a .txt file.
	 * 
	 * @param importedContact
	 *            String from a .txt file where the contact fields are separated
	 *            by "|".
	 */
	Contact(String importedContact) {
		// Each Contact field will be separated by "|" in regular expression
		String delimiter = "\\|";
		String[] splitContact = importedContact.split(delimiter);

		firstName = splitContact[0];
		lastName = splitContact[1];
		phoneNum = Long.parseLong(splitContact[2]);
		email = splitContact[3];
	}

	/**
	 * Copy Constructor for Contact class.
	 * 
	 * @param c
	 */
	Contact(Contact c) {
		firstName = c.getFirstName();
		lastName = c.getLastName();
		phoneNum = c.getPhoneNum();
		email = c.getEmail();
	}

	/**
	 * Gets the contact's first name.
	 * 
	 * @return contact's first name as a String.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the contact's last name.
	 * 
	 * @return contact's last name as a String.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the contact's phone number.
	 * 
	 * @return contact's phone number as a long.
	 */
	public long getPhoneNum() {
		return phoneNum;
	}

	/**
	 * Gets the contact's email.
	 * 
	 * @return contact's email as a String.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the contact's full name.
	 * 
	 * @return contact's first and last name as a String.
	 */
	public String getName() {
		return firstName + " " + lastName;
	}

	/**
	 * Sets the contact's first name.
	 * 
	 * @param fn
	 *            first name as a String.
	 */
	public void setFirstName(String fn) {
		firstName = fn;
	}

	/**
	 * Sets the contact's last name.
	 * 
	 * @param ln
	 *            last name as a String.
	 */
	public void setLastName(String ln) {
		lastName = ln;
	}

	/**
	 * Sets the contact's phone number.
	 * 
	 * @param ph
	 *            phone number as type long.
	 */
	public void setPhoneNum(long ph) {
		phoneNum = ph;
	}

	/**
	 * Sets the contact's email.
	 * 
	 * @param em
	 *            email as a String.
	 */
	public void setEmail(String em) {
		email = em;
	}

}
