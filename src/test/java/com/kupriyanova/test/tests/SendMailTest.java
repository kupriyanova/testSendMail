package com.kupriyanova.test.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import com.kupriyanova.test.pages.LoginPage;
import com.kupriyanova.test.pages.MailPage;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SendMailTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MailPage mailPage;

    @BeforeClass //подготовка окружения
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/kev/IdeaProjects/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru");
    }

    @Test //тест авторизации
    public void userLogin() {
        loginPage.inputLogin("ek.kupriyanova");
        loginPage.inputPassword("TestPassword");
        loginPage.clickLoginButton();
    }

    @Test //тест отправки
    public void sendMessage() {
        mailPage.clickNewSend();
        mailPage.inputAddress("ek.kupriyanova@gmail.com");
        mailPage.inputSubject("Test Subject");
        mailPage.switchFrame();
        mailPage.inputTextMail("Test TexT Mail");
        mailPage.switchDefault();
        mailPage.clickSend();
    }

    @AfterClass //уборка
    public static void quitPage() {
        driver.quit();
    }
}
