package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.pom.EventsPageObjectModel;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class CanvasDragStart extends EventsTestBase{

	public static EventsBO canvasdragstart;
	private static String eventName = "canvasdragstart";
	
	@Test()
	public static void canvasdragstart()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		canvasdragstart = new EventsBO();
		EventsPageObjectModel pomObj = new EventsPageObjectModel();
		
        canvasdragstart.setEventID((long) js.executeScript("return events.canvasdragstart.eObj.eventId"));
        canvasdragstart.setEventType((String) js.executeScript("return events.canvasdragstart.eObj.eventType"));
        canvasdragstart.setCancelled((boolean) js.executeScript("return events.canvasdragstart.eObj.cancelled"));
        canvasdragstart.setStopPropagation((Map<String, Object>) js.executeScript("return events.canvasdragstart.eObj.stopPropagation"));
        canvasdragstart.setDefaultPrevented((boolean) js.executeScript("return events.canvasdragstart.eObj.defaultPrevented"));
        canvasdragstart.setPreventDefault((Map<String, Object>) js.executeScript("return events.canvasdragstart.eObj.preventDefault"));
        canvasdragstart.setDetached((boolean) js.executeScript("return events.canvasdragstart.eObj.detached"));
        canvasdragstart.setDetachHandler((Map<String, Object>) js.executeScript("return events.canvasdragstart.eObj.detachHandler"));
        canvasdragstart.setChartType((String) js.executeScript("return events.canvasdragstart.eObj.sender.chartType()"));
        
        
        long start = (long) js.executeScript("return events.canvasdragstart.eObj.data.start");
        long end = (long) js.executeScript("return events.canvasdragstart.eObj.data.end");
        
        
        Assert.assertTrue(canvasdragstart.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(canvasdragstart.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(canvasdragstart.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(canvasdragstart.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(canvasdragstart.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(canvasdragstart.getDetached()==false, "detached is false");
        Assert.assertTrue(canvasdragstart.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(canvasdragstart.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(end>start, "end is more than start");
        
        CanvasDragStart.canvasdragstartCount();
	}
	
	public static void canvasdragstartCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}