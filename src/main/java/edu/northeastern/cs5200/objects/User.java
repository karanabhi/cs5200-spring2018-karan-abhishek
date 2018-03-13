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
	
	@Override
	public String toString() {
		return "ID:"+id+"\tUser Agreement:"+userAgreement+"\tPersonId:"+person.getId()
				+"\tUser Key:"+userKey +"\n";
				
	}	

	public User(int id,Person person,int userAgreement, String userKey) {	
		this.id=id;
		this.person=person;
		this.userKey=userKey;
		this.userAgreement=userAgreement;
	}
	
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

}
