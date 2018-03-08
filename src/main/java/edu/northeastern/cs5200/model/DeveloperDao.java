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

import edu.northeastern.cs5200.objects.Developer;
import edu.northeastern.cs5200.objects.Person;

/**
 * @author Abhishek Karan
 *
 */
public class DeveloperDao {

	private Connection conn=null;	
	private PreparedStatement pstmt=null;
	private int result=0;
	private ResultSet results=null;	
	private static DeveloperDao instance=null;
	private String connString="jdbc:mysql://cs5200-spring2018-karan.caa00vj8vym7.us-east-1.rds.amazonaws.com/cs5200_spring2018_karan";
	private String uName="karan";
	private String pass="yourPa$$word123";
	
	public static DeveloperDao getInstance() {
		if(instance==null) {
			return new DeveloperDao();
		}
		return instance;
	}
	
	private DeveloperDao() {
	}

	public int createDeveloper(Developer developer)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO developer (person_id,developerKey) values(?,?) ";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, developer.getPerson().getId());	
			pstmt.setString(2, developer.getDeveloperKey());		
			
			result= pstmt.executeUpdate();
			System.out.println("createDeveloper() Developer Status:"+result);	
			
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
	
	public List<Developer> findAllDevelopers()
	{
		List<Developer> lst=new ArrayList<Developer>();	
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT d.*, p.* FROM developer d, person p WHERE p.id=d.person_id";
			pstmt=conn.prepareStatement(str);	
			results=pstmt.executeQuery();		
			
			while(results.next())
			{
				Person person=new Person(results.getInt("person_id"),results.getString("firstName"),results.getString("lastName"),
						results.getString("username"),results.getString("password"),results.getString("email"),results.getString("dob"));		
				Developer developer=new Developer(results.getInt("id"),person,results.getString("developerKey"));
				lst.add(developer);
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

	public Developer findDeveloperById(int developerId)
	{	
		Developer developer=null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT d.*, p.* FROM developer d, person p WHERE p.id=d.person_id AND d.id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, developerId);
			results=pstmt.executeQuery();		
			
			while(results.next())
			{
				Person person=new Person(results.getInt("person_id"),results.getString("firstName"),results.getString("lastName"),
						results.getString("username"),results.getString("password"),results.getString("email"),results.getString("dob"));		
				developer=new Developer(results.getInt("id"),person,results.getString("developerKey"));
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
		
		return developer;	
	}

	public Developer findDeveloperByUsername(String username)
	{	
		Developer developer=null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT d.*, p.* FROM developer d, person p WHERE p.id=d.person_id AND p.username=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setString(1, username);
			results=pstmt.executeQuery();		
			
			while(results.next())
			{
				Person person=new Person(results.getInt("person_id"),results.getString("firstName"),results.getString("lastName"),
						results.getString("username"),results.getString("password"),results.getString("email"),results.getString("dob"));	
				//Website website=new Website(results.getInt("id"),results.getString("name"),results.getString("description"),results.getString("created"),
					//	results.getString("updated"),results.getInt("visits"));		
				developer=new Developer(results.getInt("id"),person,results.getString("developerKey"));
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
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return developer;	
	}

	public Developer findDeveloperByCredentials(String username,String password)
	{	
		Developer developer=null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="SELECT d.*, p.* FROM developer d, person p WHERE p.id=d.person_id AND p.username=? AND p.password=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			results=pstmt.executeQuery();		
			
			while(results.next())
			{
				Person person=new Person(results.getInt("person_id"),results.getString("firstName"),results.getString("lastName"),
						results.getString("username"),results.getString("password"),results.getString("email"),results.getString("dob"));			
				developer=new Developer(results.getInt("id"),person,results.getString("developerKey"));
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
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return developer;	
	}

	public int updateDeveloper(int developerId,Developer developer)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="UPDATE developer SET developerKey=? WHERE id=?";
			pstmt=conn.prepareStatement(str);	
			pstmt.setString(1, developer.getDeveloperKey());
			pstmt.setInt(2, developerId);
			
			result=pstmt.executeUpdate();
			System.out.println("updateDeveloper() Developer Status:"+result);
			
			str="SELECT person_id FROM developer WHERE id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, developerId);
			results= pstmt.executeQuery();
			results.next();
			result=results.getInt("person_id");
			System.out.println("updateDeveloper() Dev Person_id Status:"+result);
			
			str="UPDATE person SET firstName=?, lastName=?, username=?, password=?, email=?, dob=? WHERE id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setString(1, developer.getPerson().getFirstName());
			pstmt.setString(2, developer.getPerson().getLastName());	
			pstmt.setString(3, developer.getPerson().getUsername());		
			pstmt.setString(4, developer.getPerson().getPassword());
			pstmt.setString(5, developer.getPerson().getEmail());
			pstmt.setString(6, developer.getPerson().getDob());
			pstmt.setInt(7, result);
			
			result= pstmt.executeUpdate();
			System.out.println("updateDeveloper() Person Status:"+result);	
			
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

	public int deleteDeveloper(int developerId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM developer WHERE id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, developerId);
			
			result= pstmt.executeUpdate();
			//System.out.println("deleteDeveloper() Developer Status:"+result);	
			
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
