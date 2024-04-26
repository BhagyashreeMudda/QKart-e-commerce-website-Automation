package QKART_SANITY_LOGIN.Module1;

import java.util.ArrayList;
import java.util.*;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

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
        try {
            // Find and click on the Logout Button
            WebElement logout_button = driver.findElement(By.className("MuiButton-text"));
            logout_button.click();

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

           WebElement searchBox= driver.findElement(By.xpath("(//input)[1]"));

           searchBox.clear();

           searchBox.sendKeys(product);

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
        List<WebElement> searchResults = new ArrayList<WebElement>() ;
        
        try
         {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 03: MILESTONE 1
            // Find all webelements corresponding to the card content section of each of
            // search results
         //   searchResults = driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 css-1msksyp']//child::div//child::div//child::div[1]//p[1]"));
         searchResults = driver.findElements(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root card css-s18byi']"));

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
        WebElement noprodpage=driver.findElement(By.cssSelector("div[class='loading MuiBox-root css-0'] h4"));


        Boolean status = false;

        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 03: MILESTONE 1
            // Check the presence of "No products found" text in the web page. Assign status
            // = true if the element is *displayed* else set status = false

            status=noprodpage.isDisplayed();
            


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
            List<WebElement> ALlProduct=new ArrayList<WebElement>();
            ALlProduct=driver.findElements(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root card css-s18byi']"));

            // adding to cart , 

            for(WebElement wb2:ALlProduct)
		    {
               
		    	Thread.sleep(3000);
			    wb2.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
                
                    return true;
                
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

            WebElement Checkout=driver.findElement(By.xpath("//button[contains(text(),'Checkout')]"));
		     Checkout.click();
             status=true;


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
    public Boolean changeProductQuantityinCart(String productName, int quantity) {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 06: MILESTONE 5

            // Find the item on the cart with the matching productName

           // List<WebElement> ProdDetailsinCheckPage=new ArrayList<WebElement>();
		     
           WebDriverWait wait=new WebDriverWait(driver,3);
         //  String productName="Yarine Floor Lamp";
           
      
           List<WebElement> cartProducts=driver.findElements(By.className("css-zgtx0t"));
          // System.out.println("Total products in cart = "+cartProducts.size());
           Thread.sleep(3000);
       
           int currentProdQuantity;
       
           for(int i=1;i<=cartProducts.size();i++)
           {
           
           
               // matching product name from cart
           
               if(productName.contains(driver.findElement(By.xpath("(//*[@class='MuiBox-root css-zgtx0t'])["+i+"]//*[@class='MuiBox-root css-1gjj37g']/div[1]")).getText()))
               {
               
                   // click +/- for prod qaunitty
               
                   currentProdQuantity=Integer.valueOf(cartProducts.get(i-1).findElement(By.className("css-olyig7")).getText());
               
                   while(currentProdQuantity!=quantity)
                   {
                       if(currentProdQuantity<quantity)
                       {
                           //increase quantity
                           cartProducts.get(i-1).findElements(By.tagName("button")).get(1).click();
                       
                           wait.until(ExpectedConditions.textToBePresentInElement(cartProducts.get(i-1).findElement(By.className("css-olyig7")), String.valueOf(currentProdQuantity+1)));
                           
                           Thread.sleep(3000);
                       
                       }
                       else
                       {
                           //decrease quatityt
                           
                           cartProducts.get(i-1).findElements(By.tagName("button")).get(0).click();
                           
                           Thread.sleep(3000);
                           
                       
                       }
                   
                       currentProdQuantity=Integer.valueOf(cartProducts.get(i-1).findElement(By.xpath("//div[@data-testid=\"item-qty\"]")).getText());
                       
                       
                       
                   }
                   
                   
               return true;
               
               
               
               }
               
           
           
           
           
           
           }

           return false;
           
           
      
       
       } 
                

                        
		    
            // Increment or decrement the quantity of the matching product until the current
            // quantity is reached (Note: Keep a look out when then input quantity is 0,
            // here we need to remove the item completely from the cart)


           
        


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
    public Boolean verifyCartContents(List<String> expectedCartContents) {
        try {
            WebElement cartParent = driver.findElement(By.className("cart"));
            List<WebElement> cartContents = cartParent.findElements(By.className("css-zgtx0t"));

            ArrayList<String> actualCartContents = new ArrayList<String>() {
            };
            for (WebElement cartItem : cartContents) {
                actualCartContents.add(cartItem.findElement(By.className("css-1gjj37g")).getText().split("\n")[0]);
            }

            for (String expected : expectedCartContents) {
                if (!actualCartContents.contains(expected)) {
                    return false;
                }
            }

            return true;

        } catch (Exception e) {
            System.out.println("Exception while verifying cart contents: " + e.getMessage());
            return false;
        }
    }
}
