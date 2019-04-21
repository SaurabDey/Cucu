package MyCucum.cucu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinationClass {
	WebDriver driver;

	@Given("^I have wordpress site$")
	public void i_have_wordpress_site() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php?");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^I provide username$")
	public void i_provide_username_and_password() throws Throwable {
		WebElement userName = driver.findElement(By.id("user_login"));
		userName.sendKeys("admin");

	}
	
	@When("^I provide password$")
	public void andMethod()
	{
		WebElement passWord = driver.findElement(By.id("user_pass"));
		passWord.sendKeys("demo123");

		WebElement loginButn = driver.findElement(By.id("wp-submit"));
		loginButn.click();
	}

	@Then("^I should see the dashboard$")
	public void i_should_see_the_dashboard() throws Throwable {
		Assert.assertNotEquals( driver.getTitle(),"Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress");
		
		driver.quit();

	}
	
	@When("^I provide incorrect (\\w+) and (\\w+)$")
	public void neg(String xyz, String abc)
	{
		WebElement userName = driver.findElement(By.id("user_login"));
		userName.sendKeys(xyz);

		WebElement passWord = driver.findElement(By.id("user_pass"));
		passWord.sendKeys(abc);

		WebElement loginButn = driver.findElement(By.id("wp-submit"));
		loginButn.click();
		
	}
	@Then("^check the (.*) message$")
	public void err(String errorMesasge)
	
	{
		WebElement err= driver.findElement(By.id("login_error"));
		String acualError=err.getText();
		
		Assert.assertEquals(acualError, errorMesasge);
		driver.quit();
	}
	
	@Then("^I should not see the dashboard$")
	public void notSeeDash()
	{
		Assert.assertNotEquals( driver.getTitle(),"Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress");
		driver.quit();
	}
}
