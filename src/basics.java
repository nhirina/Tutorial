import java.awt.Button;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckBox;
import pageObjects.HomePage;
import pageObjects.Preferances;

public class basics extends Hybridbase {

	public static void main(String[] args) throws MalformedURLException {
	
     	AndroidDriver<AndroidElement> driver=Capabilities("real");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage h=new HomePage(driver);
		//Constructor of the class will be invoked when you create object for the class
	
		//default constructor will be called 
		
		//constructor can be defined with arguments 
		
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		//You can call the method or the variables of the class with the class objects 
		h.Preferances.click();
	    
		Preferances p=new Preferances(driver);
		p.dependencies.click();		
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		CheckBox c=new CheckBox(driver);
		c.checkBox.click();
		//driver.findElementByClassName("android.widget.CheckBox").click();
		
		
		driver.findElementById("android:id/checkbox").click();    
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		
		p.button.get(1).click();
		//driver.findElementsByClassName("android.widget.Button").get(1).click(); 
		
		//xpath id className, androidUIautomator
		//xpath Syntax tagName[@attribute='value']
				 
	}
}
