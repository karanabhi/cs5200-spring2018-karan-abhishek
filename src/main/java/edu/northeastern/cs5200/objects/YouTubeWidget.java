/**
 * 
 */
package edu.northeastern.cs5200.objects;

/**
 * @author Abhishek Karan
 *
 */
public class YouTubeWidget {
	
	private int id,expandable,sharable;
	private Widget widget;
	private String url;	
	
	@Override
	public String toString() {
		return "ID:"+id+"\tURL:"+url+"\tWidgetID:"+widget.getId()+"\tWxpandable"+expandable+"\tSharable"+sharable+"\n";	
	}

	public YouTubeWidget(int id,String url,Widget widget,int expandable,int sharable) {
		this.id=id;
		this.expandable=expandable;
		this.sharable=sharable;
		this.widget=widget;
		this.url=url;
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
	 * @return the expandable
	 */
	public int getExpandable() {
		return expandable;
	}



	/**
	 * @param expandable the expandable to set
	 */
	public void setExpandable(int expandable) {
		this.expandable = expandable;
	}



	/**
	 * @return the sharable
	 */
	public int getSharable() {
		return sharable;
	}



	/**
	 * @param sharable the sharable to set
	 */
	public void setSharable(int sharable) {
		this.sharable = sharable;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}



	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
