/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class User {

	private int id,userAgreement;
	private Person person;
	private String userKey;
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the userAgreement
	 */
	public int getUserAgreement() {
		return userAgreement;
	}



	/**
	 * @param userAgreement the userAgreement to set
	 */
	public void setUserAgreement(int userAgreement) {
		this.userAgreement = userAgreement;
	}



	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}



	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}



	/**
	 * @return the userKey
	 */
	public String getUserKey() {
		return userKey;
	}



	/**
	 * @param userKey the userKey to set
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}



	public User() {
		// TODO Auto-generated constructor stub
	}

}
