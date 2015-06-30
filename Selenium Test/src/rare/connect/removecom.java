package rare.connect;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class removecom {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:4000/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl + "en/login");
        driver.findElement(By.id("signin_username")).clear();
        driver.findElement(By.id("signin_username")).sendKeys("admin");
        driver.findElement(By.id("signin_password")).clear();
        driver.findElement(By.id("signin_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.button")).click();
        driver.get(baseUrl + "en/profile/edit");
        driver.findElement(By.xpath("(//img[@alt='Leave this community'])[3]")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//img[@alt='Leave this community'])[2]")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[alt=\"Leave\"]")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.button.submitButton")).click();


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

