/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class Widget {

	private int id,	width,height,order;
	private Page page;
	private String name,cssClass,cssStyle,text;	
	
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
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}


	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}


	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}


	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}


	/**
	 * @return the page
	 */
	public Page getPage() {
		return page;
	}


	/**
	 * @param page the page to set
	 */
	public void setPage(Page page) {
		this.page = page;
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
	 * @return the cssClass
	 */
	public String getCssClass() {
		return cssClass;
	}


	/**
	 * @param cssClass the cssClass to set
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}


	/**
	 * @return the cssStyle
	 */
	public String getCssStyle() {
		return cssStyle;
	}


	/**
	 * @param cssStyle the cssStyle to set
	 */
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}


	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}


	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}


	public Widget() {
		// TODO Auto-generated constructor stub
	}

}
