package sauceDemo.cucumber.stepDef;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import sauceDemo.config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class login extends env {

    @Given("Login Page Swab Lags")
    public void login_page_swab_lags() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("input username")
    public void input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input password")
    public void input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button")
    public void click_login_button() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("user in on dashboard page")
    public void user_in_on_dashboard_page() {
        String productText = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals("Products", productText);
    }

    @And("input invalid password")
    public void input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("123451");
    }

    @Then("user get error message")
    public void user_get_error_message() {
        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorLogin);
    }
}
