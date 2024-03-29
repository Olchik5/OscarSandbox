package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.data.ConfirmationData;
import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginOrRegisterPage;
import com.telran.oscar.pages.ProfilePage;
import com.telran.oscar.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPagePositiveTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).clickOnLoginOrRegisterLink();

    }

    @Test
    public void registerPositiveTest() {
        new LoginOrRegisterPage(driver).register(UserData.USER_REG_EMAIL, UserData.USER_REG_PASSWORD,
                UserData.USER_REG_CONFIRM_PASSWORD);
        new ProfilePage(driver);//deleteRegisterUser();
        new HomePage(driver).verifyTextThanksForRegistering(ConfirmationData.CONFIRMATION_OF_REGISTER);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "posRegister")
    public void registerPositiveWithDataProviderTest(String email, String password, String confirmPassword) {
        new LoginOrRegisterPage(driver).register(email, password, confirmPassword);
        new ProfilePage(driver).deleteRegisterUsers(password);
        new HomePage(driver).verifyTextThanksForRegistering(ConfirmationData.CONFIRMATION_OF_REGISTER);
        new HomePage(driver).verifyTextYourProfileHasBeenDeleted().contains(ConfirmationData.CONFIRMATION_OF_DELETED_PROFILE);
    }

}
