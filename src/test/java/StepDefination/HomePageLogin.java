package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageLogin {
private	WebDriver driver;
@Given("navigate actitime url")
public void navigate_actitime_url() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(option);
    driver.get("https://demo.actitime.com/login.do");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@When("insert valid cradencial username and password")
public void insert_valid_cradencial_username_and_password() {
   driver.findElement(By.name("username")).sendKeys("admin"+Keys.TAB+"manager");
   
}

@When("click on login button")
public void click_on_login_button() {
driver.findElement(By.id("loginButton")).click();  
}

@Then("homepage should be displayed")
public void homepage_should_be_displayed() {
	WebDriverWait wait=new WebDriverWait(driver ,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.titleContains("Enter Time-Track"));
	
}

@Then("logout app")
public void logout_app() {
   driver.findElement(By.id("logoutLink")).click();
   driver.close();
}

}
