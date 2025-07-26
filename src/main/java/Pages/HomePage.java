package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver = driver;
    }


    //Locators
    By getPaidBtn = By.xpath("//a[contains(.,'Get paid')]");

    //Methods
    public DocumentsPage clickGetPaidBtn(){
        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(getPaidBtn));

        WebElement getPaid = driver.findElement(getPaidBtn);
        actions.doubleClick(getPaid).perform();

        return new DocumentsPage(driver);
    }
}
