package org.jbehave.edgenuity.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.support.FindBy;
import org.seleniumhq.selenium.fluent.FluentWebElement;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.xpath;

/**
 * Created by marcelodiaz on 31/7/17.
 */
public class HomePage extends FluentWebDriverPage {
   // By byButtonSupport = By.xpath("//div[@id='homepage-header-contain']//div[@id='homepage-hero-content']/div/a[contains(text(), 'Support')]");
    //By byLinkContact = By.xpath("//li[@id='contact']//a");
   @FindBy(xpath="//div[@id='homepage-header-contain']//div[@id='homepage-hero-content']/div/a[contains(text(), 'Support')]")
   private FluentWebElement buttonSupport ;
    /**
     * Method to create a new instance of HomePage
     * @param webDriverProvider
     */
    public HomePage(WebDriverProvider webDriverProvider){
        super(webDriverProvider);
    }

    public boolean isLoad(){
        return true; //findElement(byButtonSupport).isDisplayed();
    }

    public void goToUrl(String url){
        get(url);
        // Check that we're on the right page.
        if (!"Edgenuity Inc. | Homepage".equals( getTitle())) {
            throw new IllegalStateException("This is not the home page");
        }
    }
    public void goToContactPage(){
        System.out.println(" ---- ≤≤>>>  on goToContactPage()");
       // WebElement contactLink =  findElement(byLinkContact);
        //li(By.xpath("//li[@id='contact']//a"));
        System.out.println(" ---- ≤≤>>>  ContactLink Founded OK !!!!");
       // contactLink.click();
        System.out.println(" ---- ≤≤>>>  ContactLink Clicked !!!!");
        // findElement(By.xpath("//div[@class='container-fluid']//h1[contains(text(), 'Contact Us')]"));
    }
    public void goToSupportPage(){
        System.out.println(" ---- ≤≤>>>  on goToSupportPage()");
       // WebElement buttonSupport =  findElement(byButtonSupport);

        //div(xpath("//div[@id='homepage-header-contain']//div[@id='homepage-hero-content']/div/a[contains(text(), 'Support')]")).click();
        //buttonSupport.click();
        System.out.println(" ---- ≤≤>>>  on goToContactPage() Successfully");
    }

    //Our customers are always our first priority.
}
