package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import sauceDemo.config.env;

public class product extends env {
    @And("user click button Add to Chart")
    public void userClickButtonAddToChart() {
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
    }

    @Then("the product will be add to cart")
    public void theProductWillBeAddToCart() {

        String addCart = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        Assert.assertEquals("1", addCart);
    }

    @And("Button Add to cart will be change to button Remove")
    public void buttonAddToCartWillBeChangeToButtonRemove() {
        String removerCart = driver.findElement(By.xpath("//button[@data-test='remove-sauce-labs-backpack']")).getText();
        Assert.assertEquals("Remove", removerCart);
    }
}
