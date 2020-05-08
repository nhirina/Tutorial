import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

public class ecommerce_tc_3 extends baseEcommerce {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
	AndroidDriver<AndroidElement> driver=Capabilities();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
	driver.hideKeyboard();
	driver.findElementByXPath("//*[@text='Female']").click();
	driver.findElement(By.id("android:id/text1")).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");	
	driver.findElementByXPath("//*[@text='Argentina']").click();
	driver.findElementByXPath("//*[@class='android.widget.Button']").click();
			
	//List of items usually identified by scrollable component widget.RecyclerView (Parent - Recycler)
	// MobileElement radioGroup = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"+ ".resourceId(\"android:id/list\")).scrollIntoView("+ "new UiSelector().text(\"Radio Group\"));"); - Syntax
	//(\"android:id/list\") = com.androidsample.generalstore:id/rvProductList
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("+ "new UiSelector().text(\"Jordan 6 Rings\"));");
	//or (To scroll to the item in the list that contains text)
	//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
	
	int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size(); 
	 for (int i=0; i<count; i++)
	   {
	   String text =driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
	       if( text.equalsIgnoreCase("Jordan 6 Rings"))
	       {
	         driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
	         break;
	       }
	   }				
	 driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	 Thread.sleep(4000);	//when object the same on multiple pages use thread sleep 
	 String lastPageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();  //element for 1 item. elements for multiple 
	
	 Assert.assertEquals("Jordan 6 Rings", lastPageText); //(expected, actual)
}         
}
