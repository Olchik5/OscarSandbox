package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.pages.AllProductsPage;
import com.telran.oscar.pages.UIHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UIHomePageTests extends BaseTest{

    @Test
    public void verifyTopPageChooseLanguageFieldTest() {
        Assert.assertTrue(new UIHomePage(driver).isChooseLanguageFieldPresent());
    }

    @Test
    public void verifyTopPageSwitchLanguageButtonTest() {
        Assert.assertTrue(new UIHomePage(driver).isSwitchLanguageButtonPresent());
    }

    @Test
    public void verifyTopPageLoginOrRegistrButtonTest() {
        Assert.assertTrue(new UIHomePage(driver).isLoginOrRegistrButtonPresent());
    }

    @Test
    public void verifyHeaderOscarLogoTest() {
        Assert.assertTrue(new UIHomePage(driver).isOscarLogoPresent());
    }

    @Test
    public void verifyHeaderBasketTotalTextTest() {
        Assert.assertTrue(new UIHomePage(driver).isBasketTotalTextPresent());
    }

    @Test
    public void verifyHeaderBasketButtonTest() {
        Assert.assertTrue(new UIHomePage(driver).isBasketButtonPresent());
    }

    @Test
    public void verifyHeaderViewBasketDropdownMenuButtonTest() {
        Assert.assertTrue(new UIHomePage(driver).isViewBasketDropdownMenuButtonPresent());
    }

    @Test
    public void verifyHeaderBrowseStoreDropdownMenuTest() {
        Assert.assertTrue(new UIHomePage(driver).isBrowseStoreDropdownMenuPresent());
    }

    @Test
    public void verifyHeaderSearchFieldTest() {
        Assert.assertTrue(new UIHomePage(driver).isSearchFieldPresent());
    }

    @Test
    public void verifyHeaderSearchButtonTest() {
        Assert.assertTrue(new UIHomePage(driver).isSearchButtonPresent());
    }

    @Test
    public void verifySidePanelClothingLinkTest() {
        Assert.assertTrue(new UIHomePage(driver).isClothingLinkPresent());
    }

    @Test
    public void verifySidePanelBooksLinkTest() {
        Assert.assertTrue(new UIHomePage(driver).isBooksLinkPresent());
    }

    @Test
    public void verifySidePanelFictionLinkTest() {
        Assert.assertTrue(new UIHomePage(driver).isFictionLinkPresent());
    }

    @Test
    public void verifySidePanelComputerAndLiteratureLinkTest() {
        Assert.assertTrue(new UIHomePage(driver).isComputerAndLiteratureLinkPresent());
    }

    @Test
    public void verifySidePanelNonFictionLinkTest() {
        Assert.assertTrue(new UIHomePage(driver).isNonFictionLinkPresent());
    }

    @Test
    public void verifySidePanelEssentialProgrammingLinkTest() {
        Assert.assertTrue(new UIHomePage(driver).isEssentialProgrammingLinkPresent());
    }

    @Test
    public void verifySidePanelHackingLinkTests() {
        Assert.assertTrue(new UIHomePage(driver).isHackingLinkPresent());
    }

    @Test
    public void verifyProductGalleryElementsButtonAddToBasketTest() {
        Assert.assertTrue(new UIHomePage(driver).isButtonAddToBasketPresent());

    }

    @Test
    public void verifyProductGalleryElementsImagesOnTheHomePageTest() {
        Assert.assertTrue(new UIHomePage(driver).isImageOnTheHomePagePresent());
    }

    @Test
    public void UINextPage() {
        Assert.assertTrue(new UIHomePage(driver).isNextButtonsPresent());
    }

    @Test
    public  void verifyBodyViewBasketButtonTest() {
        new AllProductsPage(driver).clickOnAddToBasketButton();
        Assert.assertTrue(new UIHomePage(driver).isViewBasketButtonPresent());
    }

    @Test
    public  void verifyBodyCheckoutNowButtonTest() {
        new AllProductsPage(driver).clickOnAddToBasketButton();
        Assert.assertTrue(new UIHomePage(driver).isCheckoutNowButtonPresent());
    }
}
