package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import sauceDemo.config.env;

import java.util.concurrent.TimeUnit;

public class logout extends env {

    @Given("user click sidebar menu")
    public void userClickSidebarMenu() {
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }

    @When("user click Logout button")
    public void userClickLogoutButton() {
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
    }

    @Then("user back to login page")
    public void userBackToLoginPage() {
        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }
}

