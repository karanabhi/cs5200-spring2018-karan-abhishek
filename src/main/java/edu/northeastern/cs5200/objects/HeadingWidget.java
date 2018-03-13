/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class HeadingWidget {

	private int id,size;
	private Widget widget;
		
	@Override
	public String toString() {
		return "ID:"+id+"\tSize:"+size+"\tWidgetID:"+widget.getId()+"\n";	
	}

	public HeadingWidget(int id,int size,Widget widget) {
		this.id=id;
		this.size=size;
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
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
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

}
