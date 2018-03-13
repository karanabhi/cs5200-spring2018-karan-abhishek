/**
 * 
 */
package edu.northeastern.cs5200.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.objects.Developer;
import edu.northeastern.cs5200.objects.Page;
import edu.northeastern.cs5200.objects.Website;

/**
 * @author Abhishek Karan
 *
 */
public class PageDao {

	private Connection conn=null;	
	private PreparedStatement pstmt=null;
	private int result=0;
	private ResultSet results=null;	
	private static PageDao instance=null;
	private String connString="jdbc:mysql://cs5200-spring2018-karan.caa00vj8vym7.us-east-1.rds.amazonaws.com/cs5200_spring2018_karan";
	private String uName="karan";
	private String pass="yourPa$$word123";
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static PageDao getInstance() {
		if(instance==null) {
			return new PageDao();
		}
		return instance;
	}
	
	private PageDao() {
	}

	@SuppressWarnings("static-access")
	public int createPageForWebsite(int websiteId, Page page)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO page (website_id,name,description,created,updated,views,title) values(?,?,?,?,?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, websiteId);
			pstmt.setString(2, page.getName());	
			pstmt.setString(3, page.getDescription());		
			pstmt.setString(4, "2018-07-03");
			pstmt.setString(5, "2018-07-03");
			pstmt.setInt(6, page.getViews());
			pstmt.setString(7, page.getTitle());
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("createPageForWebsite() Page Status:"+result);	
			
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
	
	public List<Page> findAllPages()
	{
		List<Page> lst=new ArrayList<Page>();	
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT * FROM page";
			pstmt=conn.prepareStatement(str);	
			results=pstmt.executeQuery();		
			
			while(results.next())
			{
				Website website=new Website(results.getInt("website_id"),"","","","",0,null);
				Page page=new Page(results.getInt("id"), website, results.getString("name"), results.getString("description"),
						results.getString("created"), results.getString("updated"), results.getInt("views"), results.getString("title"));
				lst.add(page);
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

	public List<Page> findPagesForWebsite(int websiteId)
	{	
		List<Page> lst=new ArrayList<Page>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT p.* FROM website w, page p WHERE w.id=p.website_id AND p.website_id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, websiteId);
			results=pstmt.executeQuery();		
			
			while(results.next())
			{
				Website website=new Website(results.getInt("website_id"),"","","","",0,null);
				Page page=new Page(results.getInt("id"), website, results.getString("name"), results.getString("description"),
						results.getString("created"), results.getString("updated"), results.getInt("views"), results.getString("title"));
				lst.add(page);
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

	public Page findPageById(int pageId)
	{	
		Page page=null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT * FROM page WHERE id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, pageId);
			results=pstmt.executeQuery();	
			results.next();
				
			Website website=new Website(results.getInt("website_id"),"","","","",0,null);
			page=new Page(results.getInt("id"), website, results.getString("name"), results.getString("description"),
					results.getString("created"), results.getString("updated"), results.getInt("views"), results.getString("title"));		
				
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
		
		return page;	
	}

	public int updatePage(int pageId, Page page)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="UPDATE page SET name=?, description=?, updated=?, views=?,title=?, website_id=? WHERE id=?";
			pstmt=conn.prepareStatement(str);	
			pstmt.setString(1, page.getName());
			pstmt.setString(2, page.getDescription());
			pstmt.setString(3, page.getUpdated());
			pstmt.setInt(4, page.getViews());
			pstmt.setString(5, page.getTitle());
			pstmt.setInt(6, page.getWebsite().getId());
			pstmt.setInt(7, pageId);
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

	public int deletePage(int pageId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM page WHERE id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, pageId);
			
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

	public int updatePageByTitle(int websiteId, String title)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="UPDATE page SET title=concat(?,title) WHERE website_id=?";
			pstmt=conn.prepareStatement(str);	
			pstmt.setString(1, title);
			pstmt.setInt(2, websiteId);
			result=pstmt.executeUpdate();
			System.out.println("updatePageByTitle() Page Status:"+result);
			
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

	public int deleteLastUpdatedPage(int websiteId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM page WHERE website_id=? AND updated=(SELECT x.maxUpdated FROM (SELECT MAX(updated) as maxUpdated from page where website_id=?) x)";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, websiteId);
			pstmt.setInt(2, websiteId);
			
			result= pstmt.executeUpdate();
			System.out.println("deleteLastUpdatedPage() Page Status:"+result);
			
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
