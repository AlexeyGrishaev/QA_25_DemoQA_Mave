package manager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    ChromeOptions chromeOptions = new ChromeOptions();

    @BeforeMethod
    public void setUp() {
        chromeOptions.addArguments("load-extension=C://Tools/5.10.1_0");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for(String s :tabs){
            System.out.println("Tab==>" + s);
        }
        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0));
    }

    @AfterMethod
    public void tearDown() {
//        if (driver != null)
//            driver.quit();
    }


}
