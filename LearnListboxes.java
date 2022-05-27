package week2.day1.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListboxes {

	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) throws InterruptedException {

		driver.get(" http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		// select using index

		WebElement eleDropDown1 = driver.findElement(By.id("dropdown1"));
		Select selectDrop1 = new Select(eleDropDown1);
		selectDrop1.selectByIndex(3);
		
		// select using text
		WebElement eleDropDown2 = driver.findElement(By.name("dropdown2"));
		Select selectDrop2 = new Select(eleDropDown2);
		selectDrop2.selectByVisibleText("Loadrunner");

		// select using value
		WebElement eleDropDown3 = driver.findElement(By.id("dropdown3"));
		Select selectDrop3 = new Select(eleDropDown3);
		selectDrop3.selectByValue("2");

		// get number of dropdown options
		WebElement eleDropDown4 = driver.findElement(By.className("dropdown"));
		Select selectDrop4 = new Select(eleDropDown4);
		List<WebElement> options = selectDrop4.getOptions();
		System.out.println("Number of dropdown options is : " + (options.size()-1));

		// use sendKeys to select
		WebElement useSendKeys = driver.findElement(By.xpath("//select[@class='dropdown']/following::select"));
		useSendKeys.sendKeys("Selenium");
		
		//multiple select
		
		WebElement multipleSel = driver.findElement(By.xpath("//select[@class='dropdown']/following::select[2]"));
		Select mulSel=new Select(multipleSel);
		System.out.println("Multiple Select : "+mulSel.isMultiple());
		Thread.sleep(3000);
		mulSel.selectByIndex(1);
		Thread.sleep(3000);
		mulSel.selectByValue("2");
		Thread.sleep(3000);
		mulSel.selectByIndex(3);
		Thread.sleep(5000);
		mulSel.deselectByIndex(2);
		Thread.sleep(7000);
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		LearnListboxes listObj = new LearnListboxes();
		listObj.startApp(listObj.setUpDriver());

	}

}
