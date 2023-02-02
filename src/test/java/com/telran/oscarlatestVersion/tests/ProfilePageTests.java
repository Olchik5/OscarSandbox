package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginOrRegisterPage;
import com.telran.oscar.pages.ProfilePage;
import com.telran.oscar.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends  BaseTest{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginOrRegisterLink();
        new LoginOrRegisterPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new ProfilePage(driver).clickOnAccountLink();
    }

    @Test(dataProvider = "userLoginWithInvalidEmail", dataProviderClass = DataProviders.class)
    public void editEmailProfileNegativeTest(String email,String password) {
        new ProfilePage(driver).clickOnEditButton().editEmail(email);
        //Assert

    }
    @Test
    public void changePasswordTest() {
        new ProfilePage(driver).clickOnChangePasswordButton()
                .enterOldPassword(UserData.USER_REG_PASSWORD)
                .enterNewPassword(UserData.NEW_PASSWORD)
                .saveNewPassword();
        Assert.assertTrue(new ProfilePage(driver).getPasswordUpdatedText().contains(UserData.PASSWORD_UPDATED));

    }
}
