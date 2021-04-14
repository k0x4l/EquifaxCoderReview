package com.equifax.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage(WebDriver driver) { PageFactory.initElements(driver, this);}

    @FindBy (id = "ap_email")
    public WebElement userName;

    @FindBy (id = "continue")
    public WebElement continueButton;

    @FindBy (id = "ap_password")
    public WebElement password;

    @FindBy (id = "signInSubmit")
    public WebElement signInButton;


}
