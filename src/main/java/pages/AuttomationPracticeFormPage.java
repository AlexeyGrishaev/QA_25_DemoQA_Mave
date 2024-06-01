package pages;

import dto.StudentDTO;
import dto.StudentLombok;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static pages.BasePage.setDriver;

public class AuttomationPracticeFormPage extends BasePage {
    public AuttomationPracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement fieldName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement fieldLastName;
    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    WebElement fieldEmail;
    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    WebElement fieldMobile;
    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElement fieldDateOfBirth;
    @FindBy(id = "subjectsInput")
    WebElement fieldSubject;
    @FindBy(xpath = "//textarea[@placeholder='Current Address']")
    WebElement fieldCurrentAddress;
    @FindBy(id = "react-select-3-input")
    WebElement fieldState;
    @FindBy(id = "react-select-4-input")
    WebElement fieldCity;
    @FindBy(id = "submit")
    WebElement btnSubmit;
    @FindBy(id= "example-modal-sizes-title-lg")
    WebElement textThankFor;

    public AuttomationPracticeFormPage fillStudentForm(StudentLombok student) {
        hideFooter();
        fieldName.sendKeys(student.getName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        clickGender(student.getGender());
        fieldMobile.sendKeys(student.getMobile());
        //fieldDateOfBirth.sendKeys(student.getDateOfBirth());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubject(student.getSubject());
        typeHobbies(student.getHobbies());
        fieldCurrentAddress.sendKeys(student.getCurrentAddress());
        fieldState.sendKeys(student.getState());
        fieldState.sendKeys(Keys.ENTER);
        fieldCity.sendKeys(student.getCity());
        fieldCity.sendKeys(Keys.ENTER);
        return this;
    }
    public AuttomationPracticeFormPage clickBtnSubmitPositive(){
        btnSubmit.click();
        return this;
    }

    public boolean isElementPresent_textThanks(){
        return textThankFor.isDisplayed();
    }
    private void typeHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            switch (h) {
                case SPORTS:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case MUSIC:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;

            }
        }
    }

    private void typeSubject(String subject) {
        String[] splitArray = subject.split(",");
        fieldSubject.click();
        for (String sub : splitArray) {
            fieldSubject.sendKeys(sub);
            fieldSubject.sendKeys(Keys.ENTER);
        }
    }

    private void typeDateOfBirth(String dateOfBirth) {
        fieldDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println("OS --> " + operationSystem);
        if (operationSystem.startsWith("Win"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if (operationSystem.startsWith("Mac"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        fieldDateOfBirth.sendKeys(dateOfBirth);
        fieldDateOfBirth.sendKeys(Keys.ENTER);
    }

    private void clickGender(Gender gender) {

        WebElement elementGender = driver.findElement(By.xpath(gender.getLocator()));
        elementGender.click();
    }
    public StudentLombok createStudentFromPage(){
        return StudentLombok.builder()

                .build();
    }

}
