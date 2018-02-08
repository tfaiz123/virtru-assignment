package com.virtru.assignment.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GmailInboundEmailPage {

    private WebDriver driver;

    public GmailInboundEmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnUnlockLink() {
        WebElement unlockLink = this.driver.findElement(By.linkText("Unlock Message"));
        unlockLink.click();
    }

    public void clickOnVerifyMeLink() {
        List<WebElement> expandEmailLinks = this.driver.findElements(By.cssSelector("[data-tooltip~=content]"));
        expandEmailLinks.get(0).click();
        WebElement unlockLink = this.driver.findElement(By.linkText("VERIFY ME"));
        unlockLink.click();
    }
}
