import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseEcommerce {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		
		File appDir=new File("src"); //folder where apk is located 
		File app=new File(appDir,"General-Store.apk"); // apk
		 DesiredCapabilities cap = new DesiredCapabilities();
		 
    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");   //  cap.setCapability(capabilityName, value);
    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); // Android updated its internal framework to uiautomator2 and through Appium code, we need to tell that we need to access uiautomator2 elements of Android.
    cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
    
    //cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    //cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
    //cap.setCapability("chromedriverExecutable", "C:\\Users\\nataliya.hirina\\AppData\\Roaming\\npm\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
    
    cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); // Path to application
    AndroidDriver<AndroidElement> driver =new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
    return driver; 
    


	
}
}
