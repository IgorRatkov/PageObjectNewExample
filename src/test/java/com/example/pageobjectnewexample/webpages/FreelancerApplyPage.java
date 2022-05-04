package com.example.pageobjectnewexample.webpages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreelancerApplyPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;


    @FindBy(xpath = "//div[contains(text(),'I am a freelance...')]")
    private WebElement containsIAmFreelance;

    @FindBy(xpath = "//div[text() = 'Developer']")
    private WebElement selectRoleDeveloper;

    @FindBy(id="talent_create_applicant_email")
    WebElement freelancer_email;

    @FindBy(id = "talent_create_applicant_password")
    WebElement freelancer_password;

    @FindBy(id = "talent_create_applicant_password_confirmation")
    WebElement freelancer_password_confirmation;

    @FindBy(id = "talent_create_applicant_full_name")
    WebElement freelancer_full_name;

    @FindBy(xpath = "//span[text() = 'Please enter full name']")
    WebElement incorrectFullNameMessage;

    @FindBy(xpath = "//input[@value='Apply to Join Toptal']")
    private WebElement applyToJoinToptalButton;


    //Constructor
    public FreelancerApplyPage(WebDriver driver,WebDriverWait webDriverWait){
        this.driver=driver;
        this.webDriverWait=webDriverWait;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    @Step
    public  void isPageOpened(){
        Assertions.assertEquals("I am a freelance...",containsIAmFreelance.getText());
    }
    @Step
    public void setSelectRoleDeveloper(){
        containsIAmFreelance.click();
        selectRoleDeveloper.click();
    }
    @Step
    public void setFreelancer_full_name(String fullName){
        freelancer_full_name.clear();
        freelancer_full_name.sendKeys(fullName);
    }

    @Step
    public void set_email(String email){
        freelancer_email.clear();
        freelancer_email.sendKeys(email);
    }
    @Step
    public void set_password(String password){
        freelancer_password.clear();
        freelancer_password.sendKeys(password);
    }
    @Step
    public void set_password_confirmation(String password_confirmation){
        freelancer_password_confirmation.clear();
        freelancer_password_confirmation.sendKeys(password_confirmation);
    }
    @Step
    public  String isErrorMessagePresent(String fullName){
        setFreelancer_full_name(fullName);
        //if need add this:
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(incorrectFullNameMessage));
        return incorrectFullNameMessage.getText();
    }


    @Step
    public void clickOnJoin(){
        applyToJoinToptalButton.click();
    }
 //   public boolean isPageOpened(){
  //      return containsIAmDeveloper.getText().toString().contains("I am a Developer");
  //  }
}


/*
 // Initialize and wait till element(link) became clickable - timeout in 10 seconds
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
// Print the first result
        System.out.println(firstResult.getText());
 */

//allure serve allure-results