package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DocumentsPage {

    private WebDriver driver;
    public DocumentsPage (WebDriver driver){
        this.driver = driver;
    }

    public List<String> expectedFreeDocs = Arrays.asList("Exchange a Waiver", "Send a Payment Document");

    //Locators
    private By freeDocuments = By.xpath("//span[contains(.,'Free')]//ancestor::div[contains(@class,'panel-heading')]//div[@class='left']");

    //Methods
    public List<String> getFreeDocumentsNames() {

        List<String> freeDocs = new ArrayList<>();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(freeDocuments));

        List<WebElement> docs = driver.findElements(freeDocuments);
        System.out.println("Number of free documents -> " + docs.size());

        for (WebElement doc : docs) {
            String docName = doc.getText();
            freeDocs.add(docName);
            System.out.println("Added docName = " + docName);
        }
        return freeDocs;
    }

    //Handle Exceptions
    public List<String> getFreeDocumentsNames_2() {

        try {

            return getFreeDocuments();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            driver.navigate().refresh();

            return getFreeDocuments();
        }
    }

    List<String> getFreeDocuments() {
        List<String> freeDocs = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(freeDocuments));
        List<WebElement> docs = driver.findElements(freeDocuments);
        System.out.println("Number of free documents: " + docs.size());

        for (WebElement doc : docs) {
            String docName = doc.getText().trim();
            freeDocs.add(docName);
        }

        return freeDocs;
    }

}
