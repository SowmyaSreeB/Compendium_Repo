package pages;

import commonMethods.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readDataFromFile.ReadData;


public class LaunchPage {
    public WebDriver driver;
    SeleniumActions seleniumActions;
    ReadData readData;

    public LaunchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        System.out.println("Driver assigning");
        seleniumActions = new SeleniumActions(driver);
        readData = new ReadData();
    }

    @FindBy(xpath = "//div[@class='midheight']/div/ul/li/a[text()='Contact']")
    WebElement contact;

    @FindBy(xpath = "//div[@id='formContent']/div/div/following-sibling::div/div/div/input")
    WebElement namebox;

    @FindBy(xpath = "//div[@id='formContent']/div/following-sibling::div/div/following-sibling::div/div/div/input[@name='email']")
    WebElement emailbox;

    @FindBy(xpath = "//div[@id='formContent']/div/following-sibling::div/div/following-sibling::div/div/../../following-sibling::div/div/following-sibling::div/div/div/textarea[@name='message']")
    WebElement messagebox;

    @FindBy(xpath = "//div[@class='CheckBox']")
    WebElement checkbox;

    @FindBy(xpath = "//div[@class='buttonIcon']")
    WebElement button;



    public void clickContact() {

        contact.click();
    }

    public void fillForm() throws Exception {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
       /* namebox.sendKeys("Abcdefgh");
        emailbox.sendKeys("abcd@gmail.com");
        messagebox.sendKeys("hello! welcome to my world");
        Thread.sleep(1000);
        checkbox.click();
        button.click();*/

        seleniumActions.EnterValueOnTextfield(namebox,readData.readFile("name"));
        seleniumActions.EnterValueOnTextfield(emailbox,readData.readFile("email"));
        seleniumActions.EnterValueOnTextfield(messagebox,readData.readFile("message"));
        seleniumActions.clickOnElement(checkbox);
        seleniumActions.clickOnElement(button);
    }

    public WebElement verification() {
        //String sucessfullMessage = "Thanks for your question. We'll send you an answer via email to abcd@gmail.com";
       WebElement successfulmessage = driver.findElement(By.xpath("//div[@class='Success']/div/div"));
        return successfulmessage;
    }

}
