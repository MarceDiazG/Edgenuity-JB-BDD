package org.jbehave.edgenuity.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.seleniumhq.selenium.fluent.FluentWebElement;

import static org.openqa.selenium.By.xpath;

/**
 * Created by marcelodiaz on 4/8/17.
 */
public class CustomerSupportPage extends FluentWebDriverPage {

    private final String h1TechnicalCustomerSupportStr = "//h1[contains(text(), 'Technical + Customer Support')]";
    FluentWebElement h1TechnicalCustomerSupport;
    /**
     * Method to create a new instance of HomePage
     * @param webDriverProvider
     */
    public CustomerSupportPage(WebDriverProvider webDriverProvider){
        super(webDriverProvider);
    }

    public boolean isLoad(){
        try {
            h1TechnicalCustomerSupport = h1(xpath(h1TechnicalCustomerSupportStr));
            System.out.println("Successfully founded 'xpathButtonSupportForm'!!! ");
            System.out.println("driver.getTitle(): '"+ getTitleStr()+"'");
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public String getTitleStr(){
        String title;
        title=getTitle();
        return title;
    }
    public void goToUrl(String url){
        get(url);
    }


}
