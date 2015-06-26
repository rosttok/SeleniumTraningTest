package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class testChrome {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "//home//apium//workspace//selenium//chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://staging-02.rareconnect.org";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl + "/en/login");
        driver.findElement(By.id("signin_username")).clear();
        driver.findElement(By.id("signin_username")).sendKeys("tester");
        driver.findElement(By.id("signin_password")).clear();
        driver.findElement(By.id("signin_password")).sendKeys("apiumtech");
        driver.findElement(By.cssSelector("button.button")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
