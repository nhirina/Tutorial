
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Hybridbase { //base copy

	public static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException {
		
		File f=new File("src"); //folder where apk is located 
		File fs=new File(f,"ApiDemos-debug.apk"); // apk
		
    DesiredCapabilities cap = new DesiredCapabilities();
    
    if(device.equals("emulator"))
    {
    	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixelemulator"); 
    }
    else if(device.equals("real"))
    {
    	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); 
    }
    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); // Android updated its internal framework to uiautomator2 and through Appium code, we need to tell that we need to access uiautomator2 elements of Android.
    cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath()); // Path to application
    AndroidDriver<AndroidElement> driver =new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
    return driver; 
    
    
    
     //(connectiontoserverlink,cap) connection to the appium server, argument and opening cap object
		//http://127.0.0.1 the same in any Windows machine, 4723 from cmd appium server, wd - web driver 
    
    //UIAutomatorViewer  C:\Users\nataliya.hirina\AppData\Local\Android\Sdk\tools\bin
    
	}

}