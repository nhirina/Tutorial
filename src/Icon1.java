import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Icon1 extends base2Icon {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver=Capabilities("real");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		driver.findElementByXPath("//android.widget.Button[@text='Link my pass']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='GOT IT!']").click();
		driver.findElementByXPath("//android.widget.Button[@text='Allow']").click();
		driver.findElementByXPath("//android.widget.EditText[@text='EMAIL']").sendKeys("qa+base11@fueled.com");
		driver.findElementByXPath("//android.widget.EditText[@text='PASSWORD']").sendKeys("Testing1");
		Thread.sleep(4000);
		//driver.findElementByXPath("//android.widget.TextView[@text='sign in']").click();
		driver.findElementById("com.alterramtnco.ikonpass.stage:id/login_button").click();
		System.out.println("1");
		
		//driver.findElementByClassName("android.widget.CheckBox").click();
		//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		//driver.findElementsByClassName("android.widget.Button").get(1).click(); //Index starts with "0"
		//driver.findElementById("android:id/checkbox").click();
			
	}

}
