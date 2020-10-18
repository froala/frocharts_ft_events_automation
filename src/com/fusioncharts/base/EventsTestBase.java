package com.fusioncharts.base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class EventsTestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest test;
	public EventsTestBase events;
	public static String htmlFile = System.getProperty("user.dir")+"/ft_auto_samples/test.html";
	public static String configFile = System.getProperty("user.dir")+"/src/com/fusioncharts/config/config.properties";
	public static String extentreportXMLFile = System.getProperty("user.dir")+"/src/com/fusioncharts/config/extent-config.xml";
	public static String extentreportReportFile = System.getProperty("user.dir") +"/test-output/FC_API_ExtentReport.html";
	
	
	public EventsTestBase() 
	{
		try 
		{
			prop = new Properties();
			FileInputStream file = new FileInputStream(configFile);
			prop.load(file);
			report = new ExtentReports(extentreportReportFile);
			report.loadConfig(new File(extentreportXMLFile));
			test = report.startTest("FT Events Automation");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void initialize()
	{
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			
			FirefoxProfile myprofile = new FirefoxProfile();
			myprofile.setPreference("browser.download.dir", "/Users/interview/Documents/work");
			myprofile.setPreference("browser.download.folderList", 2);
			myprofile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			myprofile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			myprofile.setPreference("browser.helperApps.alwaysAsk.force", false);
			myprofile.setPreference("browser.download.manager.focusWhenStarting", false);
			myprofile.setPreference("browser.download.manager.useWindow", false);
			myprofile.setPreference("browser.download.manager.showWhenStarting", false );
			myprofile.setPreference("pdfjs.disabled", true );
			
			FirefoxOptions opt = new FirefoxOptions();
			opt.setProfile(myprofile);
			
			driver=new FirefoxDriver(opt);
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			String nodeURL1 = "http://192.168.2.169:5566/wd/hub";
				System.setProperty("webdriver.ie.driver","C:\\Users\\QA Team\\Documents\\IEDriverServer.exe");
				DesiredCapabilities capability1 = DesiredCapabilities.chrome();
				//capability1.setJavascriptEnabled(true);
				//				capability1.setBrowserName("internet explorer");
				//				capability1.setPlatform(Platform.WINDOWS);
				//				capability1.setVersion("11");
				//				capability1.setCapability("ignoreZoomSetting", true);
				//				capability1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
				//				capability1.acceptInsecureCerts();
				try {
					driver = new RemoteWebDriver(new URL(nodeURL1), capability1);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				//driver.get("http://www.google.com");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	public static void jsExecuteWithBuffer(String apiScript)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript(apiScript);
		
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static String capture(String screenShotName) throws IOException
    {
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(100,0,0,2)).takeScreenshot(driver);
        String dest = System.getProperty("user.dir") + "/Screenshots/"+screenShotName+".png"; 
		ImageIO.write(fpScreenshot.getImage(),"PNG",new File(dest));     
                     
        return dest;
    }
}
