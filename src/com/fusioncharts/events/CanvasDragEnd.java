package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.pom.EventsPageObjectModel;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class CanvasDragEnd extends EventsTestBase{

	public static EventsBO canvasdragend;
	private static String eventName = "canvasdragend";
	
	@Test()
	public static void canvasdragend()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		canvasdragend = new EventsBO();
		EventsPageObjectModel pomObj = new EventsPageObjectModel();
		
        canvasdragend.setEventID((long) js.executeScript("return events.canvasdragend.eObj.eventId"));
        canvasdragend.setEventType((String) js.executeScript("return events.canvasdragend.eObj.eventType"));
        canvasdragend.setCancelled((boolean) js.executeScript("return events.canvasdragend.eObj.cancelled"));
        canvasdragend.setStopPropagation((Map<String, Object>) js.executeScript("return events.canvasdragend.eObj.stopPropagation"));
        canvasdragend.setDefaultPrevented((boolean) js.executeScript("return events.canvasdragend.eObj.defaultPrevented"));
        canvasdragend.setPreventDefault((Map<String, Object>) js.executeScript("return events.canvasdragend.eObj.preventDefault"));
        canvasdragend.setDetached((boolean) js.executeScript("return events.canvasdragend.eObj.detached"));
        canvasdragend.setDetachHandler((Map<String, Object>) js.executeScript("return events.canvasdragend.eObj.detachHandler"));
        canvasdragend.setChartType((String) js.executeScript("return events.canvasdragend.eObj.sender.chartType()"));
        
        
        long start = (long) js.executeScript("return events.canvasdragend.eObj.data.start");
        long end = (long) js.executeScript("return events.canvasdragend.eObj.data.end");
        
        
        Assert.assertTrue(canvasdragend.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(canvasdragend.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(canvasdragend.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(canvasdragend.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(canvasdragend.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(canvasdragend.getDetached()==false, "detached is false");
        Assert.assertTrue(canvasdragend.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(canvasdragend.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        Assert.assertTrue(end>start, "end is more than start");
        
        CanvasDragEnd.canvasdragendCount();
	}
	
	public static void canvasdragendCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}