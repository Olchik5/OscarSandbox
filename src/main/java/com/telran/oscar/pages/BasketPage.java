package com.telran.oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{
    
    @FindBy(css = ".btn-group")
    WebElement viewBasketHeader;

    @FindBy(css = ".row:nth-child(1).justify-content-between button:nth-child(1)")
    WebElement viewBasketLVButtonHeader;

    @FindBy(id = "content_inner")
    WebElement emptyBasket;

    @FindBy(xpath = "//input[@type='number']")
    WebElement quantityInBasket;

    @FindBy(css = ".alert-warning")
    WebElement noDeferredBenefit;

    @FindBy(css = ".alert-info")
    WebElement alertTotalIsNow;

    @FindBy(css = ".basket-line-actions")
    WebElement removeButton;

    @FindBy(css = ".alert-info:nth-child(2)")
    WebElement isEmptyBasketMessageText;

    @FindBy(css = "div:nth-child(1) > p:nth-child(1)")
    WebElement emptyBasketText;

    @FindBy(id = "id_form-0-quantity")
    WebElement quantity;

    @FindBy(css = ".input-group-append")
    WebElement updateQuantity;

    @FindBy(css = ".basket-items:nth-child(6) :nth-child(4)")
    WebElement priceForOne;

    @FindBy(css = ".basket-items:nth-child(6) :nth-child(5)")
    WebElement priceForSeveral;

    @FindBy(css = ".total .price_color")
    WebElement priceTotal;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage clickOnViewBasketButton() {
        click(viewBasketHeader);
        return this;
    }

    public void clickOnViewBasketLVButton() {
        click(viewBasketLVButtonHeader);
    }

    public String getBasketIsEmptyText() {
        return emptyBasket.getText();
    }

    public String getQuantityInBasketText() {
        System.out.println(quantityInBasket.getAttribute("value"));
        return quantityInBasket.getAttribute("value");
    }

    public void increaseQuantity() {
        driver.findElement(By.id("id_form-0-quantity")).sendKeys(Keys.ARROW_UP);
    }

    public String getInformationText() {
        return noDeferredBenefit.getText();
    }

    public String getBasketTotalIsNowText() {
        return alertTotalIsNow.getText();
    }

    public void removeQuantity() {
        click(removeButton);
    }

    public String getConfirmMessageBasketIsNowEmptyText() {
        pause(2000);
        return isEmptyBasketMessageText.getText();
    }

    public String getConfirmBasketIsEmptyText() {
        pause(2000);
        return emptyBasketText.getText();
    }

    public BasketPage enterQuantity(String n) {
        type(quantity, n);
        click(updateQuantity);
        pause(2000);
        return this;
    }

    public void decreaseQuantity() {
        driver.findElement(By.id("id_form-0-quantity")).sendKeys(Keys.ARROW_DOWN);
    }

    public double getPrice(WebElement element) {
        double number = Double.parseDouble(element.getText().replace("£", ""));
        return number;
    }

    public double getPriceForOneItem() {
        double element = getPrice(priceForOne);
        return element;
    }

    public double getPriceForSeveralItems() {
        double element = getPrice(priceForSeveral);
        return element;
    }

    public double getTotalPrice() {
        double element = getPrice(priceTotal);
        pause(5000);
        return element;
    }
}
