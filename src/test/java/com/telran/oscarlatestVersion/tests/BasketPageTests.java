package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.data.BasketData;
import com.telran.oscar.data.ConfirmationData;
import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketPageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginOrRegisterLink();
        new LoginOrRegisterPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);
    }

    @Test(priority = 1)
    public void isBasketEmptyTest(){
        new BasketPage(driver).clickOnViewBasketLVButton();
        Assert.assertTrue(new BasketPage(driver).getBasketIsEmptyText().contains(ConfirmationData.CONFIRM_OF_EMPTY_BASKET));
    }

    @Test(priority = 2)
    public void addItemInBasketTest(){
        new AllProductsPage(driver).clickOnAddToBasketButton();
        new BasketPage(driver).clickOnViewBasketLVButton();
        Assert.assertTrue(new BasketPage(driver).getQuantityInBasketText().contains(BasketData.QUANTITY_IN_BASKET));
    }

    @Test(priority = 3)
    public void isUpdateQuantityButtonFunctioningTest(){
        new AllProductsPage(driver).clickOnAddToBasketButton();
        new BasketPage(driver).clickOnViewBasketLVButton();
        new BasketPage(driver).enterQuantity(BasketData.ENTER_QUANTITY_IN_BASKET);
        Assert.assertTrue(new BasketPage(driver).getQuantityInBasketText().contains(BasketData.ENTER_QUANTITY_IN_BASKET));
        Assert.assertTrue(new BasketPage(driver).getInformationText().contains(BasketData.NO_LONGER_Deferred_BENEFIT));
        Assert.assertTrue(new BasketPage(driver).getBasketTotalIsNowText().contains(BasketData.Basket_TOTAL_IS_NOW));
    }

    @Test
    public void isUpdateQuantityWithSpinButtonFunctioningTest(){
        new AllProductsPage(driver).clickOnAddToBasketButton();
        new BasketPage(driver).clickOnViewBasketLVButton();
        new BasketPage(driver).increaseQuantity();
        Assert.assertTrue(new BasketPage(driver).getQuantityInBasketText().contains(BasketData.QUANTITY2_IN_BASKET));
    }

    @Test(priority = 4)
    public void removeQuantityButtonTest(){
        new AllProductsPage(driver).clickOnAddToBasketButton();
        new AllProductsPage(driver).clickOnViewBasketButton();
        new BasketPage(driver).removeQuantity();
        Assert.assertTrue(new BasketPage(driver).getConfirmMessageBasketIsNowEmptyText().contains(BasketData.CONFIRM1_OF_EMPTY_BASKET));
        Assert.assertTrue(new BasketPage(driver).getConfirmBasketIsEmptyText().contains(ConfirmationData.CONFIRM_OF_EMPTY_BASKET));
    }

    @Test(priority = 5)
    public void proceedToCheckoutButtonTest(){
        new AllProductsPage(driver).clickOnAddToBasketButton();
        new BasketPage(driver).clickOnViewBasketLVButton();
        new CheckoutPage(driver).clickOnProceedToCheckout();
        Assert.assertTrue(new CheckoutPage(driver).getShippingAddressText().contains(BasketData.SHIPPING));
    }

    @Test
    public void isUpdateQuantityWithSpinDecreaseButtonFunctioningTest(){
        new AllProductsPage(driver).clickOnAddToBasketButton();
        new BasketPage(driver).clickOnViewBasketLVButton();
        new BasketPage(driver).decreaseQuantity();
        Assert.assertTrue(new BasketPage(driver).getQuantityInBasketText().contains(BasketData.QUANTITY3_IN_BASKET));
    }

    @Test
    public void compareItemWithTotalPriseTest() {
        new HomePage(driver).addItemToBasket(BasketData.ADD_FIRST_ITEM);
        new AllProductsPage(driver).clickOnViewBasketButton();
        double price = new BasketPage(driver).getPriceForOneItem();
        System.out.println("price " + price);
        new BasketPage(driver).enterQuantity(BasketData.QUANTITY2_IN_BASKET);
        double priceForSeveralItems = new BasketPage(driver).getPriceForSeveralItems();
        System.out.println("priceForSeveral" + priceForSeveralItems);
        double priceTotal = new BasketPage(driver).getTotalPrice();
        System.out.println(priceTotal);
        new HomePage(driver).takeScreenshotWithScrollDown();
        Assert.assertEquals(priceForSeveralItems,price*2);
        Assert.assertEquals(priceForSeveralItems,priceTotal);

    }

    @Test
    public void buyBookTest() {
        new HomePage(driver).clickOnAllProductsLink().clickOnAddToBasketButton();
        new BasketPage(driver).clickOnViewBasketButton();
        String actual = new CheckoutPage(driver).clickOnProceedToCheckout()
                .enterRequiredAddressFields(UserData.FIRST_NAME, UserData.SECOND_NAME,
                        UserData.ADDRESS, UserData.CITY, UserData.POST_CODE)
                .clickOnContinueButton()
                .clickOnPlaceOrderButton()
                .getOrderConfirmNumber();
        new HomePage(driver).clickOnLogoLV();
        String expected = new ProfilePage(driver).clickOnAccountLink()
                .clickOnOrderHistoryLink()
                .getOrderNumber();
        Assert.assertEquals(actual,expected);

    }
}
