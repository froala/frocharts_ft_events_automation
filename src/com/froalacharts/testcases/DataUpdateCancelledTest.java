package com.froalacharts.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.events.AnimationInvoked;
import com.froalacharts.events.BeforeDataUpdate;
import com.froalacharts.events.BeforeDispose;
import com.froalacharts.events.BeforeDraw;
import com.froalacharts.events.BeforeExport;
import com.froalacharts.events.BeforeInitialize;
import com.froalacharts.events.BeforeRender;
import com.froalacharts.events.BeforeResize;
import com.froalacharts.events.ChartClick;
import com.froalacharts.events.ChartMouseMove;
import com.froalacharts.events.ChartRollOut;
import com.froalacharts.events.ChartRollOver;
import com.froalacharts.events.DataLoaded;
import com.froalacharts.events.DataUpdateCancelled;
import com.froalacharts.events.DataUpdated;
import com.froalacharts.events.Disposed;
import com.froalacharts.events.DrawComplete;
import com.froalacharts.events.Exported;
import com.froalacharts.events.Initialized;
import com.froalacharts.events.Loaded;
import com.froalacharts.events.Ready;
import com.froalacharts.events.RenderComplete;
import com.froalacharts.events.Rendered;
import com.froalacharts.events.Resized;
import com.froalacharts.pom.EventsPageObjectModel;
import com.froalacharts.util.TestUtil;


public class DataUpdateCancelledTest extends EventsTestBase  {

	//The api name according to the data sheet
	private final static String eventTestName = "dataUpdateCancelled"; 
	Object[][] data;
	EventsPageObjectModel pom;
	static String htmlData;
	String[] allCharts = new String[25];
	private static JavascriptExecutor js;
	
	
	@BeforeTest(groups = { "includetest" })
	public void setUp() 
	{
		events = new EventsTestBase();
		events.initialize();
		pom = new EventsPageObjectModel();
		data = TestUtil.getTestData();
		js = (JavascriptExecutor) driver;
		
		boolean eventExists = TestUtil.thisEventExists(data, eventTestName);
		Assert.assertTrue(eventExists, "Event name matches in data sheet");
		
		htmlData = TestUtil.getHtml(data, eventTestName);
		
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		pom.ischartRendered();
		
	}
	
	@Test(priority=1, groups = { "includetest" })
	public void dataUpdateCancelled()
	{
		DataUpdateCancelled.dataupdatecancelled();
	}
	
	@AfterTest(groups = { "includetest" })
	public void shutDown() 
	{
		try
		{
			System.out.println("dataUpdateCancelled executed");
			Thread.sleep(3000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		report.endTest(test);
		report.flush();
		driver.quit();
	}


}
