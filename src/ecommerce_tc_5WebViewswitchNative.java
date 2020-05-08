import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import static io.appium.java_client.touch.TapOptions.tapOptions; // static imports done mannualy 
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class ecommerce_tc_5WebViewswitchNative extends baseEcommerce {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
	AndroidDriver<AndroidElement> driver=Capabilities();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
	driver.hideKeyboard();
	driver.findElementByXPath("//*[@text='Female']").click();
	driver.findElement(By.id("android:id/text1")).click();
	//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Argentina" + "\").instance(0))"));
    //scrolling for older versions (containedText = Argentina)
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
	driver.findElementByXPath("//*[@text='Argentina']").click();
	driver.findElementByXPath("//*[@class='android.widget.Button']").click();
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
		
	driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(0).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("+ "new UiSelector().text(\"Nike Blazer Mid '77\"));");
	driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(0).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(4000); ////when object the same on multiple pages use thread sleep 
		
	//Mobile Gestures 
	WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
	TouchAction t = new TouchAction(driver);
	t.tap(tapOptions().withElement(element(checkbox))).perform(); //Tap
	    
	driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
	Thread.sleep(7000);
	Set<String>contexts = driver.getContextHandles();
	for (String contextName : contexts)
	{
	 System.out.println(contextName);	
	}
	driver.context("WEBVIEW_com.androidsample.generalstore"); // switchig to web view context and Selenium API can be used 
	//driver.findElementByXPath("//android.widget.Button[@text='NO, THANKS']").click();
	//driver.findElementByClassName("(android.widget.Button)[0]").click();
	Thread.sleep(7000);
	
	//-driver.findElement(By.xpath("//android.widget.EditText[@id = 'lst-ib']")).sendKeys("Google");
	//-driver.findElement(By.name("q")).sendKeys("Hello");
	//-driver.findElement(By.xpath("//Cdl0yb[@type='button']")).click();
	//-driver.findElement(By.className("gLFyf")).sendKeys("Google");
	//-driver.findElement(By.id("fakebox-input")).sendKeys("Google");
	
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.context("NATIVE_APP");
	}	
}
