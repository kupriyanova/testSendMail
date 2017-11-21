package com.kupriyanova.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage {

    public MailPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    //находим кнопку "Написать письмо"
    @FindBy(linkText="Написать письмо")
    private WebElement newSendButton;

    //находим поле для ввода адреса
    @FindBy(xpath="//textarea[@tabindex='4']")
    private WebElement addressMail;

    //поле для ввода темы
    @FindBy(name="Subject")
    private WebElement mailSubject;

    //поле для ввода текста письма
    @FindBy(id="tinymce")
    private WebElement mailBody;

    //находим кнопку "Отправить"
    @FindBy(xpath="//div[@data-name='send']")
    private WebElement sendButton;

    //клик для создания письма
    public void clickNewSend() {
        newSendButton.click();
    }

    //получаем адрес
    public void inputAddress(String address) {
        addressMail.sendKeys(address);
    }

    //получаем текст для темы письма
    public void inputSubject(String subject) {
        mailSubject.sendKeys(subject);
    }

    //переключаемся в frame тела письма
    public void switchFrame(){
        driver.switchTo().frame(0);
    }

    //получаем текст тела письма
    public void inputTextMail(String textmail) {
        mailBody.sendKeys(textmail);
    }

    //возвращаемся из frame
    public void switchDefault(){
        driver.switchTo().defaultContent();
    }

    //клик на кнопку "Отправить"
    public void clickSend() {
        sendButton.click();
    }
}
