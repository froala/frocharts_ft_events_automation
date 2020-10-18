package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.pom.EventsPageObjectModel;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class CanvasWheel extends EventsTestBase{

	public static EventsBO canvaswheel;
	private static String eventName = "canvaswheel";
	
	@Test()
	public static void canvaswheel()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		canvaswheel = new EventsBO();
		EventsPageObjectModel pomObj = new EventsPageObjectModel();
		
        canvaswheel.setEventID((long) js.executeScript("return events.canvaswheel.eObj.eventId"));
        canvaswheel.setEventType((String) js.executeScript("return events.canvaswheel.eObj.eventType"));
        canvaswheel.setCancelled((boolean) js.executeScript("return events.canvaswheel.eObj.cancelled"));
        canvaswheel.setStopPropagation((Map<String, Object>) js.executeScript("return events.canvaswheel.eObj.stopPropagation"));
        canvaswheel.setDefaultPrevented((boolean) js.executeScript("return events.canvaswheel.eObj.defaultPrevented"));
        canvaswheel.setPreventDefault((Map<String, Object>) js.executeScript("return events.canvaswheel.eObj.preventDefault"));
        canvaswheel.setDetached((boolean) js.executeScript("return events.canvaswheel.eObj.detached"));
        canvaswheel.setDetachHandler((Map<String, Object>) js.executeScript("return events.canvaswheel.eObj.detachHandler"));
        canvaswheel.setChartType((String) js.executeScript("return events.canvaswheel.eObj.sender.chartType()"));
        
        
        long start = (long) js.executeScript("return events.canvaswheel.eObj.data.start");
        long end = (long) js.executeScript("return events.canvaswheel.eObj.data.end");
        
        
        Assert.assertTrue(canvaswheel.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(canvaswheel.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(canvaswheel.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(canvaswheel.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(canvaswheel.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(canvaswheel.getDetached()==false, "detached is false");
        Assert.assertTrue(canvaswheel.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(canvaswheel.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(end>start, "end is more than start");
        
        CanvasWheel.canvaswheelCount();
	}
	
	public static void canvaswheelCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}