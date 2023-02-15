package assignment.W2D1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateLead {
	
	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login"); 							//Open leaftaps URL
		driver.manage().window().maximize(); 												//To maximize the window
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager"); 				//Locate User name using id element
		Thread.sleep(2000);																	//Wait for 2 seconds
		driver.findElement(By.id("password")).sendKeys("crmsfa"); 							//Locate Password using id element
		Thread.sleep(2000);																	//Wait for 2 seconds
		driver.findElement(By.className("decorativeSubmit")).click();						//Click Login button
		driver.findElement(By.linkText("CRM/SFA")).click();									//Click CRM/SFA link
		driver.findElement(By.linkText("Create Lead")).click();								//Click Create Lead
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Company");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Isha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sars");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Ish");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Sales");

		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test description to be cleared");

		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("bhatia.test6@test.com");

		//DROPDOWN - select state value by visible text
		WebElement ddstate = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateval = new Select(ddstate);
		stateval.selectByVisibleText("New York");

		driver.findElement(By.className("smallSubmit")).click();

		String title = driver.getTitle();

		System.out.println("Title of the page after creating the lead is "+"'"+title+"'");

		driver.findElement(By.linkText("Duplicate Lead")).click();

		WebElement compName = driver.findElement(By.id("createLeadForm_companyName"));

		String val = compName.getAttribute("value");

		System.out.println("Complany name before clearing the field is "+val);

		compName.sendKeys(val);

		compName.clear();

		compName.sendKeys("CTS");

		WebElement fname = driver.findElement(By.id("createLeadForm_firstName"));

		String fname1 = fname.getAttribute("value");

		System.out.println("The firstname before clearing is "+fname1);

		fname.clear();

		fname.sendKeys("Isha Updated");

		//driver.manage().timeouts().implicitlyWait(10, SECOND);
		//getting error in implicit wait Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.util.concurrent.TimeUnit.toMillis(long)" because "unit" is null

		driver.findElement(By.className("smallSubmit")).click();

		System.out.println("The title of the page after creating Duplicate lead is "+driver.getTitle());


	}

}
