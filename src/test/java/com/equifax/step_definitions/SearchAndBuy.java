package com.equifax.step_definitions;

import com.equifax.pages.AmazonSearchPage;
import com.equifax.pages.CartPage;
import com.equifax.pages.ItemPage;
import com.equifax.pages.SignInPage;
import com.equifax.utilities.ConfigurationReader;
import com.equifax.utilities.Driver;
import com.equifax.utilities.PriceConverter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SearchAndBuy {

    WebDriver driver = Driver.getDriver();
    AmazonSearchPage amazonSearchPage = new AmazonSearchPage(driver);
    ItemPage itemPage = new ItemPage(driver);
    CartPage cartPage = new CartPage(driver);
    SignInPage signInPage = new SignInPage(driver);

    Float firstItemPrice;
    Float itemPriceAfterSelect;
    Float itemPriceBeforeCheckout;

    @Given("Visit amazon.com Page")
    public void visitAmazonComPage() {
        driver.get("http://amazon.com");
    }

    @Then("Search for Book qa testing for beginners")
    public void searchForBookQaTestingForBeginners() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        amazonSearchPage.searchBox.sendKeys("qa testing for beginners");
        amazonSearchPage.goButton.click();

    }

    @And("Click on {int}st item in the listed results")
    public void clickOnStItemInTheListedResults(int arg0) {
        String firstItemPriceValue = amazonSearchPage.firstItemPrice.getText();
        firstItemPrice = PriceConverter.getPrice(firstItemPriceValue);
        System.out.println("firstItemPriceValue = " + PriceConverter.getPrice(firstItemPriceValue));
        amazonSearchPage.firstItem.click();
    }

    @And("Before Click on add to cart Add to Cart asset price from Step{int}")
    public void beforeClickOnAddToCartAddToCartAssetPriceFromStep(int arg0) {
        String itemPriceValueAfterSelect = itemPage.itemPriceAfterSelect.getText();
        itemPriceAfterSelect = PriceConverter.getPrice(itemPriceValueAfterSelect);
        System.out.println("itemPriceAfterSelect = " + itemPriceAfterSelect);
        Assert.assertEquals(firstItemPrice, itemPriceAfterSelect);
    }

    @Then("Click on Add to Cart")
    public void clickOnAddToCart() {
        itemPage.addToCartButton.click();
    }

    @And("Before Click on Proceed to Checkout asset price from Step{int}")
    public void beforeClickOnProceedToCheckoutAssetPriceFromStep(int arg0) {
        String itemPriceValueBeforeCheckout = cartPage.itemPriceBeforeCheckOut.getText();
        itemPriceBeforeCheckout = PriceConverter.getPrice(itemPriceValueBeforeCheckout);
        System.out.println("itemPriceBeforeCheckout = " + itemPriceBeforeCheckout);
        Assert.assertEquals(firstItemPrice,itemPriceBeforeCheckout);
    }

    @Then("Click on proceed to checkout")
    public void clickOnProceedToCheckout() {
        cartPage.proceedToCheckoutButton.click();
    }

    @And("On the checkout page assert price from Step{int}")
    public void onTheCheckoutPageAssertPriceFromStep(int arg0) {
        signInPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
        signInPage.continueButton.click();
        signInPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        signInPage.signInButton.click();

        //The steps are coming includes a lot of personal information, with any valid credentials, I can proceed it.
    }
}
