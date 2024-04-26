package QKART_SANITY_LOGIN.Module1;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResult
 {
    WebElement parentElement;



    public SearchResult(WebElement SearchResultElement)
     {
        this.parentElement = SearchResultElement;
    }

    /*
     * Return title of the parentElement denoting the card content section of a
     * search result
     */




    public String getTitleofResult()
     {
        String titleOfSearchResult = "";
        // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 03: MILESTONE 1
        // Find the element containing the title (product name) of the search result and
        // assign the extract title text to titleOfSearchResult
        titleOfSearchResult=parentElement.getText();
        
        return titleOfSearchResult;
    }
    











    /*
     * Return Boolean denoting if the open size chart operation was successful
     */
    public Boolean openSizechart()
     {
        try {

            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 04: MILESTONE 2
            // Find the link of size chart in the parentElement and click on it

            WebElement sizechartLink=parentElement.findElement(By.xpath("//button[contains(text(),'Size chart')]"));
            sizechartLink.click();

            return true;
        }
         catch (Exception e)
          {
            System.out.println("Exception while opening Size chart: " + e.getMessage());
            return false;
        }
    }













    /*
     * Return Boolean denoting if the close size chart operation was successful
     */
    public Boolean closeSizeChart(WebDriver driver) 
    {
        try
        
        
        {
            Thread.sleep(2000);
            Actions action = new Actions(driver);

            // Clicking on "ESC" key closes the size chart modal
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            Thread.sleep(2000);
            return true;
        } catch (Exception e)
         {
            System.out.println("Exception while closing the size chart: " + e.getMessage());
            return false;
        }
    }






    /*
     * Return Boolean based on if the size chart exists
     */
    public Boolean verifySizeChartExists() 
    {
        Boolean status = false;
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 04: MILESTONE 2
            /*
             * Check if the size chart element exists. If it exists, check if the text of
             * the element is "SIZE CHART". If the text "SIZE CHART" matches for the
             * element, set status = true , else set to false
             */

            String SizeChartExist=parentElement.getText();
            if(SizeChartExist.contains("SIZE CHART"))
            {
                status=true;
            }




            return status;
        } 
        catch (Exception e)
         {
            return status;
        }
    }












    /*
     * Return Boolean if the table headers and body of the size chart matches the
     * expected values
     */
    public Boolean validateSizeChartContents(List<String> expectedTableHeaders, List<List<String>> expectedTableBody,
            WebDriver driver) throws InterruptedException
            {
        Boolean status = false;
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 04: MILESTONE 2
            /*
             * Locate the table element when the size chart modal is open
             * 
             * Validate that the contents of expectedTableHeaders is present as the table
             * header in the same order
             * 
             * Validate that the contents of expectedTableBody are present in the table body
             * in the same order
             */
            // validating headers

            Thread.sleep(5000);
            List<WebElement> headers=new ArrayList<WebElement>();
            List<String> headersDetails=new ArrayList<String>();
            
            headers=driver.findElements(By.xpath("//table//th"));
           // System.out.println("size of headers = "+headers.size());

            for(WebElement wb:headers)
            {
                headersDetails.add(wb.getText());
            }
            
          //  System.out.println(headersDetails);

            Boolean headerSattaus=expectedTableHeaders.equals(headersDetails);
          //  System.out.println("Both expected and heardeDetails table are equals "+headerSattaus);



            Thread.sleep(5000);
            // body row 1

            List<WebElement> headersRow1=new ArrayList<WebElement>();
            headersRow1=driver.findElements(By.xpath("//table//tbody//tr[1]//td"));

            List<String> headersDetailsRow1=new ArrayList<String>();
            for(WebElement wb1:headersRow1)
            {
                headersDetailsRow1.add(wb1.getText());
            }

          //  System.out.println("The row values from headersDetailsRow1 table body = "+headersDetailsRow1);
          //  System.out.println("The first row from expected table body = "+expectedTableBody.get(0));
            boolean Row1Status=headersDetailsRow1.equals(expectedTableBody.get(0));
         //  System.out.println("Both expected and heardeDetails row1 are equals ? "+Row1Status);



           Thread.sleep(5000);
           // body row 2

           List<WebElement> headersRow2=new ArrayList<WebElement>();
           headersRow2=driver.findElements(By.xpath("//table//tbody//tr[2]//td"));

           List<String> headersDetailsRow2=new ArrayList<String>();
           for(WebElement wb2:headersRow2)
           {
               headersDetailsRow2.add(wb2.getText());
           }

      
           Boolean Row2Status=headersDetailsRow2.equals(expectedTableBody.get(1));
         // System.out.println("Both expected and heardeDetails row2 are equals ? "+Row2Status);


          Thread.sleep(5000);
          // body row 3

          List<WebElement> headersRow3=new ArrayList<WebElement>();
          headersRow3=driver.findElements(By.xpath("//table//tbody//tr[3]//td"));

          List<String> headersDetailsRow3=new ArrayList<String>();
          for(WebElement wb3:headersRow3)
          {
              headersDetailsRow3.add(wb3.getText());
          }

     
          Boolean Row3Status=headersDetailsRow3.equals(expectedTableBody.get(2));
         //System.out.println("Both expected and heardeDetails row3 are equals ? "+Row3Status);



         Thread.sleep(5000);
          // body row 4

          List<WebElement> headersRow4=new ArrayList<WebElement>();
          headersRow4=driver.findElements(By.xpath("//table//tbody//tr[4]//td"));

          List<String> headersDetailsRow4=new ArrayList<String>();
          for(WebElement wb4:headersRow4)
          {
              headersDetailsRow4.add(wb4.getText());
          }

     
          Boolean Row4Status=headersDetailsRow4.equals(expectedTableBody.get(3));
         //System.out.println("Both expected and heardeDetails row4 are equals ? "+Row4Status);




         Thread.sleep(5000);
          // body row 5

          List<WebElement> headersRow5=new ArrayList<WebElement>();
          headersRow5=driver.findElements(By.xpath("//table//tbody//tr[5]//td"));

          List<String> headersDetailsRow5=new ArrayList<String>();
          for(WebElement wb5:headersRow5)
          {
              headersDetailsRow5.add(wb5.getText());
          }

     
          Boolean Row5Status=headersDetailsRow5.equals(expectedTableBody.get(4));
         //System.out.println("Both expected and heardeDetails row5 are equals ? "+Row5Status);



         Thread.sleep(5000);

           // body row 6

           List<WebElement> headersRow6=new ArrayList<WebElement>();
           headersRow6=driver.findElements(By.xpath("//table//tbody//tr[6]//td"));
 
           List<String> headersDetailsRow6=new ArrayList<String>();
           for(WebElement wb6:headersRow6)
           {
               headersDetailsRow6.add(wb6.getText());
           }
 
      
           Boolean Row6Status=headersDetailsRow6.equals(expectedTableBody.get(5));
          //System.out.println("Both expected and heardeDetails row6 are equals ? "+Row6Status);



          Thread.sleep(5000);
            // body row 7

            List<WebElement> headersRow7=new ArrayList<WebElement>();
            headersRow7=driver.findElements(By.xpath("//table//tbody//tr[7]//td"));
  
            List<String> headersDetailsRow7=new ArrayList<String>();
            for(WebElement wb7:headersRow7)
            {
                headersDetailsRow7.add(wb7.getText());
            }
  
       
            Boolean Row7Status=headersDetailsRow7.equals(expectedTableBody.get(6));
           //System.out.println("Both expected and heardeDetails row7 are equals ? "+Row7Status);


           
            

            if(headerSattaus && Row1Status && Row2Status && Row3Status && Row4Status && Row5Status && Row6Status && Row7Status )
            {
                status=true;
            }


            return status;

        }
         catch (Exception e) 
        {
            System.out.println("Error while validating chart contents");
            return false;
        }
    }













    /*
     * Return Boolean based on if the Size drop down exists
     */
    public Boolean verifyExistenceofSizeDropdown(WebDriver driver) {
        Boolean status = false;
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 04: MILESTONE 2
            // If the size dropdown exists and is displayed return true, else return false
          
           String sizedropdowncontent= parentElement.getText();

           if(sizedropdowncontent.contains("6") && sizedropdowncontent.contains("7") && sizedropdowncontent.contains("8"))
           {
            status=true;
           }


            return status;
        } catch (Exception e) {
            return status;
        }
    }
}