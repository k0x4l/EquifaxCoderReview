package com.equifax.pages;

import com.equifax.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchPage {

    public AmazonSearchPage(WebDriver driver) { PageFactory.initElements(driver, this);}

    @FindBy(id = "twotabsearchtextbox")
    public  WebElement searchBox;

    @FindBy (id = "nav-search-submit-button")
    public WebElement goButton;

    @FindBy (xpath = "//div[@data-index='1']")
    public WebElement firstItem;

    @FindBy (xpath = "//span[@class='a-price'][1]")
    public WebElement firstItemPrice;

}


