package Tests;

import Base.BaseTest;
import Pages.DocumentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


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
