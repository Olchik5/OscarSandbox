package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends BasePage{

    @FindBy(xpath = "//form[@action='/en-gb/basket/add/209/']")
    WebElement addToBasket;

    @FindBy(css = ".alert-info a:nth-child(3)")
    WebElement viewBasketButton;

    public AllProductsPage(WebDriver driver) {
        super(driver);

    }

    public AllProductsPage clickOnAddToBasketButton() {
        click(addToBasket);
        return this;
    }

    public BasketPage clickOnViewBasketButton() {
        click(viewBasketButton);
        return new BasketPage(driver);
    }
}
