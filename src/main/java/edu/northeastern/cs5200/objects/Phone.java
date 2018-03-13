/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class Phone {

	private int id,primary;
	private Person person;
	private String phone;
	
	@Override
	public String toString() {
		return "ID:"+id+"\tPhone:"+phone+"\tPersonId:"+person.getId()+"\tPrimary:"+primary+"\n";	
	}

	public Phone(int id,Person person,String phone, int primary) {
		this.id=id;
		this.person=person;
		this.primary=primary;
		this.phone=phone;
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
	 * @return the primary
	 */
	public int getPrimary() {
		return primary;
	}
	/**
	 * @param primary the primary to set
	 */
	public void setPrimary(int primary) {
		this.primary = primary;
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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
