/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class Developer {

	private int id;
	private Person person;
	private String developerKey;	
	
	@Override
	public String toString() {
		return "ID:"+id+"\tDeveloperKey:"+developerKey+"\tPersonId:"+person.getId()
				+"\tPersonFName:"+person.getFirstName()	+"\tPersonLName:"+person.getLastName()
				+"\tPersonEmail:"+person.getEmail()	+"\tPersonDOB:"+person.getDob()
				+"\tPersonUsername:"+person.getUsername() +"\tPersonPassword:"+person.getPassword()+"\n";	
	}	

	public Developer(int id,Person person,String developerKey) {	
		this.id=id;
		this.person=person;
		this.developerKey=developerKey;	
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
	 * @return the developerKey
	 */
	public String getDeveloperKey() {
		return developerKey;
	}


	/**
	 * @param developerKey the developerKey to set
	 */
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}	
	
}
