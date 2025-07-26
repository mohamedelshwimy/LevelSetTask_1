package Tests;

import Base.BaseTest;
import Pages.DocumentsPage;
import Pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetDocumentsName extends BaseTest {

    DocumentsPage documentsPage;

    @Test
    public void goToDocumentsPage() {
        SoftAssert softAssert = new SoftAssert();

        documentsPage = homePage.clickGetPaidBtn();

        softAssert.assertAll();
    }
}
