package com.fusioncharts.testcases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.events.BeforeDraw;
import com.fusioncharts.events.CanvasDrag;
import com.fusioncharts.events.CanvasDragEnd;
import com.fusioncharts.events.CanvasDragStart;
import com.fusioncharts.events.CanvasWheel;
import com.fusioncharts.events.CustomRangeSelect;
import com.fusioncharts.events.DataMarkerClick;
import com.fusioncharts.events.DataMarkerRollOut;
import com.fusioncharts.events.DataMarkerRollOver;
import com.fusioncharts.events.ReferenceLineClick;
import com.fusioncharts.events.ReferenceLineRollOut;
import com.fusioncharts.events.ReferenceLineRollOver;
import com.fusioncharts.events.ReferenceZoneClick;
import com.fusioncharts.events.ReferenceZoneRollOut;
import com.fusioncharts.events.ReferenceZoneRollOver;
import com.fusioncharts.events.SelectionChange;
import com.fusioncharts.events.StandardRangeSelect;
import com.fusioncharts.events.TimeMarkerClick;
import com.fusioncharts.events.TimeMarkerRollOut;
import com.fusioncharts.events.TimeMarkerRollOver;
import com.fusioncharts.events.TimeNavBrushEndScale;
import com.fusioncharts.events.TimeNavBrushEndTranslate;
import com.fusioncharts.events.TimeNavBrushScale;
import com.fusioncharts.events.TimeNavBrushStartScale;
import com.fusioncharts.events.TimeNavBrushStartTranslate;
import com.fusioncharts.events.TimeNavBrushTranslate;
import com.fusioncharts.pom.EventsPageObjectModel;
import com.fusioncharts.util.EventsBO;
import com.fusioncharts.util.TestUtil;

public class SpecificEventsTest extends EventsTestBase{

	//The api name according to the data sheet
	private final static String eventTestName = "componentLoadEvents"; 
	public static EventsBO boBefore = new EventsBO();
	public static EventsBO boAfter = new EventsBO();
	public static EventsBO boBeforeTranslate = new EventsBO();
	public static EventsBO boAfterTranslate = new EventsBO();
	public static EventsBO boCRS = new EventsBO();
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
	public void timenavbrushScale()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", pom.timeNavBody());
		
		boBefore.setStartDateTimeNav(pom.timeNavStartDate());
		boBefore.setEndDateTimeNav(pom.timeNavEndDate());
		
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		pom.dragTimeNavRightBy(-450);
		
		boAfter.setStartDateTimeNav(pom.timeNavStartDate());
		boAfter.setEndDateTimeNav(pom.timeNavEndDate());
		
		TimeNavBrushScale.timenavbrush();
	}
	
	@Test(priority=2, groups = { "includetest" })
	public void timenavbrushstartScale()
	{
		TimeNavBrushStartScale.timenavbrushstart();
	}
	
	@Test(priority=3, groups = { "includetest" })
	public void timenavbrushendScale()
	{
		TimeNavBrushEndScale.timenavbrushend();
	}
	
	@Test(priority=4, groups = { "includetest" })
	public void timenavbrushTranslate()
	{
		try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
		js.executeScript("arguments[0].scrollIntoView(true);", pom.timeNavBody());
		
		boBeforeTranslate.setStartDateTimeNav(pom.timeNavStartDate());
		boBeforeTranslate.setEndDateTimeNav(pom.timeNavEndDate());
		
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		pom.dragTimeNavBodyBy(300);
		
		boAfterTranslate.setStartDateTimeNav(pom.timeNavStartDate());
		boAfterTranslate.setEndDateTimeNav(pom.timeNavEndDate());
		
		TimeNavBrushTranslate.timenavbrush();
	}
	
	@Test(priority=5, groups = { "includetest" })
	public void timenavbrushstartTranslate()
	{
		TimeNavBrushStartTranslate.timenavbrushstart();
	}
	
	@Test(priority=6, groups = { "includetest" })
	public void timenavbrushendTranslate()
	{
		TimeNavBrushEndTranslate.timenavbrushend();
	}
	
	@Test(priority=7, groups = { "includetest" })
	public void canvaswheel() throws AWTException
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		pom.canvasZoomIn();
		CanvasWheel.canvaswheel();
	}
	
	@Test(priority=8, groups = { "includetest" })
	public void canvasdrag() throws AWTException
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		js.executeScript("arguments[0].scrollIntoView(true);", pom.srs());
		pom.srs().findElement(By.tagName("text")).click();
		pom.canvasDrag();
		CanvasDrag.canvasdrag();
	}
	
	@Test(priority=9, groups = { "includetest" })
	public void canvasdragstart() 
	{
		CanvasDragStart.canvasdragstart();
	}
	
	@Test(priority=10, groups = { "includetest" })
	public void canvasdragend() 
	{
		CanvasDragEnd.canvasdragend();
	}
	
	@Test(priority=11, groups = { "includetest" })
	public void customrangeselect()
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		boCRS.setStartDateTimeNav(pom.timeNavStartDate());
		boCRS.setEndDateTimeNav(pom.timeNavEndDate());
		pom.ApplyButtonCRS().click();
		
		CustomRangeSelect.customrangeselect();
	}
	
	@Test(priority=12, groups = { "includetest" })
	public void standardrangeselect()
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		js.executeScript("arguments[0].scrollIntoView(true);", pom.srs());
		pom.srs().findElement(By.tagName("text")).click();
		
		StandardRangeSelect.standardrangeselect();
	}
	
	@Test(priority=13, groups = { "includetest" })
	public void selectionchange()
	{
		SelectionChange.selectionchange();
	}
	
	@Test(priority=14, groups = { "includetest" })
	public void referencelineclick()
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		pom.refLineRollOverClickRollOut();
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		ReferenceLineClick.referencelineclick();
	}
	
	@Test(priority=15, groups = { "includetest" })
	public void referencelinerollout()
	{
		ReferenceLineRollOut.referencelinerollout();
	}
	
	@Test(priority=16, groups = { "includetest" })
	public void referencelinerollover()
	{
		ReferenceLineRollOver.referencelinerollover();
	}
	
	@Test(priority=17, groups = { "includetest" })
	public void referencezoneclick()
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		pom.refZoneRollOverClickRollOut();
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		ReferenceZoneClick.referencezoneclick();
	}
	
	@Test(priority=18, groups = { "includetest" })
	public void referencezonerollout()
	{
		ReferenceZoneRollOut.referencezonerollout();
	}
	
	@Test(priority=19, groups = { "includetest" })
	public void referencezonerollover()
	{
		ReferenceZoneRollOver.referencezonerollover();
	}
	
	@Test(priority=20, groups = { "includetest" })
	public void datamarkerclick()
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		pom.dataMarkerRollOverClickRollOut();
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		DataMarkerClick.datamarkerclick();
	}
	
	@Test(priority=21, groups = { "includetest" })
	public void datamarkerrollout()
	{
		DataMarkerRollOut.datamarkerrollout();
	}
	
	@Test(priority=22, groups = { "includetest" })
	public void datamarkerrollover()
	{
		DataMarkerRollOver.datamarkerrollover();
	}
	
	@Test(priority=23, groups = { "includetest" })
	public void timemarkerclick()
	{
		driver.navigate().refresh();
		pom.ischartRendered();
		pom.timeMarkerRollOverClickRollOut();
		try {Thread.sleep(1000);} catch (InterruptedException e){e.printStackTrace();}
		TimeMarkerClick.timemarkerclick();
	}
	
	@Test(priority=24, groups = { "includetest" })
	public void timemarkerrollout()
	{
		TimeMarkerRollOut.timemarkerrollout();
	}
	
	@Test(priority=25, groups = { "includetest" })
	public void timemarkerrollover()
	{
		TimeMarkerRollOver.timemarkerrollover();
	}
	
	
	
	@AfterTest(groups = { "includetest" })
	public void shutDown() 
	{
		try
		{
			System.out.println("SpecificEventsTest executed");
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
