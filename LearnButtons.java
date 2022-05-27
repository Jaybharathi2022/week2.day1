package week2.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnButtons {

	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) {
		driver.get("http://www.leafground.com/pages/Button.html");
		driver.manage().window().maximize();

		//go to home
		driver.findElement(By.id("home")).click();

		driver.findElement(By.xpath("//h5[text()='Button']")).click();

		//get position
		WebElement elePos = driver.findElement(By.id("position"));
		Point location = elePos.getLocation();
		//Dimension size = elePos.getSize();

		System.out.println("Location : "+location /*+" , " + "Size : "+size*/);

		//get color
		System.out.println("Color :"+driver.findElement(By.id("color")).getCssValue("color"));

		//get size
		System.out.println("Size :"+driver.findElement(By.id("size")).getSize());
		
		driver.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LearnButtons buttons = new LearnButtons();
		buttons.startApp(buttons.setUpDriver());

	}

}
