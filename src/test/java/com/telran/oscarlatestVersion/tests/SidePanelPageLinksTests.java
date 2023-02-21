package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.data.PageTitleData;
import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SidePanelPageLinksTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).clickOnLoginOrRegisterLink();
        new LoginOrRegisterPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);

    }

    @Test
    public void isClothingLinkClickableTest() {
        new SidePanelPage(driver).clickOnClothingLink();
        Assert.assertTrue(new ClothingPage(driver).getTextClothing().contains(PageTitleData.CLOTHING));

    }

    @Test
    public void isBooksLinkClickableTest() {
        new SidePanelPage(driver).clickOnBooksLink();
        Assert.assertTrue(new BooksPage(driver).getItemTitleText().contains(PageTitleData.BOOKS));

    }

    @Test
    public void isFictionBooksLinkClickableTest() {
        new SidePanelPage(driver).clickOnFictionBooksLink();
        Assert.assertTrue(new BooksPage(driver).getItemTitleText().contains(PageTitleData.FICTION));

    }

    @Test
    public void isComputersInLiteratureBooksLinkClickableTest() {
        new SidePanelPage(driver).clickOnComputersInLiteratureBooksLink();
        Assert.assertTrue(new BooksPage(driver).getItemTitleText().contains(PageTitleData.COMPUTERS));

    }

    @Test
    public void isNonFictionBooksLinkClickableTest() {
        new SidePanelPage(driver).clickOnNonFictionBooksLink();
        Assert.assertTrue(new BooksPage(driver).getItemTitleText().contains(PageTitleData.NON_FICTION));

    }

    @Test
    public void isEssentialProgrammingBooksLinkClickableTest() {
        new SidePanelPage(driver).clickOnEssentialProgrammingBooksLink();
        Assert.assertTrue(new BooksPage(driver).getItemTitleText().contains(PageTitleData.PROGRAMMING));

    }

    @Test
    public void isHackingBooksLinkClickableTest() {
        new SidePanelPage(driver).clickOnHackingBooksLink();
        Assert.assertTrue(new BooksPage(driver).getItemTitleText().contains(PageTitleData.HACKING));

    }
}
