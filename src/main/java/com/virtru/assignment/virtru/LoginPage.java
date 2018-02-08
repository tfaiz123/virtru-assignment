package com.virtru.assignment.virtru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginWithEmail(String email) {
        WebElement emailLink = this.driver.findElement(By.linkText(email));
        emailLink.click();
    }

    public void clickOnSendMeEmail() {
        WebElement sendMeAnEmail = this.driver.findElement(By.className("sendEmailButton"));
        sendMeAnEmail.click();
    }
}
