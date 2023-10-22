package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sauceDemo.config.env;

import java.util.concurrent.TimeUnit;

public class checkout extends env {
    @Given("user click cart")
    public void userClickCart() {
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
    }

    @When("user click button Checkout")
    public void userClickButtonCheckout() {
        driver.findElement(By.xpath("//button[@data-test='checkout']")).click();
    }

    @And("user input First Name valid")
    public void userInputFirstNameValid() {
       driver.findElement(By.id("first-name")).sendKeys("Margaretta");
   }

    @And("user input Last Name valid")
    public void userInputLastNameValid() {
        driver.findElement(By.id("last-name")).sendKeys("Simanjuntak");
    }

    @And("user input Zipcode Code valid")
    public void userInputZipcodeCodeValid() {
        driver.findElement(By.id("postal-code")).sendKeys("12345");
    }

    @And("user click button Continue")
    public void userClickButtonContinue() {
            driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @And("user click Finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//button[@data-test='finish']")).click();
    }

    @Then("user can create checkout information and the application displays the Checkout: Complete! page")
    public void userCanCreateCheckoutInformationAndTheApplicationDisplaysTheCheckoutCompletePage() {
        String completecheckout = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Checkout: Complete!", completecheckout);
    }

    @And("user input Zipcode empty")
    public void userInputZipcodeEmpty() {
        driver.findElement(By.id("postal-code")).sendKeys("");
    }

    @Then("user cannot proceed to page Checkout: Overview page and cannot continue the checkout process")
    public void userCannotProceedToPageCheckoutOverviewPageAndCannotContinueTheCheckoutProcess() {
        String completecheckout = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals("Error: Postal Code is required", completecheckout);
    }
}

