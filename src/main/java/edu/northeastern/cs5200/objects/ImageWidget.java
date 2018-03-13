/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class ImageWidget {

	private int id;
	private Widget widget;
	private String src;	
	
	
	@Override
	public String toString() {
		return "ID:"+id+"\tSrc:"+src+"\tWidgetID:"+widget.getId()+"\n";	
	}

	public ImageWidget(int id,String src,Widget widget) {
		this.id=id;
		this.src=src;
		this.widget=widget;
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
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}



	/**
	 * @param src the src to set
	 */
	public void setSrc(String src) {
		this.src = src;
	}
}
