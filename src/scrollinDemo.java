import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrollinDemo extends base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

	AndroidDriver<AndroidElement> driver=Capabilities();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	// driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));"); 
	//We are executing Android API call inside this function 	 
	}
}
