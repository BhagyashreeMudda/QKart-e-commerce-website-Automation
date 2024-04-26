package QKART_SANITY_LOGIN.Module1;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout
 {
    RemoteWebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app/checkout";



    public Checkout(RemoteWebDriver driver)
     {
        this.driver = driver;
    }





    public void navigateToCheckout()
     {
        if (!this.driver.getCurrentUrl().equals(this.url))
         {
            this.driver.get(this.url);
        }
    }









    /*
     * Return Boolean denoting the status of adding a new address
     */
    public Boolean addNewAddress(String addresString)  throws InterruptedException
    {
        try
         {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Click on the "Add new address" button, enter the addressString in the address
             * text box and click on the "ADD" button to save the address
             */
            WebElement AddNewAddress=driver.findElement(By.xpath("//button[contains(text(),'Add new address')]"));
            AddNewAddress.click();
            Thread.sleep(3000);
            
            
            
            WebElement TextArea=driver.findElement(By.xpath("//textarea[@placeholder='Enter your complete address']"));
            TextArea.sendKeys(addresString);
            Thread.sleep(3000);
            
            
            
            WebElement AddButton=driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
            Thread.sleep(3000);
            
            AddButton.click();
            
                return true;
            
            

            




            
        } 
        catch (Exception e)
         {
            System.out.println("Exception occurred while entering address: " + e.getMessage());
            return false;

        }
    }














    /*
     * Return Boolean denoting the status of selecting an available address
     */
    public Boolean selectAddress(String addressToSelect) 
    {
        try
         {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Iterate through all the address boxes to find the address box with matching
             * text, addressToSelect and click on it
             */
            List<WebElement> AllRadiobuttonsoptions=new ArrayList<WebElement>();
		    AllRadiobuttonsoptions=driver.findElements(By.xpath("//div[@class='address-item not-selected MuiBox-root css-0']//child::div[1]"));
		
		System.out.println("The size of list = "+AllRadiobuttonsoptions.size());
		
		for(WebElement wb3:AllRadiobuttonsoptions)
		{
			System.out.println(wb3.getText());
			
			if(wb3.getText().equals(addressToSelect))
			{
			//	System.out.println("contains");
			//	System.out.println("contains");
				wb3.click();
                return true;
				
				
			}
				
			
		}
		






            System.out.println("Unable to find the given address");
            return false;
        } 
        catch (Exception e) 
        {
            System.out.println("Exception Occurred while selecting the given address: " + e.getMessage());
            return false;
        }

    }

















    /*
     * Return Boolean denoting the status of place order action
     */
    public Boolean placeOrder()
     {
        try 
        {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            // Find the "PLACE ORDER" button and click on it

            WebElement PlaceOrder=driver.findElement(By.xpath("//button[contains(text(),'PLACE ORDER')]"));
		    PlaceOrder.click();

            String PlaceOrderURL=driver.getCurrentUrl();

            if(PlaceOrderURL.endsWith("/thanks"))
            {
                return true;

            }


            return false;

        } 
        catch (Exception e)
         {
            System.out.println("Exception while clicking on PLACE ORDER: " + e.getMessage());
            return false;
        }
    }










    

    /*
     * Return Boolean denoting if the insufficient balance message is displayed
     */
    public Boolean verifyInsufficientBalanceMessage() {
        try 
        {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 07: MILESTONE 6

                    String cartTotal=driver.findElement(By.xpath("//div[@data-testid='cart-total']")).getText();
		        	int cartTotall=Integer.parseInt(cartTotal.substring(1));
		        	System.out.println("total amoutn in cart = "+cartTotall);


                    String ErrorMessage=driver.findElement(By.xpath("//div[contains(text(),'You do not have enough balance in your wallet for this purchase')]")).getText();
                    if(ErrorMessage.contains("You do not have enough balance in your wallet for this purchase"))
                    {
                        return true;
                    }






            return false;
        } 
        catch (Exception e)
         {
            System.out.println("Exception while verifying insufficient balance message: " + e.getMessage());
            return false;
        }
    }
}
