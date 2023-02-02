package com.telran.oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "login_link")
    WebElement LoginOrRegister;

    @FindBy(css = ".alertinner.wicon")
    WebElement confirmationOfRegistration;

    @FindBy(id = "logout_link")
    WebElement logoutLink;

    @FindBy(css = ".alertinner.wicon")
    WebElement getConfirmationOfLogin;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/']")
    WebElement allProducts;

    @FindBy(xpath = "//*[@href='/en-gb/']")
    WebElement logo;

    @FindBy(xpath = "//*[.='Welcome!']")
    WebElement oscarLogo;

    @FindBy(xpath = "//*[@href='/en-gb/catalogue/']")
    WebElement logoLV;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginOrRegisterPage clickOnLoginOrRegisterLink() {
        click(LoginOrRegister);
        return new LoginOrRegisterPage(driver);
    }

    public HomePage verifyTextThanksForRegistering(String text) {
        if (confirmationOfRegistration.getText().equalsIgnoreCase(text)) {
            System.out.println("Correct: " + confirmationOfRegistration.getText());
        } else {
            System.out.println("Incorrect: " + confirmationOfRegistration.getText());
        }
        return this;
    }

    public HomePage logOut() {
        click(logoutLink);
        return this;
    }

    public HomePage verifyTextWelcomeBack(String text) {
        getConfirmationOfLogin.getText().equalsIgnoreCase(text);
        System.out.println(getConfirmationOfLogin.getText());
        return this;
    }

    public AllProductsPage clickOnAllProductsLink() {
        click(allProducts);
        return new AllProductsPage(driver);
    }

    public HomePage clickOnLogo() {
        click(logo);
        return this;
    }

    public String getConfirmHomePageText() {
        return oscarLogo.getText();
    }

    public HomePage addItemToBasket(int number) {
        driver.findElement(By.cssSelector(".col-sm-6:nth-child("+ number +") .btn")).click();
        return this;
    }

    public HomePage clickOnLogoLV() {
        click(logoLV);
        return this;
    }
}
