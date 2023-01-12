package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.data.BasketData;
import com.telran.oscar.data.ConfirmationData;
import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketPageTests extends BaseTest{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginOrRegisterLink();
        new LoginOrRegisterPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);
    }

    @Test
    public void isBasketEmptyTest(){
        new BasketPage(driver).clickOnViewBasketLVButton();
        Assert.assertTrue(new BasketPage(driver).getBasketIsEmptyText().contains(ConfirmationData.CONFIRM_OF_EMPTY_BASKET));
    }

    @Test
    public void addItemInBasketTest(){
        new AllProductsPage(driver).clickOnAddToBasketButton();
        new BasketPage(driver).clickOnViewBasketLVButton();
        Assert.assertTrue(new BasketPage(driver).getQuantityInBasketText().contains(BasketData.QUANTITY_IN_BASKET));
    }

    @Test
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

    @Test
    public void removeQuantityButtonTest(){
        new AllProductsPage(driver).clickOnAddToBasketButton();
        new AllProductsPage(driver).clickOnViewBasketButton();
        new BasketPage(driver).removeQuantity();
        Assert.assertTrue(new BasketPage(driver).getConfirmMessageBasketIsNowEmptyText().contains(BasketData.CONFIRM1_OF_EMPTY_BASKET));
        Assert.assertTrue(new BasketPage(driver).getConfirmBasketIsEmptyText().contains(ConfirmationData.CONFIRM_OF_EMPTY_BASKET));
    }

    @Test
    public void proceedToCheckoutButtonTest(){
        new AllProductsPage(driver).clickOnAddToBasketButton();
        new BasketPage(driver).clickOnViewBasketLVButton();
        new CheckoutPage(driver).clickOnProceedToCheckout();
        Assert.assertTrue(new CheckoutPage(driver).getShippingAddressText().contains(BasketData.SHIPPING));
    }
}
