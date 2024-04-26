package QKART_SANITY_LOGIN.Module1;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

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
        parentElement.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-yg30e6']"));
        titleOfSearchResult = parentElement.getText();
        return titleOfSearchResult;
    }









    /*
     * Return Boolean denoting if the open size chart operation was successful
     */
    public Boolean openSizechart() 
    {
        try 
        {

            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 04: MILESTONE 2
            // Find the link of size chart in the parentElement and click on it
           WebElement size_link =  parentElement.findElement(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 product-grid css-1w6ph7q')]//div[1]//div[1]//div[1]//button[1]"));
            size_link.click();
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
        }
         catch (Exception e) 
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
        try 
        {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 04: MILESTONE 2
            /*
             * Check if the size chart element exists. If it exists, check if the text of
             * the element is "SIZE CHART". If the text "SIZE CHART" matches for the
             * element, set status = true , else set to false  size_chart.isDisplayed() &&
             */
            //WebElement size_chart = parentElement.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 product-grid css-1w6ph7q']//div[1]//div[1]//div[1]//button[1]"));
            
            //if(size_chart.getText().contains("SIZE CHART")){
                //status = true;
            //}
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
            WebDriver driver) {
        Boolean status = true;
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
            WebElement size_chart = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/table"));

            List<WebElement> tableHeaders = size_chart.findElements(By.tagName("th"));
            List<String> actual = new ArrayList<>();
            for(WebElement header:tableHeaders){
                actual.add(header.getText());
            }
            if(actual.equals(expectedTableHeaders)){
                status = true;
            }
            if(actual.contains("UK/INDIA")){
                status = true;
            }
            Thread.sleep(3000);
            //row1
            List<WebElement> tableRowElements = new ArrayList<>();
            tableRowElements = size_chart.findElements(By.xpath("//table//tbody//tr[1]//td"));
            List<String> table_row1 = new ArrayList<>();
            for(WebElement table:tableRowElements){
                table_row1.add(table.getText());
            }
            boolean variable1 = table_row1.equals(expectedTableBody.get(0));
            //System.out.println(variable1);

            //row2
            List<WebElement> tableRowElements2 = new ArrayList<>();
            tableRowElements = size_chart.findElements(By.xpath("//table//tbody//tr[2]//td"));
            List<String> table_row2 = new ArrayList<>();
            for(WebElement table:tableRowElements2){
                table_row2.add(table.getText());
            }
            boolean variable2 = table_row2.equals(expectedTableBody.get(1));
            //System.out.println(variable2);

            //row3
            List<WebElement> tableRowElements3 = new ArrayList<>();
            tableRowElements = size_chart.findElements(By.xpath("//table//tbody//tr[3]//td"));
            List<String> table_row3 = new ArrayList<>();
            for(WebElement table:tableRowElements3){
                table_row3.add(table.getText());
            }
            boolean variable3 = table_row3.equals(expectedTableBody.get(2));
            //System.out.println(variable3);

            //row4
            List<WebElement> tableRowElements4 = new ArrayList<>();
            tableRowElements = size_chart.findElements(By.xpath("//table//tbody//tr[4]//td"));
            List<String> table_row4 = new ArrayList<>();
            for(WebElement table:tableRowElements4){
                table_row4.add(table.getText());
            }
            boolean variable4 = table_row4.equals(expectedTableBody.get(3));
            //System.out.println(variable4);

            //row5
            List<WebElement> tableRowElements5 = new ArrayList<>();
            tableRowElements = size_chart.findElements(By.xpath("//table//tbody//tr[5]//td"));
            List<String> table_row5 = new ArrayList<>();
            for(WebElement table:tableRowElements5){
                table_row5.add(table.getText());
            }
            boolean variable5 = table_row5.equals(expectedTableBody.get(4));
            //System.out.println(variable5);

            //row6
            List<WebElement> tableRowElements6 = new ArrayList<>();
            tableRowElements = size_chart.findElements(By.xpath("//table//tbody//tr[6]//td"));
            List<String> table_row6 = new ArrayList<>();
            for(WebElement table:tableRowElements6){
                table_row6.add(table.getText());
            }
            boolean variable6 = table_row6.equals(expectedTableBody.get(5));
            //System.out.println(variable6);

            //row7
            List<WebElement> tableRowElements7 = new ArrayList<>();
            tableRowElements = size_chart.findElements(By.xpath("//table//tbody//tr[7]//td"));
            List<String> table_row7 = new ArrayList<>();
            for(WebElement table:tableRowElements7){
                table_row7.add(table.getText());
            }
            boolean variable7 = table_row7.equals(expectedTableBody.get(6));
            //System.out.println(variable7);

            if(variable1 && variable2 && variable3 && variable3 && variable4 && variable5 && variable6 && variable7){
                status = true;
            }
            return status;
            
        }
        catch (Exception e) {
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
            WebElement size_dropdown = driver.findElement(By.xpath("//*[@id='uncontrolled-native']"));
            if(size_dropdown.isDisplayed()){
                status = true;
            }
            return status;
        } catch (Exception e) {
            return status;
        }
    }
}