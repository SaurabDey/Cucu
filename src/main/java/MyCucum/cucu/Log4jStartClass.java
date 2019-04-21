package MyCucum.cucu;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Log4jStartClass 
{
	static WebDriver driver;
	
	static Logger logger= Logger.getLogger(Log4jStartClass.class);

	public static void main(String[] arg) throws InterruptedException
	{
		//BasicConfigurator.configure();
		PropertyConfigurator.configure("Resource/log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		
		
		driver = new ChromeDriver();
		logger.debug("Starting the browser");
		
		driver.get("http://demosite.center/wordpress/wp-login.php?");
		logger.info("Starting the web page");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.error("added the wait");
		
		WebElement userName = driver.findElement(By.id("user_login"));
		userName.sendKeys("admin");
		logger.warn("username entered correctly");
		
		WebElement passWord = driver.findElement(By.id("user_pass"));
		passWord.sendKeys("demo123");
		logger.fatal("passWord entered correctly");
		
		WebElement loginButn = driver.findElement(By.id("wp-submit"));
		loginButn.click();
		logger.info("loginButn clicked");
		
		try {
			Thread.sleep(5000);
			Assert.assertEquals( driver.getTitle(),"Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress");
			logger.info("Dashborad coming correctly");
		} catch (Exception e) {
			logger.error("Dashborad is not coming correctly");
		}
		
		driver.quit();
		logger.info("browser closed");
	}

}
