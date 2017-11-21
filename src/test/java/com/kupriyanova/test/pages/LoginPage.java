package com.kupriyanova.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    //находим поле для ввода логина
    @FindBy(id="mailbox:login")
    private WebElement loginField;

    //находим поле для ввода пароля
    @FindBy(id="mailbox:password")
    private WebElement passwordField;

    //находим кнопку "Войти"
    @FindBy(xpath="//input[@class='o-control']")
    private WebElement loginButton;

    //получаем логин
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    //получаем пароль
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    //кликаем кнопку
    public void clickLoginButton() {
        loginButton.click();
    }
}
