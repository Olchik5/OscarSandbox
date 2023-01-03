package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UIHomePage extends BasePage{

    @FindBy(css = ".col-sm-6.h1")
    List<WebElement> logoLV;

    @FindBy(xpath = "//select[@name='language']")
    List<WebElement> language;

    @FindBy(css = ".btn-outline-secondary.ml-2")
    List<WebElement> switchLanguageButton;

    @FindBy(id = "login_link")
    List<WebElement> login;

    @FindBy(xpath = "//*[.='Basket total:']")
    List<WebElement> basketTotalText;

    @FindBy(xpath = "//button[.='View basket']")
    List<WebElement> viewBasket;

    @FindBy(css = ".dropdown-toggle-split")
    List<WebElement> basketDropdownMenuButton;

    @FindBy(css = ".nav-link.dropdown-toggle")
    List<WebElement> browseStoreDropdownMenu;

    @FindBy(xpath = "//input[@placeholder='Search']")
    List<WebElement> searchField;

    @FindBy(css = ".my-sm-0")
    List<WebElement> searchButton;

    @FindBy(xpath = "//aside/div/ul/li[1]/a[1]")
    List<WebElement> clothingLink;

    @FindBy(xpath = "//aside/div/ul/li[2]/a[1]")
    List<WebElement> booksLink;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/category/books/fiction_3/']")
    List<WebElement> fictionBooksLink;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/category/books/fiction/computers-in-literature_4/']")
    List<WebElement> computersInLiteratureLink;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/category/books/non-fiction_5/']")
    List<WebElement> nonFictionLink;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/category/books/non-fiction/essential-programming_6/']")
    List<WebElement> essentialProgrammingLink;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/category/books/non-fiction/hacking_7/']")
    List<WebElement> hackingLink;

    @FindBy(xpath = "//form[@action='/en-gb/basket/add/209/']")
    List<WebElement> buttonsAddToBasket;

    @FindBy(xpath = "//img[@src='/media/cache/e4/e0/e4e0cd986cc731738c928cc612ffb8f7.jpg']")
    List<WebElement> imagesOnTheHomePage;

    @FindBy(xpath = "//a[@href='?page=2']")
    List<WebElement> nextButton;

    @FindBy(css = ".btn-info:nth-child(3)")
    List<WebElement> viewBasketButton;

    @FindBy(css = ".btn-info:nth-child(4)")
    List<WebElement> checkoutNowButton;


    public UIHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOscarLogoPresent() {
        return isElementPresent(logoLV);
    }

    public boolean isChooseLanguageFieldPresent() {
        return isElementPresent(language);
    }

    public boolean isSwitchLanguageButtonPresent() {
        return isElementPresent(switchLanguageButton);
    }

    public boolean isLoginOrRegistrButtonPresent() {
        return isElementPresent(login);
    }

    public boolean isBasketTotalTextPresent() {
        return isElementPresent(basketTotalText);
    }

    public boolean isBasketButtonPresent() {
        return isElementPresent(viewBasket);
    }

    public boolean isViewBasketDropdownMenuButtonPresent() {
        return isElementPresent(basketDropdownMenuButton);
    }

    public boolean isBrowseStoreDropdownMenuPresent() {
        return isElementPresent(browseStoreDropdownMenu);
    }

    public boolean isSearchFieldPresent() {
        return isElementPresent(searchField);
    }

    public boolean isSearchButtonPresent() {
        return isElementPresent(searchButton);
    }

    public boolean isClothingLinkPresent() {
        return isElementPresent(clothingLink);
    }

    public boolean isBooksLinkPresent() {
        return isElementPresent(booksLink);
    }

    public boolean isFictionLinkPresent() {
        return isElementPresent(fictionBooksLink);
    }

    public boolean isComputerAndLiteratureLinkPresent() {
        return isElementPresent(computersInLiteratureLink);
    }

    public boolean isNonFictionLinkPresent() {
        return isElementPresent(nonFictionLink);
    }

    public boolean isEssentialProgrammingLinkPresent() {
        return isElementPresent(essentialProgrammingLink);
    }

    public boolean isHackingLinkPresent() {
        return isElementPresent(hackingLink);
    }

    public boolean isButtonAddToBasketPresent() {
        return isElementPresent(buttonsAddToBasket);
    }

    public boolean isImageOnTheHomePagePresent() {
        return isElementPresent(imagesOnTheHomePage);
    }

    public boolean isNextButtonsPresent() {
        return isElementPresent(nextButton);
    }

    public boolean isViewBasketButtonPresent() {
        return isElementPresent(viewBasketButton);
    }

    public boolean isCheckoutNowButtonPresent() {
        return isElementPresent(checkoutNowButton);
    }

}
