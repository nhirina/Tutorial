import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseChrome { 

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
			
    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");   //  cap.setCapability(capabilityName, value);
    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); // Android updated its internal framework to uiautomator2 and through Appium code, we need to tell that we need to access uiautomator2 elements of Android.
    //cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath()); // Path to application
    
    cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
    cap.setCapability("chromedriverExecutable", "C:\\Users\\nataliya.hirina\\AppData\\Roaming\\npm\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
    //C:\Users\nataliya.hirina\AppData\Roaming\npm\node_modules\appium\node_modules\appium-chromedriver\chromedriver\win
    
    AndroidDriver<AndroidElement> driver =new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    return driver; 
       
	}
}