/**
 * 
 */
package edu.northeastern.cs5200.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.objects.HeadingWidget;
import edu.northeastern.cs5200.objects.HtmlWidget;
import edu.northeastern.cs5200.objects.ImageWidget;
import edu.northeastern.cs5200.objects.Page;
import edu.northeastern.cs5200.objects.Website;
import edu.northeastern.cs5200.objects.Widget;
import edu.northeastern.cs5200.objects.YouTubeWidget;

/**
 * @author Abhishek Karan
 *
 */
public class WidgetDao {

	private Connection conn=null;	
	private PreparedStatement pstmt=null;
	private int result=0;
	private ResultSet results=null;	
	private static WidgetDao instance=null;
	private String connString="jdbc:mysql://cs5200-spring2018-karan.caa00vj8vym7.us-east-1.rds.amazonaws.com/cs5200_spring2018_karan";
	private String uName="karan";
	private String pass="yourPa$$word123";
	
	public static WidgetDao getInstance() {	
		if(instance==null) {
			return new WidgetDao();
		}
		return instance;
	}
	
	private WidgetDao() {
	}

	@SuppressWarnings("static-access")
	public int createWidgetForPage(int pageId, Widget widget)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO widget (page_id,name,width,height,cssClass,cssStyle,text,`order`) values(?,?,?,?,?,?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, pageId);
			pstmt.setString(2, widget.getName());	
			pstmt.setInt(3, widget.getWidth());		
			pstmt.setInt(4, widget.getHeight());
			pstmt.setString(5, widget.getCssClass());
			pstmt.setString(6, widget.getCssStyle());
			pstmt.setString(7, widget.getText());	
			pstmt.setInt(8, widget.getOrder());
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("createWidgetForPage() Widget Status:"+result);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}
	
	public List<Widget> findAllWidgets()
	{
		List<Widget> lst=new ArrayList<Widget>();	
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT * FROM widget";
			pstmt=conn.prepareStatement(str);	
			results=pstmt.executeQuery();		
			
			while(results.next())
			{
				Page page=new Page(results.getInt("page_id"), null, null, null, null, null, 0, null);	
				Widget widget=new Widget(results.getInt("id"), page, results.getString("name"), results.getInt("width"), results.getInt("height"),
						results.getString("cssClass"),results.getString("cssStyle"), results.getString("text"), results.getInt("order"));
				lst.add(widget);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				results.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return lst;	
	}

	public List<Widget> findWidgetsForPage(int pageId)
	{	
		List<Widget> lst=new ArrayList<Widget>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT w.* FROM widget w, page p WHERE p.id=w.page_id AND p.id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, pageId);
			results=pstmt.executeQuery();		
			
			while(results.next())
			{
				Page page=new Page(results.getInt("page_id"), null, null, null, null, null, 0, null);
				Widget widget=new Widget(results.getInt("id"), page, results.getString("name"), results.getInt("width"), results.getInt("height"),
						results.getString("cssClass"),results.getString("cssStyle"), results.getString("text"), results.getInt("order"));
				lst.add(widget);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				results.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return lst;	
	}

	public Widget findWidgetById(int widgetId)
	{	
		Widget widget=null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT * FROM widget WHERE id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, widgetId);
			results=pstmt.executeQuery();	
			results.next();
				
			Page page=new Page(results.getInt("page_id"), null, null, null, null, null, 0, null);	
			widget=new Widget(results.getInt("id"), page, results.getString("name"), results.getInt("width"), results.getInt("height"),
					results.getString("cssClass"),results.getString("cssStyle"), results.getString("text"), results.getInt("order"));
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return widget;	
	}

	public int updateWidget(int widgetId, Widget widget)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="UPDATE widget SET name=?, width=?, height=?, cssClass=?, cssStyle=?,text=?,`order`=?, page_id=? WHERE id=?";
			pstmt=conn.prepareStatement(str);	
			pstmt.setString(1, widget.getName());
			pstmt.setInt(2, widget.getWidth());
			pstmt.setInt(3, widget.getHeight());
			pstmt.setString(4, widget.getCssClass());
			pstmt.setString(5, widget.getCssStyle());
			pstmt.setString(6, widget.getText());
			pstmt.setInt(7, widget.getOrder());
			pstmt.setInt(8, widget.getPage().getId());
			pstmt.setInt(9, widgetId);
			result=pstmt.executeUpdate();
			System.out.println("updateWebsite() Website Status:"+result);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}

	public int deleteWidget(int widgetId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM widget WHERE id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, widgetId);
			
			result= pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}
	
	@SuppressWarnings("static-access")
	public int createHTMLWidget(int widgetId, HtmlWidget htmlWidget)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO html (widget_id,html) values(?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, widgetId);
			pstmt.setString(2, htmlWidget.getHtml());	
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("createHTMLWidget() Html Status:"+result);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}

	@SuppressWarnings("static-access")
	public int createHeadingWidget(int widgetId, HeadingWidget headingWidget)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO heading (widget_id,size) values(?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, widgetId);
			pstmt.setInt(2, headingWidget.getSize());	
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("createHeadingWidget() Heading Status:"+result);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}

	@SuppressWarnings("static-access")
	public int createImageWidget(int widgetId, ImageWidget imageWidget)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO image (widget_id,src) values(?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, widgetId);
			pstmt.setString(2, imageWidget.getSrc());	
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("createImageWidget() Image Status:"+result);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}

	@SuppressWarnings("static-access")
	public int createYouTubeWidget(int widgetId, YouTubeWidget youtubeWidget)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO youTube (widget_id,url,sharable,expandable) values(?,?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, widgetId);
			pstmt.setString(2, youtubeWidget.getUrl());	
			pstmt.setInt(3, youtubeWidget.getSharable());
			pstmt.setInt(4, youtubeWidget.getExpandable());
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("createYouTubeWidget() youTube Status:"+result);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}

	public int deleteWidgetFromContactPage(int pageId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM widget WHERE page_id=? AND `order`=(SELECT x.maxOrder FROM (SELECT MAX(`order`) as maxOrder from widget where page_id=?) x)";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, pageId);
			pstmt.setInt(2, pageId);
			
			result= pstmt.executeUpdate();
			System.out.println("deleteWidgetFromContactPage() Widget Status:"+result);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}
	
}
