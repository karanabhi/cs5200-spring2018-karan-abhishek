/**
 * 
 */
package edu.northeastern.cs5200.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.northeastern.cs5200.objects.Developer;
import edu.northeastern.cs5200.objects.Website;

/**
 * @author Abhishek Karan
 *
 */
public class WebsiteDao {

	private Connection conn=null;	
	private PreparedStatement pstmt=null;
	private int result=0;
	private ResultSet results=null;	
	private static WebsiteDao instance=null;
	private String connString="jdbc:mysql://cs5200-spring2018-karan.caa00vj8vym7.us-east-1.rds.amazonaws.com/cs5200_spring2018_karan";
	private String uName="karan";
	private String pass="yourPa$$word123";
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static WebsiteDao getInstance() {
		if(instance==null) {
			return new WebsiteDao();
		}
		return instance;
	}
	
	private WebsiteDao() {
	}

	@SuppressWarnings("static-access")
	public int createWebsiteForDeveloper(int developerId, Website website)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO website (developer_id,name,description,created,updated,visits) values(?,?,?,?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, developerId);
			pstmt.setString(2, website.getName());	
			pstmt.setString(3, website.getDescription());
			pstmt.setString(4, "2018-07-03");
			pstmt.setString(5, "2018-07-03");
			pstmt.setInt(6, website.getVisits());
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("createWebsiteForDeveloper() Website Status:"+result);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}
	
	public List<Website> findAllWebsites()
	{
		List<Website> lst=new ArrayList<Website>();	
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT * FROM website";
			pstmt=conn.prepareStatement(str);	
			results=pstmt.executeQuery();		
			
			while(results.next())
			{
				Developer developer=new Developer(results.getInt("developer_id"), null, "");
				Website website=new Website(results.getInt("id"),results.getString("name"),results.getString("description"),results.getString("created"),
						results.getString("updated"),results.getInt("visits"),developer);
				lst.add(website);
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

	public List<Website> findWebsitesForDeveloper(int developerId)
	{	
		List<Website> lst=new ArrayList<Website>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT w.*,d.developerKey FROM website w, developer d WHERE d.id=w.developer_id AND d.id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, developerId);
			results=pstmt.executeQuery();		
			
			while(results.next())
			{
				Developer developer=new Developer(results.getInt("developer_id"), null, results.getString("developerKey"));
				Website website=new Website(results.getInt("id"),results.getString("name"),results.getString("description"),results.getString("created"),
						results.getString("updated"),results.getInt("visits"),developer);
				lst.add(website);
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

	public Website findWebsiteById(int websiteId)
	{	
		Website website=null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT * FROM website WHERE id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, websiteId);
			results=pstmt.executeQuery();	
			results.next();
				
			Developer developer=new Developer(results.getInt("developer_id"),null,"");
			website=new Website(results.getInt("id"),results.getString("name"),results.getString("description"),results.getString("created"),
						results.getString("updated"),results.getInt("visits"),developer);		
				
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
		
		return website;	
	}

	public int updateWebsite(int websiteId, Website website)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="UPDATE website SET name=?, description=?, updated=?, visits=?, developer_id=? WHERE id=?";
			pstmt=conn.prepareStatement(str);	
			pstmt.setString(1, website.getName());
			pstmt.setString(2, website.getDescription());
			pstmt.setString(3, website.getUpdated());
			pstmt.setInt(4, website.getVisits());
			pstmt.setInt(5, website.getDeveloper().getId());
			pstmt.setInt(6, websiteId);
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

	public int deleteWebsite(int websiteId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM website WHERE id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, websiteId);
			
			result= pstmt.executeUpdate();
			System.out.println("deleteWebsite() Website Status:"+result);
			
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
