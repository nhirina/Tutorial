import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_1 extends baseEcommerce {
	
	public static void main(String[] args) throws MalformedURLException {
		
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
}
}