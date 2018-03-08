/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class Website {

	private int id,visits;
	private String name,description,created,updated;
	private Developer developer;
	
	@Override
	public String toString() {
		return "ID:"+id+"\tVisits:"+visits+"\tName:"+name
				+"\tDescription:"+description+"\tCreated:"+created
				+"\tUpdated:"+updated+"\tDeveloper ID:"+developer.getId()+"\n";	
	}	
	
	public Website(int id,String name, String description,String created, String updated,int visits,Developer developer) {	
		this.id=id;
		this.name=name;
		this.description=description;
		this.created=created;
		this.updated=updated;
		this.visits=visits;
		this.developer=developer;
	}		

	/**
	 * @return the developer
	 */
	public Developer getDeveloper() {
		return developer;
	}

	/**
	 * @param developer the developer to set
	 */
	public void setDeveloper(Developer developer) {
		this.developer = developer;
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
	 * @return the visits
	 */
	public int getVisits() {
		return visits;
	}

	/**
	 * @param visits the visits to set
	 */
	public void setVisits(int visits) {
		this.visits = visits;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}
}
