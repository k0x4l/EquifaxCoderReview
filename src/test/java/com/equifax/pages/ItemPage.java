package com.equifax.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    public ItemPage(WebDriver driver) { PageFactory.initElements(driver, this);}

    @FindBy(id = "newBuyBoxPrice")
    public WebElement itemPriceAfterSelect;

    @FindBy (id = "add-to-cart-button")
    public WebElement addToCartButton;
}
