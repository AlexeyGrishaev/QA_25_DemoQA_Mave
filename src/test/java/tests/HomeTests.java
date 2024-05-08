package tests;

import dto.StudentDTO;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;



public class HomeTests extends ApplicationManager  {
    @Test
    public void test(){
        StudentDTO student = new StudentDTO("Frodo","Beggins","FrodoBeggins@mail.com");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnFroms().
                clickBtnPracticeForm().
                fillStudentForm(student);
    }

}
