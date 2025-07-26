package Tests;

import Base.BaseTest;
import Pages.DocumentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;


public class GetDocumentsName extends BaseTest {

    DocumentsPage documentsPage;

    @Test
    public void goToDocumentsPage() {
        SoftAssert softAssert = new SoftAssert();

        documentsPage = homePage.clickGetPaidBtn();

        int numberOfFreeDocs = documentsPage.getFreeDocumentsNames().size();
        System.out.println("numberOfFreeDocs = " + numberOfFreeDocs);


        softAssert.assertEquals(numberOfFreeDocs, 2, "Incorrect Free Docs number");

        List<String> actualFreeDocs = documentsPage.getFreeDocumentsNames();

        Collections.sort(actualFreeDocs);
        Collections.sort(documentsPage.expectedFreeDocs);
        System.out.println("expectedFreeDocs = " + documentsPage.expectedFreeDocs);
        System.out.println("actualFreeDocs = " + actualFreeDocs);

        softAssert.assertEquals(actualFreeDocs, documentsPage.expectedFreeDocs, "Incorrect Free Docs");

        softAssert.assertAll();
    }
}
