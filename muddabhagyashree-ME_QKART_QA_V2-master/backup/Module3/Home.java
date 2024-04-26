package QKART_SANITY_LOGIN.Module1;

import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.TreeBasedTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home 
{
    RemoteWebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app";



    public Home(RemoteWebDriver driver) 
    {
        this.driver = driver;
    }





    public void navigateToHome()
     {
        if (!this.driver.getCurrentUrl().equals(this.url)) 
        {
            this.driver.get(this.url);
        }
    }







    public Boolean PerformLogout() throws InterruptedException
     {
        try
         {
            // Find and click on the Logout Button
            WebElement logout_button = driver.findElement(By.className("MuiButton-text"));
            logout_button.click();

            // SLEEP_STMT_10: Wait for Logout to complete
            // Wait for Logout to Complete
            Thread.sleep(3000);

            return true;
        }
         catch (Exception e)
          {
            // Error while logout
            return false;
        }
    }








    /*
     * Returns Boolean if searching for the given product name occurs without any
     * errors
     */
    public Boolean searchForProduct(String product) 
    {
        try 
        {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 03: MILESTONE 1
            // Clear the contents of the search box and Enter the product name in the search
            // box
            WebElement search_box = driver.findElement(By.xpath("//*[@id='root']/div/div/div[1]/div[2]/div/input"));
            search_box.clear();
            search_box.sendKeys(product);
            //Thread.sleep(5000);
            
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.or(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/div/div/div[3]/div[1]/div[2]/div/h4"), "No products found"),
            ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/div/div[3]/div[1]/div[2]/div[1]/div/div[2]/button"))));
            return true;
        } 
        catch (Exception e)
         {
            System.out.println("Error while searching for a product: " + e.getMessage());
            return false;
        }
    }













    /*
     * Returns Array of Web Elements that are search results and return the same
     */
    public List<WebElement> getSearchResults()
     {
        List<WebElement> searchResults = new ArrayList<WebElement>(); 
        
        try 
        {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 03: MILESTONE 1
            // Find all webelements corresponding to the card content section of each of
            // search results
            searchResults = driver.findElements(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root card css-s18byi']"));
            //searchResults.addAll(card_Elements);
            return searchResults;
        } 
        catch (Exception e)
         {
            System.out.println("There were no search results: " + e.getMessage());
            return searchResults;

        }
    }











    /*
     * Returns Boolean based on if the "No products found" text is displayed
     */
    public Boolean isNoResultFound()
     {
        Boolean status = false;
        try
         {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 03: MILESTONE 1
            // Check the presence of "No products found" text in the web page. Assign status
            // = true if the element is displayed else set status = false
            WebElement no_results = driver.findElement(By.xpath("//h4[normalize-space()='No products found']"));
            if(no_results.isDisplayed())
            {
                status = true;
            }
            return status;
        } 
        catch (Exception e) 
        {
            return status;
        }
    }










    /*
     * Return Boolean if add product to cart is successful
     */
    public Boolean addProductToCart(String productName) 
    {
        try 
        {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Iterate through each product on the page to find the WebElement corresponding
             * to the matching productName
             * 
             * Click on the "ADD TO CART" button for that element
             * 
             * Return true if these operations succeeds
             */
            List<WebElement> product_elements = driver.findElements(By.xpath("//*[@id='root']/div/div/div[3]/div/div[2]"));
            for(int i = 1; i <= product_elements.size();i++){
                String product = driver.findElement(By.xpath("//*[@id='root']/div/div/div[3]/div/div[2]/div['+i+']")).getText();
                if(product.contains(productName))
                {
                    driver.findElement(By.xpath("//*[@id='root']/div/div/div[3]/div/div[2]/div['+i+']//button")).click();
                    Thread.sleep(2000);
                    return true;
                }
            }
            
            System.out.println("Unable to find the given product");
            return false;
        }
         catch (Exception e) 
         {
            System.out.println("Exception while performing add to cart: " + e.getMessage());
            return false;
        }
    }












    /*
     * Return Boolean denoting the status of clicking on the checkout button
     */
    public Boolean clickCheckout()
     {
        Boolean status = false;
        try 
        {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            // Find and click on the the Checkout button
            WebElement check_outBtn = driver.findElement(By.xpath("//button[normalize-space()='Checkout']"));
            check_outBtn.click();
            return status;
        } 
        catch (Exception e)
         {
            System.out.println("Exception while clicking on Checkout: " + e.getMessage());
            return status;
        }
    }











    /*
     * Return Boolean denoting the status of change quantity of product in cart
     * operation
     */
    public Boolean changeProductQuantityinCart(String productName, int quantity) 
    {
        try
         {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 06: MILESTONE 5

            // Find the item on the cart with the matching productName

            // Increment or decrement the quantity of the matching product until the current
            // quantity is reached (Note: Keep a look out when then input quantity is 0,
            // here we need to remove the item completely from the cart)

            WebElement cart=driver.findElement(By.className("cart"));
            
            WebElement increment=cart.findElement(By.xpath("//div[normalize-space()='"+productName+"']//parent::div//button[2]"));
            WebElement decrement=cart.findElement(By.xpath("//div[normalize-space()='"+productName+"']//parent::div//button[1]"));
            WebElement current_quantity=cart.findElement(By.xpath("//div[normalize-space()='"+productName+"']//parent::div//div[@data-testid='item-qty']"));
            
            if(Integer.parseInt(current_quantity.getText()) < quantity && quantity !=0)
             {
                //System.out.println(current_quantity.getText()+" "+quantity);
                while(quantity != Integer.parseInt(current_quantity.getText()))
                 {
                    increment.click();
                    Thread.sleep(2000);
                    //WebDriverWait wait = new WebDriverWait(driver, 30);
                    //wait.until(ExpectedConditions.textToBePresentInElement(driver.findElements(By.tagName("button")).get(1), String.valueOf(Integer.parseInt(current_quantity.getText())+1)));
                }
            }

            else if(Integer.parseInt(current_quantity.getText()) > quantity && quantity !=0) 
            {
                while(quantity != Integer.parseInt(current_quantity.getText())) 
                {
                    decrement.click();
                    Thread.sleep(2000);
                    //WebDriverWait wait = new WebDriverWait(driver, 30);
                    //wait.until(ExpectedConditions.textToBePresentInElement(driver.findElements(By.tagName("button")).get(1), String.valueOf(Integer.parseInt(current_quantity.getText())-1)));
                }
            }



            else
             {
                while(Integer.parseInt(current_quantity.getText()) !=0) 
                {
                    decrement.click();
                    Thread.sleep(2000);
                }
            }

            return true;
            //return false;
        } 
        catch (Exception e)
         {
            if (quantity == 0)
                return true;
            System.out.println("exception occurred when updating cart: " + e.getMessage());
            return false;
        }
    }










    /*
     * Return Boolean denoting if the cart contains items as expected
     */
    public Boolean verifyCartContents(List<String> expectedCartContents)
     {
        try 
        {
            WebElement cartParent = driver.findElement(By.className("cart"));
            List<WebElement> cartContents = cartParent.findElements(By.className("css-zgtx0t"));

            ArrayList<String> actualCartContents = new ArrayList<String>() {
            };
            for (WebElement cartItem : cartContents) 
            {
                actualCartContents.add(cartItem.findElement(By.className("css-1gjj37g")).getText().split("\n")[0]);
            }

            for (String expected : expectedCartContents)
             {
                if (!actualCartContents.contains(expected)) 
                {
                    return false;
                }
            }

            return true;

        } 
        catch (Exception e) 
        {
            System.out.println("Exception while verifying cart contents: " + e.getMessage());
            return false;
        }
    }
}



