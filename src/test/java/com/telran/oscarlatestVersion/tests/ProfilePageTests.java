package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.data.PageTitleData;
import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.CheckoutPage;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginOrRegisterPage;
import com.telran.oscar.pages.ProfilePage;
import com.telran.oscar.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginOrRegisterLink();
        new LoginOrRegisterPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new ProfilePage(driver).clickOnAccountLink();
    }

    @Test(dataProvider = "userLoginWithInvalidEmail", dataProviderClass = DataProviders.class)
    public void editEmailProfileNegativeTest(String email,String password) {
        new ProfilePage(driver).clickOnEditButton().editEmail(email);
        Assert.assertTrue(new ProfilePage(driver).getText().contains(PageTitleData.EDIT_PROFILE));

    }
    @Test
    public void changePasswordTest() {
        new ProfilePage(driver).clickOnChangePasswordButton()
                .enterOldPassword(UserData.USER_REG_PASSWORD)
                .enterNewPassword(UserData.NEW_PASSWORD)
                .clickOnSaveButton();
        Assert.assertTrue(new ProfilePage(driver).getTextOfUpdate().contains(UserData.PASSWORD_UPDATED));

    }

    @Test
    public void editFirstNameAndLastNamePositiveTest() {
        new ProfilePage(driver).clickOnEditButton().editFirstAndLastName(UserData.FIRST_NAME, UserData.SECOND_NAME).clickOnSaveButton();
        Assert.assertTrue(new ProfilePage(driver).getTextOfUpdate().contains(UserData.PROFILE_UPDATED));
    }

    @Test
    public void editEmailProfilePositiveTest() {
        new ProfilePage(driver).clickOnEditButton().editEmail(UserData.NEW_EMAIL).clickOnSaveButton();
        Assert.assertTrue(new ProfilePage(driver).getTextOfUpdate().contains(UserData.PROFILE_UPDATED));
    }

    @Test
    public void checkCancelButtonTest() {
        new ProfilePage(driver).clickOnEditButton().editEmail(UserData.NEW_EMAIL).clickOnCancelButton();
        Assert.assertTrue(new ProfilePage(driver).getText().contains(PageTitleData.PROFILE));

    }
    @Test
    public void fillAddressBookByTheRequiredFieldsTest(){
        new ProfilePage(driver).clickOnAddressBookSidePanelLink().clickOnAddANewAddressButton();
        new CheckoutPage(driver).enterRequiredAddressFields(UserData.FIRST_NAME, UserData.SECOND_NAME,
                UserData.ADDRESS, UserData.CITY, UserData.POST_CODE);
        Assert.assertTrue(new ProfilePage(driver).getTextOfUpdate().contains(UserData.ADDRESS_CREATED));
        new ProfilePage(driver).deleteRegisterUser();
    }

    @AfterMethod(enabled = false)
    public void deleteProfile(){
        new ProfilePage(driver).deleteRegisterUser();
        //or
        //new ProfilePage(driver).clickOnProfileLink().clickOnDeleteProfileButton().fillInPasswordField().clickOnDeleteButton();
    }
}
