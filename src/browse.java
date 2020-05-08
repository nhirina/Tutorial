import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class browse extends baseChrome {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver=Capabilities();
           //driver.get("http://facebook.com");
          // driver.findElementByXPath("//*[@id='m_login_email']").sendKeys("mysor@yahoo.com");
          // driver.findElementByXPath("//*[@id='m_login_password']").sendKeys("Accesso2019");
          // driver.findElementByXPath("//button[@value='Log In']").click();
           
          driver.get("http://cricbuzz.com");
          driver.findElementByXPath("//a[@href='#menu']").click();
          driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
          System.out.println(driver.getCurrentUrl());
           
          JavascriptExecutor jse = (JavascriptExecutor) driver;
          jse.executeScript("window.scrollBy(0,480)",""); // Min scroll point is 250
 Assert.assertFalse(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header")); //Assert.assetTrue was in the lecture originaly but no seggestion for import
           
           //adb devices -Unautorized
           //adb kill-server
           //adb start-server
           //adb devices 
          
	}
}
