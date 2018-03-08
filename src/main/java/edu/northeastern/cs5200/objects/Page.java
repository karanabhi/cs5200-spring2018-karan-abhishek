/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class Page {

private int id,views;
private Website website;
private String name,description,created,updated,title;	

@Override
public String toString() {
	return "ID:"+id+"\tViews:"+views+"\tName:"+name
			+"\tDescription:"+description+"\tCreated:"+created
			+"\tUpdated:"+updated+"\tTitle:"+title+"\tWebsite Id:"+website.getId()+"\n";	
}

public Page(int id,Website website,String name, String description, String created,String updated, int views, String title) {
	this.id=id;
	this.views=views;
	this.name=name;
	this.description=description;
	this.created=created;
	this.updated=updated;
	this.title=title;
	this.website=website;
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
 * @return the views
 */
public int getViews() {
	return views;
}




/**
 * @param views the views to set
 */
public void setViews(int views) {
	this.views = views;
}




/**
 * @return the website
 */
public Website getWebsite() {
	return website;
}




/**
 * @param website the website to set
 */
public void setWebsite(Website website) {
	this.website = website;
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




/**
 * @return the title
 */
public String getTitle() {
	return title;
}




/**
 * @param title the title to set
 */
public void setTitle(String title) {
	this.title = title;
}
	
}
