package Tests;

import Base.BaseTest;
import Pages.DocumentsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetDocumentsName extends BaseTest {

    DocumentsPage documentsPage;

    @Test
    public void goToDocumentsPage() {

        documentsPage = homePage.clickGetPaidBtn();

        int numberOfFreeDocs = documentsPage.getFreeDocumentsNames().size();
        System.out.println("numberOfFreeDocs = " + numberOfFreeDocs);

        Assert.assertEquals(numberOfFreeDocs, 2, "Incorrect Free Docs number");

    }
}
