package sauceDemo.cucumber.stepDef;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.config.env;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks  extends env {
    @Before
    public void before() {
        System.out.println("===============Test Started=====================");
    }

    @After
    public void after(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/src/test/sauceDemo/cucumber/resources/screenshots/" + scenario.getName() + ".png"));
        }
        driver.quit();
    }
}