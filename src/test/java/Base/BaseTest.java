package Base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        String browser = "chrome";

        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        driver.get("https://www.levelset.com/");
    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }


}
