
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base2Icon { 

	public static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException {
		
		File f=new File("src"); 
		File fs=new File(f,"build820.apk"); 
		
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
    cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
    AndroidDriver<AndroidElement> driver =new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
    return driver; 
    
    //UIAutomatorViewer  C:\Users\nataliya.hirina\AppData\Local\Android\Sdk\tools\bin 
	}
}