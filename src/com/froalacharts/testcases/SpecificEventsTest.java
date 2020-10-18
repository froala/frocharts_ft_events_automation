package com.froalacharts.testcases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.events.BeforeDraw;
import com.froalacharts.events.CanvasDrag;
import com.froalacharts.events.CanvasDragEnd;
import com.froalacharts.events.CanvasDragStart;
import com.froalacharts.events.CanvasWheel;
import com.froalacharts.events.CustomRangeSelect;
import com.froalacharts.events.DataMarkerClick;
import com.froalacharts.events.DataMarkerRollOut;
import com.froalacharts.events.DataMarkerRollOver;
import com.froalacharts.events.ReferenceLineClick;
import com.froalacharts.events.ReferenceLineRollOut;
import com.froalacharts.events.ReferenceLineRollOver;
import com.froalacharts.events.ReferenceZoneClick;
import com.froalacharts.events.ReferenceZoneRollOut;
import com.froalacharts.events.ReferenceZoneRollOver;
import com.froalacharts.events.SelectionChange;
import com.froalacharts.events.StandardRangeSelect;
import com.froalacharts.events.TimeMarkerClick;
import com.froalacharts.events.TimeMarkerRollOut;
import com.froalacharts.events.TimeMarkerRollOver;
import com.froalacharts.events.TimeNavBrushEndScale;
import com.froalacharts.events.TimeNavBrushEndTranslate;
import com.froalacharts.events.TimeNavBrushScale;
import com.froalacharts.events.TimeNavBrushStartScale;
import com.froalacharts.events.TimeNavBrushStartTranslate;
import com.froalacharts.events.TimeNavBrushTranslate;
import com.froalacharts.pom.EventsPageObjectModel;
import com.froalacharts.util.EventsBO;
import com.froalacharts.util.TestUtil;

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
