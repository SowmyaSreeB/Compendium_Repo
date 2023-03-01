package steps;

import commonMethods.SeleniumActions;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LaunchPage;

public class Steps {

    WebDriver driver;
    LaunchPage launchPage;

    @Before
    public void initializeWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("User launches URL")
    public void user_launches_url() {
        driver.get("https://compendiumdev.co.uk/");
        launchPage = new LaunchPage(driver);
        System.out.println("URL launches");
    }

    @When("User clicks on contact")
    public void user_clicks_on_contact() {
        launchPage.clickContact();
        System.out.println("Contact is clicked");
    }

    @Then("User fills the form")
    public void user_fills_the_form() throws Exception {
        launchPage.fillForm();
        System.out.println("Form is filled");
    }

    @Then("User verify the form is submitted successfully")
    public void user_verify_the_form_is_submitted_successfully() throws InterruptedException {
        Thread.sleep(3330);
        Assert.assertTrue(launchPage.verification().isDisplayed());
        System.out.println("Form is submitted successfuly");
    }

    @Then("User closes the browser")
    public void user_closes_the_browser() {
        System.out.println("Browser is closed");
    }

}
