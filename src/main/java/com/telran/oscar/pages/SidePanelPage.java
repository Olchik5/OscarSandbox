package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends BasePage{

    @FindBy(xpath = "//aside/div/ul/li[1]/a[1]")
    WebElement ClothingLink;

    @FindBy(xpath = "//aside/div/ul/li[2]/a[1]")
    WebElement booksLink;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/category/books/fiction_3/']")
    WebElement fictionBooksLink;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/category/books/fiction/computers-in-literature_4/']")
    WebElement computersInLiteratureLink;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/category/books/non-fiction_5/']")
    WebElement nonFictionLink;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/category/books/non-fiction/essential-programming_6/']")
    WebElement essentialProgrammingLink;

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/category/books/non-fiction/hacking_7/']")
    WebElement hackingLink;

    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    public ClothingPage clickOnClothingLink() {
        click(ClothingLink);
        return new ClothingPage(driver);
    }

    public BooksPage clickOnBooksLink() {
        click(booksLink);
        return new BooksPage(driver);
    }

    public BooksPage clickOnFictionBooksLink() {
        click(fictionBooksLink);
        return new BooksPage(driver);
    }

    public BooksPage clickOnComputersInLiteratureBooksLink() {
        click(computersInLiteratureLink);
        return new BooksPage(driver);
    }

    public BooksPage clickOnNonFictionBooksLink() {
        click(nonFictionLink);
        return new BooksPage(driver);
    }

    public BooksPage clickOnEssentialProgrammingBooksLink() {
        click(essentialProgrammingLink);
        return new BooksPage(driver);
    }

    public BooksPage clickOnHackingBooksLink() {
        click(hackingLink);
        return new BooksPage(driver);
    }
}
