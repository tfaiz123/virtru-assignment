package com.virtru.assignment.gmail;

import com.virtru.assignment.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailLoginPage {

    private WebDriver driver;

    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String userName) {
        enterTextInElementById("identifierId", userName);
        this.driver.findElement(By.id("identifierNext")).click();
    }

    public void enterPassword(String password) {
        enterTextInElementByName("password", password);
        this.driver.findElement(By.id("passwordNext")).click();
    }

    public String title() {
        return this.driver.getTitle();
    }

    private void enterTextInElementById(String elementId, String text) {
        WebElement idElement = this.driver.findElement(By.id(elementId));
        idElement.sendKeys(text);
    }

    private void enterTextInElementByName(String elementName, String text) {
        WebElement idElement = this.driver.findElement(By.name(elementName));
        idElement.sendKeys(text);
    }
}
