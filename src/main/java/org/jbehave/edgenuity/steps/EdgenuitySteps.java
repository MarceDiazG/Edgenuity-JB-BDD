package org.jbehave.edgenuity.steps;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.edgenuity.EnvironmentData;
import org.jbehave.edgenuity.pages.*;

import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.equalTo;

public class EdgenuitySteps {
    
    private AdvancedSearch advancedSearch;
    private Home home;
    private Site site;
    private SearchResults searchResults;
    private CartContents cartContents;
    private Buy buy;
    private Treasury treasury;

    EnvironmentData env;
    Properties data;
    //ExtentReports extent;
    //ExtentHtmlReporter htmlReporter;
    private HomePage homePage;


    private String justBought = "";

    public EdgenuitySteps(PageFactory pageFactory){
        advancedSearch = pageFactory.newAdvancedSearch();
        home = pageFactory.newHome();
        site = pageFactory.newSite();
        searchResults = pageFactory.newSearchResults();
        cartContents = pageFactory.newCartContents();
        buy = pageFactory.newBuy();
        treasury = pageFactory.newTreasury();
        env= new EnvironmentData();
       // driver= env.doCreateWebDriver();
        data= env.getProperties();

        homePage = pageFactory.newHomePage();
      //  htmlReporter = new ExtentHtmlReporter("extent.html");
      //  extent = new ExtentReports();
    }

    @Given("user $username with password $passcode is on product page $url")
    public void loadProduct(String username, String passcode, String url) {
        System.out.println(" >>>> This is the Given!, I'm on steps/Example");
        //setEnvironment();

        String baseURL= data.getProperty("primaryURL");
        System.out.println("***> primaryURL: '"+baseURL+"'");
        //driver.get(baseURL);
        this.homePage.goToUrl(baseURL);
    }

    @When("the user clicks add to wishlist")
    public void addToWishlist() {
        System.out.println(" >>>> This is the When !!!!");
        //driver.findElement(By.class("addToWishlist"));
        //.click();
    }

    @Then("the wish list page is displayed")
    public void isWishlistPage() {
        //assertTrue("Wishlist page", driver.getCurrentUrl().matches(".*/gp/registry/wishlist.*"));
        System.out.println(" >>>> This is the Then !!!!");
    }

    @Then("the product $title appears on the wish list")
    public void checkProduct(String title) {
        // check product entries
        // assert if product not found
        System.out.println(" >>>> This is the Then 222!!!!");
        //quitDriverScenario();
    }


    @Given("I am shopping for a $thing in $section on Etsy.com")
    public void shoppingForSomethingOnEtsyDotCom(String thing, String section) {
        home.go(section);
        home.search(thing);
    }

    @Given("I am on etsy.com")
    public void homepageOnEtsyDotCom() {
        home.go();
    }

    @Given("I am searching on Etsy.com")
    public void advancedSearchingOnEtsyDotCom() {
        advancedSearch.go();
    }

    @Given("that the cart is empty")
    public void cartIsEmptyAndOnStartPage() {
        home.go();
        cartIsEmpty();
    }

    @Then("the cart will be empty")
    public void cartIsEmpty() {
        assertThat(site.cartSize(), equalTo(0));
    }

    @Then("the cart contents is empty")
    public void cartContentsIsEmpty() {
        assertThat(cartContents.cartSize(), equalTo(0));
    }

    @Given("the cart contains one item")
    public void anItemInTheEtsyCart() {
        shoppingForSomethingOnEtsyDotCom("hat", "Vintage");
        cartIsEmpty();
        putThingInCart("hat");
        cartNotEmpty(1);
    }

    @When("an item is added to the cart")
    public void putThingInCart() {
        putThingInCart("hat");
    }

    @When("I search for an item")
    public void searchForItem() {
        home.search("hat");
    }

    @When("I want to browse through a treasury gallery")
    @Composite(steps = { "When I want to buy something from etsy.com", "When I want to browse the treasury",
            "When I choose the first treasury gallery" })
    public void browseToFirstTreasuryGallery() {
    }

    @When("I want to buy something from etsy.com")
    public void selectBuyTabAtTop() {
        home.goToBuySection();
    }

    @When("I want to browse the treasury")
    public void browseTreasury() {
        buy.selectTreasury();
    }

    @When("I choose the first treasury gallery")
    public void selectFirstTreasuryGallery() {
        treasury.chooseFirstGallery();
    }

    @When("a $thing is placed in the cart")
    public void putThingInCart(String thing) {
        justBought = searchResults.buyFirst(thing);
        assertThat(justBought, Matchers.not("<not-bought>"));
    }

    @When("the item is removed")
    public void removeItem() {
        cartContents.removeItem();
    }

    @When("I specify the $subCat sub category")
    public void specifiSubCategory(String subCat) {
        advancedSearch.subCategory(subCat);
    }

    @When("I search for $thing")
    public void seachForThing(String thing) {
        advancedSearch.searchFor(thing);
    }

    @Then("the cart contains that item")
    public void cartHasThatItem() {
        assertThat(cartContents.hasItem(justBought), Matchers.is(true));
    }

    @Then("the cart has $num items")
    @Alias("the cart has $num item")
    public void cartNotEmpty(int num) {
        assertThat(site.cartSize(), Matchers.equalTo(num));
    }

    @Then("there are search results")
    @Alias("results will be displayed in the gallery")
    public void thereAreSearchResults() {
        assertThat(searchResults.resultsFound(), Matchers.greaterThan(0));
    }
}
