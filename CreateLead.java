package week2.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	
	public ChromeDriver setUpDriver() {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		return driver;
		
	}
	
	public void startApp(ChromeDriver driver) throws InterruptedException {
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Balasubramaniam");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S P");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Balu");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("HR");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Hiii..!!");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("baluspb@gmail.com");
		
		WebElement eleStateDropDown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selectState=new Select(eleStateDropDown);
		selectState.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(3000);
		
		System.out.println("Title of the resulting page : "+driver.getTitle());
		driver.close();
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CreateLead newLead= new CreateLead();
		newLead.startApp(newLead.setUpDriver());
		
	}

}
