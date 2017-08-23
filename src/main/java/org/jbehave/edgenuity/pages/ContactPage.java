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
        //titleContact = div(xpath("//div[@class='container-fluid']//h1[contains(text(), 'Contact Us')]"));
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
        submitButton =  input(xpath("@value='Submit'")); */

    }

    public boolean isLoad(){
        return true; //titleContact.isDisplayed();
    }

    public void goToUrl(String url){
         get(url);
    }

    public String getTitleStr() {
        String title;
        title=getTitle();
        return title;
    }
    public boolean incompleteForm(){

        input(name("firstname")).sendKeys("Administrator");
        input(name("lastname")).sendKeys("LastName");
        input(name("email")).sendKeys("email@gmail.com");
        phone =  input(name("phone")).sendKeys("158654789");
        jobTitle=  input(name("title")).sendKeys("Daddy");
        school=  input(name("companyname")).sendKeys("G. W. School");
        district= input(name("custentity89")).sendKeys("Phoenix Dist.");
        state =  input(name("state"));
        zipCode =  input(name("zipcode")).sendKeys("85005");
        numStudents=  input(name("singleLineText3")).sendKeys("2");
        submitButton =  input(xpath("@value='Submit'")).click();

        errorMsg =  span(xpath("//span[contains(text(), 'Please select your State')]"));
        return true; //errorMsg.isDisplayed().value();
    }
}
