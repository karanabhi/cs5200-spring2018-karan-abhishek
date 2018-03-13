/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class Address {

	private int id,primary;
	private Person person;
	private String street1, street2, city, state, zip;
	
	@Override
	public String toString() {
		return "ID:"+id+"\tStreet1:"+street1+"\tStreet2:"+street2
				+"\tCity:"+city+"\tState:"+state
				+"\tZip:"+zip+"\tPrimary:"+primary
				+"\tPersonID:"+person.getId() +"\n";	
	}	

	public Address(int id,Person person,String street1,String street2,String city,String state,String zip,int primary) {	
		this.id=id;
		this.person=person;
		this.primary=primary;
		this.street1=street1;
		this.street2=street2;
		this.city=city;
		this.state=state;
		this.zip=zip;
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
	 * @return the street1
	 */
	public String getStreet1() {
		return street1;
	}
	/**
	 * @param street1 the street1 to set
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	/**
	 * @return the street2
	 */
	public String getStreet2() {
		return street2;
	}
	/**
	 * @param street2 the street2 to set
	 */
	public void setStree2(String street2) {
		this.street2 = street2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

}
