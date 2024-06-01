package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



public class BasePage {

    protected static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }
    public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
