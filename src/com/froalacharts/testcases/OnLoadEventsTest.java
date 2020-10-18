package com.froalacharts.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.events.AnimationInvoked;
import com.froalacharts.events.BeforeDataUpdate;
import com.froalacharts.events.BeforeDispose;
import com.froalacharts.events.BeforeDraw;
import com.froalacharts.events.BeforeExport;
import com.froalacharts.events.BeforeInitialize;
import com.froalacharts.events.BeforePrint;
import com.froalacharts.events.BeforeRender;
import com.froalacharts.events.BeforeResize;
import com.froalacharts.events.ChartClick;
import com.froalacharts.events.ChartMouseMove;
import com.froalacharts.events.ChartRollOut;
import com.froalacharts.events.ChartRollOver;
import com.froalacharts.events.DataLoaded;
import com.froalacharts.events.DataPlotClick;
import com.froalacharts.events.DataPlotClickCandlestick;
import com.froalacharts.events.DataPlotRollOut;
import com.froalacharts.events.DataPlotRollOutCandlestick;
import com.froalacharts.events.DataPlotRollOverCandlestick;
import com.froalacharts.events.DataPlotRollover;
import com.froalacharts.events.DataUpdated;
import com.froalacharts.events.Disposed;
import com.froalacharts.events.DrawComplete;
import com.froalacharts.events.Exported;
import com.froalacharts.events.Initialized;
import com.froalacharts.events.LegendItemClicked;
import com.froalacharts.events.LegendItemRollOut;
import com.froalacharts.events.LegendItemRollOver;
import com.froalacharts.events.Loaded;
import com.froalacharts.events.PrintComplete;
import com.froalacharts.events.Ready;
import com.froalacharts.events.RenderComplete;
import com.froalacharts.events.Rendered;
import com.froalacharts.events.Resized;
import com.froalacharts.pom.EventsPageObjectModel;
import com.froalacharts.util.TestUtil;

public class OnLoadEventsTest extends EventsTestBase {

	//The api name according to the data sheet
	private final static String eventTestName = "componentLoadEvents"; 
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
	public void beforeDraw()
	{
		BeforeDraw.beforedraw(); 
	}
	
	@Test(priority=2, groups = { "includetest" })
	public void loaded()
	{
		Loaded.loaded(); 
	}
	
	@Test(priority=3, groups = { "includetest" })
	public void beforeRender()
	{
		BeforeRender.beforerender(); 
	}
	
	@Test(priority=4, groups = { "includetest" })
	public void renderComplete()
	{
		RenderComplete.rendercomplete(); 
	}
	
	@Test(priority=5, groups = { "includetest" })
	public void beforeInitialize()
	{
		BeforeInitialize.beforeinitialize(); 
	}
	
	@Test(priority=6, groups = { "includetest" })
	public void initialized()
	{
		Initialized.initialized(); 
	}
	
	@Test(priority=7, groups = { "includetest" })
	public void drawComplete()
	{
		DrawComplete.drawcomplete(); 
	}
	
	@Test(priority=8, groups = { "includetest" })
	public void beforeDataUpdate()
	{
		BeforeDataUpdate.beforedataupdate();
	}
	
	@Test(priority=9, groups = { "includetest" })
	public void dataUpdated()
	{
		DataUpdated.dataupdated(); 
	}
	
	@Test(priority=10, groups = { "includetest" })
	public void dataLoaded()
	{
		DataLoaded.dataloaded(); 
	}
	
	@Test(priority=11, groups = { "includetest" })
	public void animationInvoked()
	{
		AnimationInvoked.animationinvoked();  
	}

	@Test(priority=12, groups = { "includetest" })
	public void rendered()
	{
		Rendered.rendered(); 
	}

	@Test(priority=13, groups = { "includetest" })
	public void ready()
	{
		Ready.ready();
	}
	
	@Test(priority=14, groups = { "includetest" })
	public void beforeDispose()
	{
		js.executeScript("tsChart.dispose()");
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
		BeforeDispose.beforedispose();
	}
	
	@Test(priority=15, groups = { "includetest" })
	public void disposed()
	{
		Disposed.disposed();
	}
	
	@Test(priority=16, groups = { "includetest" })
	public void beforeResize()
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		js.executeScript("tsChart.resizeTo(1300,800);");
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
		BeforeResize.beforeresize();
	}
	
	@Test(priority=17, groups = { "includetest" })
	public void resized()
	{
		Resized.resized();
	}
	
	@Test(priority=18, groups = { "includetest" })
	public void chartClick()
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		pom.chartRollOverClickRollOut();
		ChartClick.chartclick();
	}
	
	@Test(priority=19, groups = { "includetest" })
	public void chartMouseMove()
	{
		ChartMouseMove.chartmousemove();
	}
	
	@Test(priority=20, groups = { "includetest" })
	public void chartRollOver()
	{
		ChartRollOver.chartrollover();
	}
	
	@Test(priority=21, groups = { "includetest" })
	public void chartRollOut()
	{
		ChartRollOut.chartrollout();
	}
	
	@Test(priority=22, groups = { "includetest" })
	public void beforeExport()
	{
		js.executeScript("tsChart.exportChart();");
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
		BeforeExport.beforeexport();
	}
	
	@Test(priority=23, groups = { "includetest" })
	public void exported()
	{
		Exported.exported();
	}
	
	@Test(priority=24, groups = { "includetest" })
	public void dataplotRollOver()
	{
		pom.dataplotRollOverClickRollOut();
		DataPlotRollover.dataplotrollover();
	}
	
	@Test(priority=25, groups = { "includetest" })
	public void dataplotRollOut()
	{
		DataPlotRollOut.dataplotrollout();
	}
	
	@Test(priority=26, groups = { "includetest" })
	public void dataplotClick()
	{
		DataPlotClick.dataplotclick();
	}
	
//	@Test(priority=27, groups = { "includetest" })
//	public void dataplotRollOverCandlestick()
//	{
//		pom.dataplotRollOverClickRollOutCandleStick();
//		DataPlotRollOverCandlestick.dataplotrollover();
//	}
//	
//	@Test(priority=28, groups = { "includetest" })
//	public void dataplotRollOutCandlestick()
//	{
//		DataPlotRollOutCandlestick.dataplotrollout();
//	}
//	
//	@Test(priority=29, groups = { "includetest" })
//	public void dataplotClickCandlestick()
//	{
//		DataPlotClickCandlestick.dataplotclick();
//	}
	
	@Test(priority=30, groups = { "includetest" })
	public void beforePrint() throws AWTException
	{
		js.executeScript("window.print=function(){};");
		js.executeScript("tsChart.print()");
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
		BeforePrint.beforeprint();
	}
	
	@Test(priority=31, groups = { "includetest" })
	public void printComplete()
	{
		PrintComplete.printcomplete();
	}
	
	@Test(priority=32, groups = { "includetest" })
	public void legendItemClicked()
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		pom.legendRollOverClickRollOut();
		LegendItemClicked.legenditemclicked();
	}
	
	@Test(priority=33, groups = { "includetest" })
	public void legendItemRollover()
	{
		LegendItemRollOver.legenditemrollover();
	}
	
	@Test(priority=34, groups = { "includetest" })
	public void legendItemRollout()
	{
		LegendItemRollOut.legenditemrollout();
	}
	
	
	@AfterTest(groups = { "includetest" })
	public void shutDown() 
	{
		try
		{
			System.out.println("onLoadEvents executed");
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