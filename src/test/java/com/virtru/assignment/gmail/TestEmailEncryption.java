package com.virtru.assignment.gmail;

import com.virtru.assignment.util.TestUtils;
import com.virtru.assignment.virtru.LoginPage;
import com.virtru.assignment.virtru.VerifyPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestEmailEncryption {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        this.driver = TestUtils.getDriver();
        this.driver.get("http://www.gmail.com");
    }

    @Test
    public void testTitle() throws Exception {
        GmailLoginPage gmailLoginPage = new GmailLoginPage(this.driver);
        gmailLoginPage.enterUserName("thomas.qa.02");
        gmailLoginPage.enterPassword("V1rtruA$$ignm3nt2");

        InboxListPage inboxListPage = new InboxListPage(this.driver);
        inboxListPage.clickOnFirstEmailFrom("Thomas Bibi");

        GmailInboundEmailPage emailPage = new GmailInboundEmailPage(this.driver);
        emailPage.clickOnUnlockLink();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        LoginPage virtruLoginPage = new LoginPage(this.driver);
        virtruLoginPage.loginWithEmail("thomas.qa.02@gmail.com");
        virtruLoginPage.clickOnSendMeEmail();

        Thread.sleep(1000);

        this.driver.switchTo().window(tabs.get(0));

        this.driver.get("https://mail.google.com/mail/u/0/#inbox");
        this.driver.navigate().refresh();
        Thread.sleep(1000);

        inboxListPage = new InboxListPage(this.driver);
        Thread.sleep(1000);
        inboxListPage.clickOnFirstEmailFrom("verify@virtru.com");

        emailPage = new GmailInboundEmailPage(this.driver);
        emailPage.clickOnVerifyMeLink();

        tabs = new ArrayList<String>(driver.getWindowHandles());
        this.driver.switchTo().window(tabs.get(2));

        VerifyPage verifyPage = new VerifyPage(this.driver);
        Thread.sleep(1000);

        assertEquals("The subject didn't match what was expected.", "Virtru Assignment", verifyPage.getSubject());
        assertEquals("The body didn't match what was expected.", "This is a sample message", verifyPage.getBody());
    }

    @After
    public void tearDown() throws Exception {
        this.driver.close();
    }
}