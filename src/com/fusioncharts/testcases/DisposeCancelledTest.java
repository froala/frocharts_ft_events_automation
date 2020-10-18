package com.fusioncharts.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.events.AnimationInvoked;
import com.fusioncharts.events.BeforeDataUpdate;
import com.fusioncharts.events.BeforeDispose;
import com.fusioncharts.events.BeforeDraw;
import com.fusioncharts.events.BeforeExport;
import com.fusioncharts.events.BeforeInitialize;
import com.fusioncharts.events.BeforeRender;
import com.fusioncharts.events.BeforeResize;
import com.fusioncharts.events.ChartClick;
import com.fusioncharts.events.ChartMouseMove;
import com.fusioncharts.events.ChartRollOut;
import com.fusioncharts.events.ChartRollOver;
import com.fusioncharts.events.ContainerNotFound;
import com.fusioncharts.events.DataLoaded;
import com.fusioncharts.events.DataUpdated;
import com.fusioncharts.events.DisposeCancelled;
import com.fusioncharts.events.Disposed;
import com.fusioncharts.events.DrawCancelled;
import com.fusioncharts.events.DrawComplete;
import com.fusioncharts.events.Exported;
import com.fusioncharts.events.Initialized;
import com.fusioncharts.events.Loaded;
import com.fusioncharts.events.NoDataToDisplay;
import com.fusioncharts.events.Ready;
import com.fusioncharts.events.RenderComplete;
import com.fusioncharts.events.Rendered;
import com.fusioncharts.events.Resized;
import com.fusioncharts.pom.EventsPageObjectModel;
import com.fusioncharts.util.TestUtil;

public class DisposeCancelledTest extends EventsTestBase {

	//The api name according to the data sheet
	private final static String eventTestName = "disposeCancelled"; 
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
	public void disposeCancelled()
	{
		js.executeScript("tsChart.dispose()");
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
		DisposeCancelled.disposecancelled();
	}
	
	@AfterTest(groups = { "includetest" })
	public void shutDown() 
	{
		try
		{
			System.out.println("disposeCancelled executed");
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
