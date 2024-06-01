package tests;

import dto.StudentDTO;
import dto.StudentLombok;
import enums.Gender;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;



public class HomeTests extends ApplicationManager  {
    @Test
    public void test(){
        // StudentDTO student = new StudentDTO("Frodo","Beggins","FrodoBeggins@mail.com", Gender.FEMALE);
        StudentLombok student= StudentLombok.builder()
                .name("Frodo")
                .lastName("Beggins")
                .email("FrodoBeggins@mail.com")
                .gender(Gender.MALE)
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnFroms().
                clickBtnPracticeForm().
                fillStudentForm(student);
    }

}
