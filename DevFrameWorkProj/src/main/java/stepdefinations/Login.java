package stepdefinations;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

    public class Login extends Base{
    	 WebDriver driver ;	
    	 LandingPage landingpage;
    	 LoginPage loginpage;
    	 AccountPage accountpage;


   @Given("^Open any Browser$")
   public void Open_any_Browser() throws IOException  {
	 driver = initializeDriver();  
	   
			   }
   
   @And ("^Navigate to Login page$")
   public void Navigate_to_Login_page() {
	   
	   driver.get(prop.getProperty("url"));
	   landingpage = new LandingPage(driver);
       landingpage.myAccountDropdown().click();
       landingpage.loginoptions().click();
   }
   
   @When("^User enters Username as \"([^\"]*)\" and Password as \"([^\"]*)\" into the fields$")
	public void User_enters_Username_as_somthing_and_Password_as_something_into_the_fields(String email , String password) {
	   loginpage = new LoginPage(driver);
       loginpage.EmailAddressField().sendKeys(email);
       loginpage.PasswordField().sendKeys(password);
  
      
   }
   
   @And("^User clicks on Login button$")
   public void User_clicks_on_Login_button() {
	   loginpage.LoginButton().click();
	   
   }
   @Then("^ Verify user is able to successfully login$")
   public void Verify_user_is_able_to_successfully_login() {
	  accountpage= new AccountPage(driver);
	   Assert.assertTrue(accountpage.EditAccountOption().isDisplayed());
   }
   @After
   public void closure() {
	   driver.close();
	   
   }
}
