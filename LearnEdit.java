package week2.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnEdit {

	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) {
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		// enter email
		driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");

		// append text and press keyboard tab
		WebElement eleAppend = driver.findElement(By.xpath("//input[@value='Append ']"));
		eleAppend.sendKeys("  ..,Hi");
		eleAppend.sendKeys(Keys.TAB);

		// get default text entered
		System.out.println("Default value entered is :"
				+ driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("Value"));

		// clear text
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();

		// confirm disabled
		boolean displayed = driver.findElement(By.xpath("//input[@disabled='true']")).isDisplayed();
		if (displayed != false)
			System.out.println("Edit field is disabled");
		
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LearnEdit edit = new LearnEdit();
		edit.startApp(edit.setUpDriver());

	}

}
