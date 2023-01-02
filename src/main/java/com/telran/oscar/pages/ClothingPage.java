package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingPage extends BasePage {

    @FindBy(css = ".page-header")
    WebElement clothing;

    public ClothingPage(WebDriver driver) {
        super(driver);
    }

    public String getTextClothing() {
        return clothing.getText();
    }
}
