package com.virtru.assignment.virtru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyPage {

    private WebDriver driver;

    public VerifyPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSubject() {
        WebElement subjectElement = this.driver.findElement(By.className("subject"));
        return subjectElement.getText();
    }

    public String getBody() {
        WebElement subjectElement = this.driver.findElement(By.className("tdf-body"));
        return subjectElement.getText();
    }
}
