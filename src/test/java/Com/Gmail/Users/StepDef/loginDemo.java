package Com.Gmail.Users.StepDef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginDemo {
	
	WebDriver driver = new ChromeDriver();
	
	@Given("I navigate to login page")
	public void i_navigate_to_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://demo.guru99.com/test/newtours/");
		//System.out.println("Page navigated");
	    //throw new io.cucumber.java.PendingException();
	}

	@And("I entered username and password")
	public void i_entered_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement username = driver.findElement(By.xpath("//input[@name='userName']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		username.sendKeys("mercury");
		password.sendKeys("mercury");
		//System.out.println("Data entered");
	    //throw new io.cucumber.java.PendingException();
	}

	@When("I entered {string} and {string}")
	public void i_entered_and(String unm, String pwd) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement username = driver.findElement(By.xpath("//input[@name='userName']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		username.sendKeys(unm);
		password.sendKeys(pwd);
		//System.out.println(unm + " " + pwd);
	    //throw new io.cucumber.java.PendingException();
	}

	
	@And("I clicked signin button")
	public void i_clicked_signin_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement signinButton = driver.findElement(By.xpath("//input[@name='submit']"));
		signinButton.click();
		//System.out.println("Button click");
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Its navigated to the HomePage")
	public void its_navigated_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement ref = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"));
		Assert.assertEquals(ref.getText(), "Login Successfully");
		//System.out.println("Home page launched");
	    //throw new io.cucumber.java.PendingException();
	}
	
	@And("I entered correct username")
	public void i_entered_correct_username() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement username = driver.findElement(By.xpath("//input[@name='userName']"));
		username.sendKeys("mercury");
		//System.out.println("Correct username entered");
	}
	
	@But("Invalid pwd")
	public void Invalid_pwd() {
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("hello");
	    //System.out.println("wrong Pwd entered");
	}
	
	@When("I entered following details")
	public void i_entered_following_details(DataTable dataTable) {
		List<List<String>> ele=dataTable.cells();
//		System.out.println(ele.get(0).get(0));
//		System.out.println(ele.get(0).get(1));
//		System.out.println(ele.get(1).get(0));
//		System.out.println(ele.get(1).get(1));
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(ele.get(1).get(0));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ele.get(1).get(1));
			
	}
	
	@When("I insert {string} and {string}")
	public void i_insert_and(String unm, String pwd) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(unm);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
	    //throw new io.cucumber.java.PendingException();
	}
	
	@Then("Its navigated to the HomePage {string}")
	public void its_navigated_to_the_home_page(String result) {
	    // Write code here that turns the phrase above into concrete actions
		if(result.equalsIgnoreCase("pass")) {
			WebElement ref = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"));
			Assert.assertEquals(ref.getText(), "Login Successfully");
		}
		else {
			WebElement ref = driver.findElement(By.xpath("//span[normalize-space()='Enter your userName and password correct']"));
			Assert.assertEquals(ref.getText(), "Enter your userName and password correct");
		}
	    //throw new io.cucumber.java.PendingException();
	}
	
	@Then("Its navigated to the error msg")
	public void itas_navigated_to_the_errorpage() {
		WebElement ref = driver.findElement(By.xpath("//span[normalize-space()='Enter your userName and password correct']"));
		Assert.assertEquals(ref.getText(), "Enter your userName and password correct");
	    //System.out.println("Login failed..");
	}
}
