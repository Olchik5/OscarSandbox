package com.telran.oscar.pages;

import com.telran.oscar.data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    @FindBy(css = ".nav-link.mt-2.mt-lg-0")
    WebElement accountLink;

    @FindBy(id = "delete_profile")
    WebElement deleteProfile;

    @FindBy(id = "id_password")
    WebElement passwordField;

    @FindBy(css = ".btn-danger")
    WebElement deleteButton;

    @FindBy(xpath = "//a[@href='/en-gb/accounts/profile/edit/']")
    WebElement editProfile;

    @FindBy(id = "id_email")
    WebElement emailAddress;

    @FindBy(css = ".sidebar.col-sm-4.col-md-3 li:nth-child(2)")
    WebElement orderHistory;

    //@FindBy(css = "td:nth-child(1)")
    //@FindBy(css = ".table.table-striped.table-bordered tr:nth-child(2) td:nth-child(1)")
    @FindBy(css = "td > a")
    WebElement orderNumber;

    @FindBy(xpath = "//a[@href='/en-gb/accounts/change-password/']")
    WebElement changePassword;

    @FindBy(xpath = "//input[@name='old_password']")
    WebElement oldPassword;

    @FindBy(xpath = "//input[@name='new_password1']")
    WebElement newPassword;

    @FindBy(xpath = "//input[@name='new_password2']")
    WebElement newPassword2;

    @FindBy(css = ".btn-primary")
    WebElement save;

    @FindBy(css = ".alertinner.wicon")
    WebElement textOfUpdate;

    @FindBy(css = ".page-header")
    WebElement editProfileText;

    @FindBy(id = "id_first_name")
    WebElement firstName;

    @FindBy(id = "id_last_name")
    WebElement lastName;

    @FindBy(css = ".form-group>div:nth-child(1) a")
    WebElement cancelButton;

    @FindBy(css = ".nav-item:nth-child(3)")
    WebElement addressBook;

    @FindBy(css = ".btn.btn-primary")
    WebElement addNewAddressButton;

    @FindBy(xpath = "//a[text()='Profile']")
    WebElement profileLink;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage deleteRegisterUsers(String password) {
        new ProfilePage(driver).clickOnAccountLink()
                .clickOnDeleteProfileButton()
                .fillInPasswordField(password)
                .clickOnDeleteButton();
        return this;
    }

    public ProfilePage deleteRegisterUser() {
        new ProfilePage(driver).clickOnAccountLink()
                .clickOnDeleteProfileButton()
                .fillInPasswordField()
                .clickOnDeleteButton();
        return this;
    }

    private HomePage clickOnDeleteButton() {
        click(deleteButton);
        return new HomePage(driver);
    }

    public ProfilePage fillInPasswordField() {
        type(passwordField, UserData.USER_REG_PASSWORD);
        return this;
    }

    public ProfilePage fillInPasswordField(String password) {
        type(passwordField, password);
        return this;
    }

    public ProfilePage clickOnDeleteProfileButton() {
        click(deleteProfile);
        return this;
    }

    public ProfilePage clickOnAccountLink() {
        click(accountLink);
        return this;
    }

    public ProfilePage clickOnEditButton() {
        click(editProfile);
        return this;
    }

    public ProfilePage editEmail(String email) {
        type(emailAddress, email);
        return this;
    }

    public ProfilePage clickOnOrderHistoryLink() {
        click(orderHistory);
        return this;
    }

    public ProfilePage getOrderNumber() {
        String text = orderNumber.getText();
        System.out.println("Order number: " + text);
        return this;
    }

    public ProfilePage clickOnChangePasswordButton() {
        click(changePassword);
        return this;
    }

    public ProfilePage enterOldPassword(String pass) {
        type(oldPassword,pass);
        return this;
    }

    public ProfilePage enterNewPassword(String newPass) {
        type(newPassword, newPass);
        type(newPassword2, newPass);
        return this;
    }

    public ProfilePage clickOnSaveButton() {
        click(save);
        return this;
    }

    public String getTextOfUpdate() {
        return textOfUpdate.getText();
    }

    public String getText() {
        return editProfileText.getText();
    }

    public ProfilePage editFirstAndLastName(String fName, String sName) {
        type(firstName, fName);
        type(lastName, sName);
        return this;
    }

    public ProfilePage clickOnCancelButton() {
        click(cancelButton);
        return this;
    }

    public ProfilePage clickOnAddressBookSidePanelLink() {
        click(addressBook);
        return this;
    }

    public ProfilePage clickOnAddANewAddressButton() {
        click(addNewAddressButton);
        return this;
    }

    public ProfilePage clickOnProfileLink() {
        click(profileLink);
        return this;
    }
}
