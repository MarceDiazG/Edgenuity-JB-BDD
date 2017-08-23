package org.jbehave.edgenuity.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.edgenuity.EnvironmentData;
import org.jbehave.edgenuity.pages.ContactPage;
import org.jbehave.edgenuity.pages.CustomerSupportPage;
import org.jbehave.edgenuity.pages.HomePage;
import org.jbehave.edgenuity.pages.PageFactory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CommonSteps {
    Properties data;
    HomePage homePage;
    CustomerSupportPage customerSupportPage;
    ContactPage contactPage;

    public CommonSteps(PageFactory pageFactory){
        homePage = pageFactory.newHomePage();
        EnvironmentData env= new EnvironmentData();
        this.data= env.getProperties();
        contactPage= pageFactory.newContactPage();
        customerSupportPage= pageFactory.newCustomerSupportPage();
    }

    @Given("an user that visit our landing page")
    public void goToHomePage() {
        String baseURL= data.getProperty("primaryURL");
        System.out.print(" >>>> This is the Given!, and we'll load: '" + baseURL + "'");
        //baseURL = "https://www.edgenuity.com/";
        homePage.goToUrl(baseURL);
        System.out.println("***> End of GIVEN");
    }

    @When("the user clicks on contact link")
    public void goToContactPage() {
        System.out.println(" >>>> This is the When of Contact Page!!!!");
        homePage.goToContactPage();
        //System.out.print(" >>>> ContactPage is Loaded? :" + contactPage.isLoad());

    }

    @When("the user clicks on support button")
    public void goToCustomerSupportPage() {
        System.out.println(" >>>> This is the When !!!!");
        homePage.goToSupportPage();
    }
    @Then("the support page is displayed successfully")
    public void isTheCorrectPage() {
        assertTrue("In 'CustomerSupportPage' OK! ",customerSupportPage.isLoad());
        assertTrue("This is not Support Page!",
                "Edgenuity Inc. | Technical + Customer Support".equalsIgnoreCase(customerSupportPage.getTitleStr()));
        System.out.println(" >>>> This is the Then !!!!");
    }

    @Then("filling with incomplete data Contact Page form, error message is displayed")
    public void checkTitle(String pageName) {

        System.out.print(" >>>> Checking Title of the Page!!!!");
        assertTrue("This is not Contact Page!",
                "Edgenuity Inc. | Contact Us".equalsIgnoreCase(contactPage.getTitleStr()));
        assertTrue("The State validation is not working !!!",
                contactPage.incompleteForm());

        try {
            TimeUnit.SECONDS.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" ");
        System.out.println("******* TC Successfully executed *********");
        System.out.println(" ");
    }

    @Then("the $title appears on the page")
    public void checkProduct(String title) {
        System.out.println(" >>>> This is the AND of the Then!!!!");
    }
}
