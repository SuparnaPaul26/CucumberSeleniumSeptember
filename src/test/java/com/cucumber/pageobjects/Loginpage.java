
package com.cucumber.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {

    WebDriver driver;
    WebDriverWait wait;

    public Loginpage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(css = "button[type='submit']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[contains(@href,'/logout')]")
    WebElement lnkLogout;


    public void setUserName(String username) {

        wait.until(ExpectedConditions.visibilityOf(txtUsername));

        txtUsername.clear();
        txtUsername.sendKeys(username);
    }


    public void setPassword(String password) {

        wait.until(ExpectedConditions.visibilityOf(txtPassword));

        txtPassword.clear();
        txtPassword.sendKeys(password);
    }


    public void clickLogin() {

        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));

        btnLogin.click();
    }


    public void clickLogout() {

        wait.until(ExpectedConditions.elementToBeClickable(lnkLogout));

        lnkLogout.click();
    }
}
