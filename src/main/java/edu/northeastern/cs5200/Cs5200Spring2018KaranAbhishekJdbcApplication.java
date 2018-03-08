package edu.northeastern.cs5200;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import edu.northeastern.cs5200.model.DeveloperDao;
import edu.northeastern.cs5200.model.PageDao;
import edu.northeastern.cs5200.model.WebsiteDao;
import edu.northeastern.cs5200.objects.Developer;
import edu.northeastern.cs5200.objects.Page;
import edu.northeastern.cs5200.objects.Person;
import edu.northeastern.cs5200.objects.Website;

@SpringBootApplication
public class Cs5200Spring2018KaranAbhishekJdbcApplication extends SpringBootServletInitializer	{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Cs5200Spring2018KaranAbhishekJdbcApplication.class);
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(Cs5200Spring2018KaranAbhishekJdbcApplication.class, args);
		
		System.out.println("Started.........................");
		//DeveloperDao dao=DeveloperDao.getInstance();
		Person person=new Person(0, "demo", "demo", "basdasdasob", "badasdob", "bsdasrley.xyz", "1974-10-18");
		//Developer developer=new Developer(0, person, "5432trssssssssew");
		//int result=dao.createDeveloper(developer);
		//System.out.println("Create Developer: "+result);		
		//System.out.println(dao.findAllDevelopers());
		//System.out.println(dao.findDeveloperById());
		//System.out.println(dao.findDeveloperByUsername("aliceUname"));
		//System.out.println(dao.findDeveloperByCredentials("aliceUname","alicePassword"));
		//System.out.println(dao.updateDeveloper(3,developer));
		//System.out.println(dao.deleteDeveloper(4));
		
		/***************************************************************************************/
		//WebsiteDao webDao=WebsiteDao.getInstance();
		//Developer developer=new Developer(3, person, "5432trssssssssew");
		//Website website=new Website(0, "Amazon", "Retailer", null,"2008-2-8", 4234, developer);
		//System.out.println("Create Website: "+webDao.createWebsiteForDeveloper(3, website));
		//System.out.println(webDao.findAllWebsites());
		//System.out.println(webDao.findWebsitesForDeveloper(1));
		//System.out.println(webDao.findWebsiteById(1));
		//Developer developer=new Developer(1, person, "5432trssssssssew");
		//Website website=new Website(0, "Facebook", "Social Media", null,"2018-2-8", 7777, developer);
		//System.out.println(webDao.updateWebsite(1,website));
		//System.out.println(webDao.deleteWebsite(1));
		/***************************************************************************************/
		PageDao pageDao=PageDao.getInstance();
		//Developer developer=new Developer(3, person, "5432trssssssssew");
		//Website website=new Website(3, "Amazon", "Retailer", null,"2008-2-8", 4234, developer);
		//Page page=new Page(0, website, "Home", "Home Page", null, "2006-8-3", 78946500, "Home Page New");
		//System.out.println("Create Page: "+pageDao.createPageForWebsite(3, page));
		//System.out.println(pageDao.findAllPages());
		//System.out.println(pageDao.findPageById(1));
		//System.out.println(pageDao.findPagesForWebsite(3));
		//Page page=new Page(1, website, "Cart", "Cart Page", null, "2016-3-1", 1278946500, "Cart Delivery Page");
		//System.out.println(pageDao.updatePage(1,page));
		//System.out.println(pageDao.deletePage(1));
		/***************************************************************************************/
		
		
		
		
		
	}
}
