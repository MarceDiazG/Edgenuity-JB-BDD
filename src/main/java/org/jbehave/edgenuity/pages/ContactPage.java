package org.jbehave.edgenuity.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.seleniumhq.selenium.fluent.FluentWebElement;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

/**
 * Created by marcelodiaz on 4/8/17.
 */
public class ContactPage extends FluentWebDriverPage{
    FluentWebElement firstName, titleContact;
    FluentWebElement  lastName, email, phone, jobTitle, school, district, state, zipCode, numStudents, submitButton, errorMsg;

    /**
     * Method to create a new instance of HomePage
     * @param webDriverProvider
     */
    public ContactPage(WebDriverProvider webDriverProvider)  {
        super(webDriverProvider);
/*
        //PageFactory.initElements(driver, this);
        titleContact = div(xpath("//div[@class='container-fluid']//h1[contains(text(), 'Contact Us')]"));
        firstName=  input(name("firstname"));
        lastName =  input(name("lastname"));
        email =  input(name("email"));
        phone =  input(name("phone"));
        jobTitle=  input(name("title"));
        school=  input(name("companyname"));
        district= input(name("custentity89"));
        state =  input(name("state"));
        zipCode =  input(name("zipcode"));
        numStudents=  input(name("singleLineText3"));
        submitButton =  input(xpath("//input[@value='Submit']"));*/

    }

    public boolean isLoad(){
        return true; //titleContact.isDisplayed();
    }

    public void goToUrl(String url){
         get(url);
    }

    public String getTitle(String pageName) {
        return this.getTitle();
    }
    public boolean incompleteForm(){
        firstName.sendKeys("Administrator");
        lastName.sendKeys("LastName");
        email.sendKeys("email@gmail.com");
        phone.sendKeys("158654789");
        jobTitle.sendKeys("Daddy");
        school.sendKeys("G. W. School");
        district.sendKeys("Phoenix Dist.");
        zipCode.sendKeys("85005");
        numStudents.sendKeys("2");

        submitButton.click();

        errorMsg =  span(xpath("//span[contains(text(), 'Please select your State')]"));
        return true; //errorMsg.isDisplayed().value();
    }
}
