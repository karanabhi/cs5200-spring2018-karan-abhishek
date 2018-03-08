/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class HtmlWidget {

	private int id;
	private Widget widget;
	private String html;	
	
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
	 * @return the widget
	 */
	public Widget getWidget() {
		return widget;
	}


	/**
	 * @param widget the widget to set
	 */
	public void setWidget(Widget widget) {
		this.widget = widget;
	}


	/**
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}


	/**
	 * @param html the html to set
	 */
	public void setHtml(String html) {
		this.html = html;
	}


	public HtmlWidget() {
		// TODO Auto-generated constructor stub
	}

}
