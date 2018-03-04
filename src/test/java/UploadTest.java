import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UploadTest {

    static WebDriver browser;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver","bin/chromedriver.exe");
        browser = new ChromeDriver();
    }

    @Test()
    public void UserLogin(){
        browser.get(LoginPage.LinkLoginPage);
        browser.findElement(LoginPage.usernameLocator).sendKeys(LoginPage.UserName);
        browser.findElement(LoginPage.passwordLocator).sendKeys(LoginPage.UserPassword);

    }


    @Test(dependsOnMethods = "UserLogin")
    public void FileUpload() throws InterruptedException {
        browser.get(UplDownlPage.LinkUploadPage);
        browser.findElement(UplDownlPage.UploadLink)
                .sendKeys(UplDownlPage.FileLink);

        String FileNumber = browser.findElement(UplDownlPage.DownloadFileLink)
                .getAttribute(UplDownlPage.DownloadFileID);

        Assert.assertTrue(browser.getPageSource().contains(FileNumber));
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "FileUpload")
    public void DownloadFile(){
        String FileNumber = browser.findElement(UplDownlPage.DownloadFileLink)
                .getAttribute(UplDownlPage.DownloadFileID);

        browser.get(UplDownlPage.LinkDownloadPage + FileNumber);
        WebElement button00 = browser.findElement(UplDownlPage.ButtonLink);

        Actions builder = new Actions(browser);
        builder.moveToElement(button00).click().build().perform();

    }

    @AfterClass
    public void tearDown() {
        browser.get("https://app.box.com/logout");
        browser.quit();
    }
}
