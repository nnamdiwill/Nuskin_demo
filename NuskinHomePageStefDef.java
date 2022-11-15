package stepdefs;

import Base.NuSkinHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NuskinHomePageStefDef {


    NuSkinHomePage nshp = new NuSkinHomePage();

    @Given("^I open the nuskin website$")
    public void openNuskinBrowser(){
        nshp.openBrowser();
    }

    @When("^I add item to cart$")
    public void addItem(){

        nshp.pushItemtoCart();
    }

    @Then("^I take a screenshot and close$")
    public void screenShotAndClose(){

       nshp.add2CartandTakePic();


    }

    @Given("^I open up the webpage$")
    public void openWeb(){

        nshp.openBrowser();
    }

    @When("^I type in searchbox$")
    public void typeInSearchBox(){

        nshp.typeSearchBox();
    }

    @Then("^I put the items into a list and close$")
    public void itemList(){

        nshp.createSkinBeautyList();
    }
}
