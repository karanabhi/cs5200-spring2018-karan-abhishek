/**
 * 
 */
package edu.northeastern.cs5200;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;

import java.util.List;

import org.hibernate.hql.internal.ast.tree.ImpliedFromElement;

import edu.northeastern.cs5200.model.DeveloperDao;
import edu.northeastern.cs5200.model.PageDao;
import edu.northeastern.cs5200.model.PersonDao;
import edu.northeastern.cs5200.model.RoleDao;
import edu.northeastern.cs5200.model.UserDao;
import edu.northeastern.cs5200.model.WebsiteDao;
import edu.northeastern.cs5200.model.WidgetDao;
import edu.northeastern.cs5200.objects.Address;
import edu.northeastern.cs5200.objects.Developer;
import edu.northeastern.cs5200.objects.HeadingWidget;
import edu.northeastern.cs5200.objects.HtmlWidget;
import edu.northeastern.cs5200.objects.ImageWidget;
import edu.northeastern.cs5200.objects.Page;
import edu.northeastern.cs5200.objects.Person;
import edu.northeastern.cs5200.objects.Phone;
import edu.northeastern.cs5200.objects.Role;
import edu.northeastern.cs5200.objects.User;
import edu.northeastern.cs5200.objects.Website;
import edu.northeastern.cs5200.objects.Widget;
import edu.northeastern.cs5200.objects.YouTubeWidget;

/**
 * @author Abhishek Karan
 *
 */
public class hw_jdbc_karan_abhishek {

	/**
	 * 
	 */
	public hw_jdbc_karan_abhishek() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		//1. Create Developers
		PersonDao personDao=PersonDao.getInstance();
		DeveloperDao devDao=DeveloperDao.getInstance();
		
		Person person=new Person(0,"Alice", "Wonder", "alice", "alice", "alice@wonder.com", "2000-08-07");
		int pid=personDao.createPerson(person);
		person.setId(pid);
		Developer developer=new Developer(0, person, "4321rewq");
		devDao.createDeveloper(developer);
		person=new Person(0,"Bob", "Marley", "bob", "bob", "bob@marley.com", "1994-02-07");
		pid=personDao.createPerson(person);
		person.setId(pid);
		developer=new Developer(0, person, "5432trew");
		devDao.createDeveloper(developer);
		person=new Person(0,"Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com", "1900-08-07");
		pid=personDao.createPerson(person);
		person.setId(pid);
		developer=new Developer(0, person, "6543ytre");
		devDao.createDeveloper(developer);
		
		person=new Person(0,"Dan", "Martin", "dan", "dan", "dan@martin.com", "2000-08-07");
		pid=personDao.createPerson(person);
		person.setId(pid);
		User user=new User(0, person, 1, "7654fda");
		UserDao userDao=UserDao.getInstance();
		userDao.createUser(user);
		person=new Person(0,"Ed", "Akaraz", "ed", "ed", "ed@kar.com", "1990-08-07");
		pid=personDao.createPerson(person);
		person.setId(pid);
		user=new User(0, person, 1, "5678dfgh");
		userDao.createUser(user);
		
		
		//2. Create Websites for Developers.
		/* Role Id: 1 is Owner
		 * Role Id: 2 is Admin
		 * Role Id: 3 is Writer
		 * Role Id: 4 is Editor
		 * Role Id: 5 is Reviewer
		 */
		WebsiteDao websiteDao=WebsiteDao.getInstance();
		RoleDao roleDao=RoleDao.getInstance();
		Website website=new Website(0, "Facebook", "an online social media and social networking service", null, null, 1234234, null);
		int websiteId;
		websiteId=websiteDao.createWebsiteForDeveloper(10, website);
		roleDao.assignWebsiteRole(10, websiteId, 1);
		roleDao.assignWebsiteRole(11, websiteId, 4);
		roleDao.assignWebsiteRole(12, websiteId, 2);
		website=new Website(0, "Twitter", "an online news and social networking service", null, null, 4321543, null);
		websiteId=websiteDao.createWebsiteForDeveloper(11, website);
		roleDao.assignWebsiteRole(11, websiteId, 1);
		roleDao.assignWebsiteRole(12, websiteId, 4);
		roleDao.assignWebsiteRole(10, websiteId, 2);
		website=new Website(0, "Wikipedia", "a free online encyclopedia", null, null, 3456654, null);
		websiteId=websiteDao.createWebsiteForDeveloper(12, website);
		roleDao.assignWebsiteRole(12, websiteId, 1);
		roleDao.assignWebsiteRole(10, websiteId, 4);
		roleDao.assignWebsiteRole(11, websiteId, 2);
		website=new Website(0, "CNN", "an American basic cable and satellite television news channel", null, null, 6543345, null);
		websiteId=websiteDao.createWebsiteForDeveloper(10, website);
		roleDao.assignWebsiteRole(10, websiteId, 1);
		roleDao.assignWebsiteRole(11, websiteId, 4);
		roleDao.assignWebsiteRole(12, websiteId, 2);
		website=new Website(0, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", null, null, 5433455, null);
		websiteId=websiteDao.createWebsiteForDeveloper(11, website);
		roleDao.assignWebsiteRole(11, websiteId, 1);
		roleDao.assignWebsiteRole(12, websiteId, 4);
		roleDao.assignWebsiteRole(10, websiteId, 2);
		website=new Website(0, "GIZMODO", "a design, technology, science and science fiction website that also writes articles on politics", null, null, 4322345, null);
		websiteId=websiteDao.createWebsiteForDeveloper(12, website);
		roleDao.assignWebsiteRole(12, websiteId, 1);
		roleDao.assignWebsiteRole(10, websiteId, 4);
		roleDao.assignWebsiteRole(11, websiteId, 2);
		
		//3. Create Pages for Websites
		PageDao pageDao=PageDao.getInstance();
		roleDao=RoleDao.getInstance();
		websiteDao=WebsiteDao.getInstance();
		website=new Website(0, "CNET", null, null, null, 0, null);
		Page page=new Page(0, null, "Home", "Landing page", null, null, 123434, "title");
		int pageId;
		pageId=pageDao.createPageForWebsite(8, page);
		roleDao.assignPageRole(10, pageId, 4);
		roleDao.assignPageRole(11, pageId, 5);
		roleDao.assignPageRole(12, pageId, 3);
		page=new Page(0, null, "About", "Website Description", null, null, 234545, "title");
		pageId=pageDao.createPageForWebsite(9, page);
		roleDao.assignPageRole(11, pageId, 4);
		roleDao.assignPageRole(12, pageId, 5);
		roleDao.assignPageRole(10, pageId, 3);
		page=new Page(0, null, "Contact", "Addresses, phones, and contact info", null, null, 345656, "title");
		pageId=pageDao.createPageForWebsite(6, page);
		roleDao.assignPageRole(12, pageId, 4);
		roleDao.assignPageRole(10, pageId, 5);
		roleDao.assignPageRole(11, pageId, 3);
		page=new Page(0, null, "Preferences", "Where users can configure their preferences", null, null, 345656, "title");
		pageId=pageDao.createPageForWebsite(7, page);
		roleDao.assignPageRole(10, pageId, 4);
		roleDao.assignPageRole(11, pageId, 5);
		roleDao.assignPageRole(12, pageId, 3);
		page=new Page(0, null, "Profile", "Users can configure their personal information", null, null, 345656, "title");
		pageId=pageDao.createPageForWebsite(8, page);
		roleDao.assignPageRole(11, pageId, 4);
		roleDao.assignPageRole(12, pageId, 5);
		roleDao.assignPageRole(10, pageId, 3);
		
		//PageDao pageDao=PageDao.getInstance();
		//RoleDao roleDao=RoleDao.getInstance();
		//Page page=new Page(0, null, "Contact", "Addresses, phones, and contact info", null, null, 345656, "title");
		//int pageId=pageDao.createPageForWebsite(6, page);
		//roleDao.assignPageRole(12, pageId, 4);
		//roleDao.assignPageRole(10, pageId, 5);
		//roleDao.assignPageRole(11, pageId, 3);
		
		//4. Create Widgets
		
		WidgetDao widgetDao=WidgetDao.getInstance();
		int widgetId;
		Widget widget=new Widget(0, null, "head123", 0, 0, null, null, "Welcome", 0);
		HeadingWidget heading=new HeadingWidget(0, 0, widget);
		widgetId=widgetDao.createWidgetForPage(3, widget);
		widgetDao.createHeadingWidget(widgetId, heading);
		widget=new Widget(0, null, "post234", 0, 0, null, null, "<p>Lorem</p>", 0);
		HtmlWidget html=new HtmlWidget(0, null, widget);
		widgetId=widgetDao.createWidgetForPage(4, widget);
		widgetDao.createHTMLWidget(widgetId, html);
		widget=new Widget(0, null, "head345", 0, 0, null, null, "Hi", 1);
		heading=new HeadingWidget(0, 0, widget);
		widgetId=widgetDao.createWidgetForPage(5, widget);
		widgetDao.createHeadingWidget(widgetId, heading);
		widget=new Widget(0, null, "intro456", 0, 0, null, null, "<h1>Hi</h1>", 2);
		html=new HtmlWidget(0, null, widget);
		widgetId=widgetDao.createWidgetForPage(5, widget);
		widgetDao.createHTMLWidget(widgetId, html);
		widget=new Widget(0, null, "image345", 50, 100, null, null, null, 3);
		ImageWidget image=new ImageWidget(0, "/img/567.png", widget);
		widgetId=widgetDao.createWidgetForPage(5, widget);
		widgetDao.createImageWidget(widgetId, image);
		widget=new Widget(0, null, "video456", 400, 300, null, null, null, 0);
		YouTubeWidget youTube=new YouTubeWidget(0, "https://youtu.be/h67VX51QXiQ", widget, 0, 0);
		widgetId=widgetDao.createWidgetForPage(6, widget);
		widgetDao.createYouTubeWidget(widgetId, youTube);
		
		
		implementUpdates();
		implementDeletes();
	}
	
	
	public static void implementUpdates() {
		
		//1. Update Developer
		 Phone phone=new Phone(0, null, "333-444-5555", 1);
		 PersonDao personDao=PersonDao.getInstance();
		 personDao.updatePersonPhoneNumber(13, phone);
		 
			
		//2. Update DeveloperWideget		
		WidgetDao widgetDao=WidgetDao.getInstance();
		Widget widget=widgetDao.findWidgetById(5);
		widget.setOrder(3);
		widgetDao.updateWidget(5, widget);
		
		
		//3. Update Page
		PageDao pageDao=PageDao.getInstance();
		pageDao.updatePageByTitle(8, "CNET ");	
		
		//4. Update Roles
		RoleDao roleDao=RoleDao.getInstance();
		roleDao.swapRoles(8, 3, 1, 12);
		roleDao.swapRoles(8, 3, 4, 11);	
		
	}//Implement Updates (15pts)
	
	public static void implementDeletes() {
		
		//1. Delete Developer
		PersonDao personDao=PersonDao.getInstance();
		personDao.deletePersonPrimaryAddress(16);
		
		//2. Delete Widget
		
		WidgetDao widgetDao=WidgetDao.getInstance();
		widgetDao.deleteWidgetFromContactPage(5);
		
		//3. Delete Page
		PageDao pageDao=PageDao.getInstance();
		pageDao.deleteLastUpdatedPage(6);
		
		//4. Delete Website
		WebsiteDao websiteDao=WebsiteDao.getInstance();
		websiteDao.deleteWebsite(8);
		
		
	}//Implement Deletes()
	
	
	

}
