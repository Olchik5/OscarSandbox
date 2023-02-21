package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.data.BookData;
import com.telran.oscar.data.ConfirmationData;
import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BooksPageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginOrRegisterLink();
        new LoginOrRegisterPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);
        new SidePanelPage(driver).clickOnBooksLink();
    }

    @Test
    public void nextNavigationTest() {
        new BooksPage(driver).clickOnNextButton();
        Assert.assertTrue(new BooksPage(driver).getPageNumberText().contains(BookData.NEXT_PAGE));
    }

    @Test
    public void PreviousNavigationTest() {
        new BooksPage(driver).clickOnNextButton().clickOnPreviousButton();
        Assert.assertTrue(new BooksPage(driver).getPageNumberText().contains(BookData.PREVIOUS_PAGE));

    }

    @Test
    public void addToBasketButtonTest() {
        new AllProductsPage(driver).clickOnAddToBasketButton();
        new BooksPage(driver).verifyTextAddedToBasket(ConfirmationData.CONFIRMATION_ADDED_TO_BASKET);
        new BooksPage(driver).verifyTextBenefitOffer(ConfirmationData.CONFIRMATION_BENEFIT);
    }

    @Test
    public void addToBasketByBookTitleLink () {
        new BooksPage(driver).clickOnTitleBookLink().clickOnAddToBasketButtonByBookTitle();
        new BooksPage(driver).verifyTextAddedToBasket(ConfirmationData.CONFIRMATION_ADDED_TO_BASKET);

    }
    @Test
    public void writeBookReviewTest(){
        new BooksPage(driver).clickOnThePictureOfBook().clickOnWriteReviewButton()
                .fillInLeaveProductReviewForm(BookData.TITLE, BookData.BODY).clickOnSaveReviewButton();
        Assert.assertTrue(new BooksPage(driver).getConfirmOfReviewText().contains(ConfirmationData.CONFIRMATION_OF_REVIEW));


    }
}
