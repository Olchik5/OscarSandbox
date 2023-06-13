package com.telran.oscar.pages;

import com.telran.oscar.data.UserData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//a[@href='/en-gb/checkout/']")
    WebElement proceedToCheckout;

    @FindBy (id = "id_first_name")
    WebElement firstName;

    @FindBy (id = "id_last_name")
    WebElement lastName;

    @FindBy (id = "id_line1")
    WebElement firstLineOfAddress;

    @FindBy(id = "id_line4")
    WebElement city;

    @FindBy (id = "id_postcode")
    WebElement postCode;

    @FindBy (id = "id_country")
    WebElement country;

    @FindBy (css = ".btn.btn-lg.btn-primary")
    WebElement continueButton;

    @FindBy(id = "view_preview")
    WebElement continueViewPreviewButton;

    @FindBy(id = "place-order")
    WebElement placeOrderButton;

    @FindBy(css = ".sub-header:nth-child(2)")
    WebElement shippingHeader;

    @FindBy(xpath = "//p//strong")
    WebElement orderConfirmNumber;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage clickOnProceedToCheckout() {
        click(proceedToCheckout);
        return new CheckoutPage(driver);
    }

    public CheckoutPage enterRequiredAddressFields(String fname, String lName, String firstAddress,
                                                   String userCity, String zipcode )  {
        type(firstName, fname);
        type(lastName, lName);
        type(firstLineOfAddress, firstAddress);
        type(city, userCity);
        type(postCode, zipcode);
        enterCountry(UserData.COUNTRY);
        click(continueButton);
        return this;
    }

    public CheckoutPage enterCountry(String userCountry) {
        click(country);
        country.sendKeys(userCountry);
        country.sendKeys(Keys.ENTER);
        return this;
    }

    public CheckoutPage clickOnContinueButton() {
        click(continueViewPreviewButton);
        return this;
    }

    public CheckoutPage clickOnPlaceOrderButton() {
        click(placeOrderButton);
        return this;
    }

    public String getShippingAddressText() {
        return shippingHeader.getText();
    }

    public String getOrderConfirmNumber() {
        String text = orderConfirmNumber.getText();
        System.out.println(text);
        return text;
    }
}
