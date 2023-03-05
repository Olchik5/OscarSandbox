package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage{

    @FindBy(css = ".page-header")
    WebElement itemTitle;

    @FindBy(xpath = "//a[@href='?page=2']")
    WebElement nextButton;

    @FindBy(xpath = "//a[contains(text(),'previous')]")
    WebElement previousButton;

    @FindBy(css = ".page-header")
    WebElement books;

    @FindBy(css = ".page-item.disabled")
    WebElement nextPage;

    @FindBy(xpath = "//strong[text()=\"The shellcoder's handbook\"]")
    WebElement bookAdded;

    @FindBy(xpath = "//strong[.='Deferred benefit offer']")
    WebElement benefit;

    @FindBy(xpath = "//li[1]/article[1]/h3[1]")
    WebElement bookTitle;

    @FindBy(css = ".btn.btn-lg.btn-primary.w-100")
    WebElement addToBasketButtonByTitleBook;

    @FindBy(xpath = "//img[@src='/media/cache/e4/e0/e4e0cd986cc731738c928cc612ffb8f7.jpg']")
    WebElement picture;

    @FindBy(id = "write_review")
    WebElement writeReview;

    @FindBy(id = "id_title")
    WebElement title;

    @FindBy(id = "id_body")
    WebElement body;

    @FindBy(xpath = "//div[@class='star-rating ']/i[4]")
    WebElement score;

    @FindBy(xpath = "//button[text()='Save review']")
    WebElement saveReview;

    @FindBy(css = ".alertinner.wicon")
    WebElement confirmOfReview;

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public String getItemTitleText() {
        return itemTitle.getText();
    }

    public BooksPage clickOnNextButton() {
        click(nextButton);
        return this;
    }

    public BooksPage clickOnPreviousButton() {
        click(previousButton);
        return this;
    }

    public String getPageNumberText() {
        return nextPage.getText();
    }

    public BooksPage verifyTextAddedToBasket(String text) {
        if (bookAdded.getText().equalsIgnoreCase(text)) {
            bookAdded.getText();
        }
        return this;
    }

    public BooksPage verifyTextBenefitOffer(String text) {
        if (benefit.getText().equalsIgnoreCase(text)) {
            benefit.getText();
        }
        return this;
    }

    public BooksPage clickOnTitleBookLink() {
        click(bookTitle);
        return this;
    }

    public BooksPage clickOnAddToBasketButtonByBookTitle() {
        click(addToBasketButtonByTitleBook);
        return this;
    }

    public BooksPage clickOnThePictureOfBook() {
        click(picture);
        return this;
    }

    public BooksPage clickOnWriteReviewButton() {
        click(writeReview);
        return this;
    }

    public BooksPage fillInLeaveProductReviewForm(String bTitle, String reviewBody) {
        type(title, bTitle);
        chooseScore();
        type(body, reviewBody);
        return this;
    }

    private void chooseScore() {
        click(score);
    }

    public BooksPage clickOnSaveReviewButton() {
        click(saveReview);
        return this;
    }

    public String getConfirmOfReviewText() {
        return confirmOfReview.getText();
    }
}
