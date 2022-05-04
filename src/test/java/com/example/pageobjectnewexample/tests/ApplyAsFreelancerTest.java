package com.example.pageobjectnewexample.tests;

import io.qameta.allure.*;
import com.example.pageobjectnewexample.webpages.FreelancerApplyPage;
import com.example.pageobjectnewexample.webpages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplyAsFreelancerTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10L));
    }

    @Test
    @Story("apply new freelancer")
    @DisplayName("test page object model apply new freelancer")
    public void applyAsFreelancer() {
        //Create object of HomePage Class
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDeveloperApplyButton();




        //Create object of DeveloperApplyPage
        FreelancerApplyPage freelancerApplyPage =new FreelancerApplyPage(driver,webDriverWait);

        //Check if page FreelancerApplyPage is opened
        freelancerApplyPage.isPageOpened();

        //Fill up data

        freelancerApplyPage.setSelectRoleDeveloper();
        freelancerApplyPage.setFreelancer_full_name("Dejan Zivanovic Automated Test" );
        freelancerApplyPage.set_email("dejan@toptal.com" );
        freelancerApplyPage.set_password("password123" );
        freelancerApplyPage.set_password_confirmation("password123" );
        attachScreenshot();

        //Click on join
       // developerApplyPage.clickOnJoin();
    }
    @Test
    @Story("apply new freelancer")
    @DisplayName("negative test correct input full name field")
    public void checkFullName() {
        //Create object of HomePage Class
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDeveloperApplyButton();




        //Create object of DeveloperApplyPage
        FreelancerApplyPage freelancerApplyPage =new FreelancerApplyPage(driver,webDriverWait);

        //Check if page FreelancerApplyPage is opened
        freelancerApplyPage.isPageOpened();

        //Fill up data

        freelancerApplyPage.setSelectRoleDeveloper();
        //freelancerApplyPage.setFreelancer_full_name("De" + Keys.ENTER);
        String messageCheck = freelancerApplyPage.isErrorMessagePresent("De" + Keys.ENTER);
        Assertions.assertEquals("Please enter full name",messageCheck);

       // frelancerApplyPage.set_email("dejan@toptal.com");
      //  frelancerApplyPage.set_password("password123");
      //  frelancerApplyPage.set_password_confirmation("password123");
        attachScreenshot();

        //Click on join
        // developerApplyPage.clickOnJoin();
    }



    @AfterEach
    public void close(){
        driver.close();
    }
}
//allure serve allure-results