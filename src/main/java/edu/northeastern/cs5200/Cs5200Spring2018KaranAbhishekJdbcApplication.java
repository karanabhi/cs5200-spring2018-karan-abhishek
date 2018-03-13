package edu.northeastern.cs5200;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import edu.northeastern.cs5200.model.DeveloperDao;
import edu.northeastern.cs5200.model.PageDao;
import edu.northeastern.cs5200.model.PriviledgeDao;
import edu.northeastern.cs5200.model.RoleDao;
import edu.northeastern.cs5200.model.WebsiteDao;
import edu.northeastern.cs5200.model.WidgetDao;
import edu.northeastern.cs5200.objects.Developer;
import edu.northeastern.cs5200.objects.Page;
import edu.northeastern.cs5200.objects.Person;
import edu.northeastern.cs5200.objects.Website;
import edu.northeastern.cs5200.objects.Widget;

@SpringBootApplication
public class Cs5200Spring2018KaranAbhishekJdbcApplication extends SpringBootServletInitializer	{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Cs5200Spring2018KaranAbhishekJdbcApplication.class);
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(Cs5200Spring2018KaranAbhishekJdbcApplication.class, args);
		
		System.out.println("Started.........................");
		DeveloperDao dao=DeveloperDao.getInstance();
		Person person=new Person(0, "demo", "demo", "basdasdasob", "badasdob", "bsdasrley.xyz", "1974-10-18");
		Developer developer=new Developer(0, person, "5432trssssssssew");
		int result=dao.createDeveloper(developer);
		System.out.println("Create Developer: "+result);		
		System.out.println(dao.findAllDevelopers());
		System.out.println(dao.findDeveloperByUsername("aliceUname"));
		System.out.println(dao.findDeveloperByCredentials("aliceUname","alicePassword"));
		System.out.println(dao.updateDeveloper(3,developer));
		System.out.println(dao.deleteDeveloper(4));
		
		/***************************************************************************************/
		WebsiteDao webDao=WebsiteDao.getInstance();
		developer=new Developer(3, person, "5432trssssssssew");
		Website website=new Website(0, "Amazon", "Retailer", null,"2008-2-8", 4234, developer);
		System.out.println("Create Website: "+webDao.createWebsiteForDeveloper(3, website));
		System.out.println(webDao.findAllWebsites());
		System.out.println(webDao.findWebsitesForDeveloper(1));
		System.out.println(webDao.findWebsiteById(1));
		developer=new Developer(1, person, "5432trssssssssew");
		website=new Website(0, "Facebook", "Social Media", null,"2018-2-8", 7777, developer);
		System.out.println(webDao.updateWebsite(1,website));
		System.out.println(webDao.deleteWebsite(1));
		/***************************************************************************************/
		PageDao pageDao=PageDao.getInstance();
		developer=new Developer(3, person, "5432trssssssssew");
		website=new Website(3, "Amazon", "Retailer", null,"2008-2-8", 4234, developer);
		Page page=new Page(0, website, "Home", "Home Page", null, "2006-8-3", 78946500, "Home Page New");
		System.out.println("Create Page: "+pageDao.createPageForWebsite(3, page));
		System.out.println(pageDao.findAllPages());
		System.out.println(pageDao.findPageById(1));
		System.out.println(pageDao.findPagesForWebsite(3));
		page=new Page(1, website, "Cart", "Cart Page", null, "2016-3-1", 1278946500, "Cart Delivery Page");
		System.out.println(pageDao.updatePage(1,page));
		System.out.println(pageDao.deletePage(1));
		/***************************************************************************************/
		WidgetDao widgetDao=WidgetDao.getInstance();
		page=new Page(2, null, "Home", "Home Page", null, "2006-8-3", 78946500, "Home Page New");
		Widget widget=new Widget(0, page, "Image", 500, 300, "font-color", "color", "Image Caption", 3);	
		System.out.println("Create Widget"+widgetDao.createWidgetForPage(2, widget));
		System.out.println(widgetDao.findAllWidgets());
		System.out.println(widgetDao.findWidgetById(1));
		System.out.println(widgetDao.findWidgetsForPage(2));
		widget=new Widget(1, page, "Table", 100, 200, "font-color", "border", "Table Caption", 5);
		System.out.println(widgetDao.updateWidget(1,widget));
		System.out.println(widgetDao.deleteWidget(2));
		/***************************************************************************************/
		 /*Role Id: 1 is Owner
		 * Role Id: 2 is Admin
		 * Role Id: 3 is Writer
		 * Role Id: 4 is Editor
		 * Role Id: 5 is Reviewer
		 */
		RoleDao roleDao=RoleDao.getInstance();
		System.out.println(roleDao.assignWebsiteRole(3, 3, 5));
		System.out.println(roleDao.assignPageRole(3, 2, 4));
		System.out.println(roleDao.deleteWebsiteRole(3, 3, 1));
		System.out.println(roleDao.deletePageRole(3, 2, 2));
		/***************************************************************************************/
		/* Priviledge Id: 1 is Create
		 * Priviledge Id: 2 is Update
		 * Priviledge Id: 3 is Read
		 * Priviledge Id: 4 is Delete
		 */
		PriviledgeDao priviledgeDao=PriviledgeDao.getInstance();
		System.out.println(priviledgeDao.assignWebsitePriviledge(3, 3, 4));
		System.out.println(priviledgeDao.assignPagePriviledge(3, 2, 2));
		System.out.println(priviledgeDao.deleteWebsitePriviledge(3, 3, 4));
		System.out.println(priviledgeDao.deletePagePriviledge(3, 2, 2));
		
		
		
		
		
	}
}
