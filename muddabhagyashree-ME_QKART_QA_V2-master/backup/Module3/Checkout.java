package QKART_SANITY_LOGIN.Module1;

import java.util.List;

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
    public Boolean addNewAddress(String addresString) 
    {
        try 
        {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Click on the "Add new address" button, enter the addressString in the address
             * text box and click on the "ADD" button to save the address
             */
            WebElement address_btn = driver.findElement(By.xpath("//button[@id='add-new-btn']"));
            address_btn.click();

            WebElement address_text_area = driver.findElement(By.xpath("//textarea[@placeholder='Enter your complete address']"));
            address_text_area.sendKeys(addresString);
            driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
            //Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='root']/div/div[2]/div[1]/div/div[1]/div/div[1]/p"), addresString));
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
            List<WebElement> address_boxes = driver.findElements(By.xpath("//div[@class='shipping-container MuiBox-root css-vooagt']//div[@class='MuiBox-root css-0']"));

            for(WebElement address: address_boxes)
            {
                WebElement address_element = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div/div[1]/div"));

                String address_text = address_element.getText();
                if(address_text.contains(addressToSelect))
                {
                    driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div/div[1]/div['+i+']")).click();
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
            WebElement place_orderbtn = driver.findElement(By.xpath("//button[normalize-space()='PLACE ORDER']"));
            place_orderbtn.click();

            return true;

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
    public Boolean verifyInsufficientBalanceMessage() 
    {
        try 
        {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 07: MILESTONE 6
            WebElement error_msg = driver.findElement(By.xpath("//div[@id='notistack-snackbar']"));
            String ErrorMessage = error_msg.getText();
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