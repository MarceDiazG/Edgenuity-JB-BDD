package org.jbehave.edgenuity.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.seleniumhq.selenium.fluent.FluentWebElements;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;
import static org.seleniumhq.selenium.fluent.Period.secs;

/**
 * Created by marcelodiaz on 31/7/17.
 */
public class HomePage extends FluentWebDriverPage {
   // By byButtonSupport = By.xpath("//div[@id='homepage-header-contain']//div[@id='homepage-hero-content']/div/a[contains(text(), 'Support')]");
    //By byLinkContact = By.xpath("//li[@id='contact']//a");

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

        FluentWebElements myArray = within(secs(2)).links(className("btn btn-orange p-x-3 m-x-2"));
        /*for (int i=0;i<myArray.size();i++){
        System.out.println("*** "+ i + ": "+myArray.get(i).toString());
        }*/
        myArray.get(1).click();
        //System.out.println(links(xpath("//div[@id='homepage-header-contain']//div[@id='homepage-hero-content']/div/a[contains(text(), 'Support')]")).size());
        System.out.println(links(xpath("@href = '/customer-support/'")).size());
        //links(xpath("@href = '/customer-support/'")).get(4).click();

        //links(xpath("//a[contains(text(), '/customer-support/')]")).click();
                //div[@id='homepage-header-contain']//div[@id='homepage-hero-content']/div/a[contains(text(), 'Support')]")).click();

        System.out.println(" ---- ≤≤>>>  on goToContactPage() Successfully");

    }

    //Our customers are always our first priority.
}
