
package com.cucumber.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.pageobjects.Loginpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

    WebDriver driver;
    Loginpage lp;

    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        lp = new Loginpage(driver);
    }


    @When("User opens URL {string}")
    public void user_opens_url(String url) {

        driver.get(url);

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.titleIs("The Internet")
        );

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
    }


    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(
            String email,
            String password) {

        lp.setUserName(email);

        lp.setPassword(password);
    }


    @When("Click on Login")
    public void click_on_login() {

        lp.clickLogin();
    }


    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {

        Assert.assertEquals(driver.getTitle(), title);
    }


    @When("User click on Log out link")
    public void user_click_on_log_out_link() {

        lp.clickLogout();
    }


    @Then("close browser")
    public void close_browser() {

        driver.quit();
    }
}

