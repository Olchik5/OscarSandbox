package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void openHomePageTest() {
        new HomePage(driver).takeScreenshotWithScrollDown();
    }

}

