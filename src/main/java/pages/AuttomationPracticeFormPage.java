package pages;

import dto.StudentDTO;
import enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static pages.BasePage.setDriver;

public class AuttomationPracticeFormPage extends BasePage{
    public AuttomationPracticeFormPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement fieldName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement fieldLastName;
    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    WebElement fieldEmail;

    public AuttomationPracticeFormPage fillStudentForm(StudentDTO student){
        hideFooter();
        fieldName.sendKeys(student.getName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        clickGender(student.getGender());

        return this;
    }

    private void clickGender(Gender gender) {

        WebElement elementGender = driver.findElement(By.xpath(gender.getLocator()));
        elementGender.click();
    }

}
