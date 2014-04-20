package eeda.property;import static org.junit.Assert.assertTrue;import org.junit.After;import org.junit.Before;import org.junit.Test;import org.openqa.selenium.WebDriver;import org.openqa.selenium.WebDriverBackedSelenium;import org.openqa.selenium.firefox.FirefoxDriver;import com.thoughtworks.selenium.Selenium;import eeda.leads.LeadsListPage;import eeda.leads.LeadsPage;import eeda.login.HomePage;import eeda.login.LoginPage;public class LeadsListPageTest {	WebDriver driver;	private Selenium selenium;	@Before	public void setUp() throws Exception {		driver = new FirefoxDriver();		selenium = new WebDriverBackedSelenium(driver, "http://localhost:8080");	}	@Test	public void testLoginDemoList() {		LoginPage signInPage = new LoginPage(selenium);		HomePage homePage = signInPage.loginValidUser("demo", "123456");		LeadsListPage listPage = homePage.openLeadsList();		assertTrue(selenium.getLocation().equals("http://localhost:8080/list"));		assertTrue(selenium.isElementPresent("eeda-table"));	}	@Test	public void testLeadsList() {		LoginPage signInPage = new LoginPage(selenium);		HomePage homePage = signInPage.loginValidUser("jason", "123456");		LeadsListPage listPage = homePage.openLeadsList();		assertTrue(selenium.getLocation().equals("http://localhost:8080/list"));	}	@Test	public void testNewAndSave() {		LoginPage signInPage = new LoginPage(selenium);		HomePage homePage = signInPage.loginValidUser("jason", "123456");		LeadsListPage listPage = homePage.openLeadsList();		LeadsPage leads = listPage.openNewLeads();		leads.inputNewLeadsAndSave();		assertTrue(selenium.getLocation().equals("http://localhost:8080/list"));	}	@Test	public void testEditAndSave() {		LoginPage signInPage = new LoginPage(selenium);		HomePage homePage = signInPage.loginValidUser("jason", "123456");		LeadsListPage listPage = homePage.openLeadsList();		LeadsPage leads = listPage.openEditLeads(listPage.getFirstLeadsID());		leads.inputNewLeadsAndSave();		assertTrue(selenium.getLocation().equals("http://localhost:8080/list"));	}	@After	public void tearDown() throws Exception {		selenium.stop();	}}