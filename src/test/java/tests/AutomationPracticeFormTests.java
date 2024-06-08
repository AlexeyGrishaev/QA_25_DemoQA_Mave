package tests;

import dto.StudentDTO;
import dto.StudentLombok;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class AutomationPracticeFormTests extends ApplicationManager {


    @Test
    public void AutomationPracticeFormPositiveTest() {
//        StudentDTO student = new StudentDTO("Frodo","Beggins","FrodoBeggins@mail.com", Gender.FEMALE);
        ArrayList<Hobbies> listHobbies = new ArrayList<>();
        listHobbies.add(Hobbies.READING);
        listHobbies.add(Hobbies.SPORTS);
        listHobbies.add(Hobbies.MUSIC);
        StudentLombok student = StudentLombok.builder()
                .name("Frodo")
                .lastName("Beggins")
                .email("FrodoBeggins@mail.com")
                .gender(Gender.FEMALE)
                .mobile("1234567890")
                .subjects("Math, Arts, History")
                .dateOfBirth("12 sep 2006")
                .hobbies(listHobbies)
                .currentAddress("Haifa st. First")
                .state(StateCity.UTTAR_PRADESH.getState())
                .city(StateCity.UTTAR_PRADESH.getCity()[1])
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.hideFooter();

        Assert.assertTrue(homePage.clickBtnFroms()
                .clickBtnPracticeForm()
                .fillStudentForm(student)
                .clickBtnSubmitPositive()
                .isElementPresent_textThanks());

    }

    @Test
    public void AutomationPracticeFormPositiveTest_equalsStudent() {
//        StudentDTO student = new StudentDTO("Frodo","Beggins","FrodoBeggins@mail.com", Gender.FEMALE);
        ArrayList<Hobbies> listHobbies = new ArrayList<>();
        listHobbies.add(Hobbies.READING);
        listHobbies.add(Hobbies.SPORTS);
        listHobbies.add(Hobbies.MUSIC);
        StudentLombok student = StudentLombok.builder()
                .name("Frodo")
                .lastName("Beggins1")
                .email("FrodoBeggins1@mail.com")
                .gender(Gender.FEMALE)
                .mobile("1234567890")
                .subjects("Math, Arts")
                .dateOfBirth("12 sep 2006")
                .hobbies(listHobbies)
                .currentAddress("Haifa st. First app.12")
                .state(StateCity.NCR.getState())
                .city(StateCity.NCR.getCity()[1])
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.hideFooter();

        StudentLombok studentModal = homePage.clickBtnFroms()
                .clickBtnPracticeForm()
                .fillStudentForm(student)
                .clickBtnSubmitPositive()
                .createStudentFromPage();
        System.out.println(student.toString());
        System.out.println(studentModal.toString());
        Assert.assertTrue(student.equals(studentModal));

    }
}
