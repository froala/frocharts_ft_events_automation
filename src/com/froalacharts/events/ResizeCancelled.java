package com.froalacharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.froalacharts.base.EventsTestBase;
import com.froalacharts.testcases.EventsCountTest;
import com.froalacharts.util.EventsBO;

public class ResizeCancelled extends EventsTestBase {
	
	public static EventsBO resizecancelled;
	private static String eventName = "resizecancelled";
	
	@Test()
	public static void resizecancelled()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		resizecancelled = new EventsBO();
		
        resizecancelled.setEventID((long) js.executeScript("return events.resizecancelled.eObj.eventId"));
        resizecancelled.setEventType((String) js.executeScript("return events.resizecancelled.eObj.eventType"));
        resizecancelled.setCancelled((boolean) js.executeScript("return events.resizecancelled.eObj.cancelled"));
        resizecancelled.setStopPropagation((Map<String, Object>) js.executeScript("return events.resizecancelled.eObj.stopPropagation"));
        resizecancelled.setDefaultPrevented((boolean) js.executeScript("return events.resizecancelled.eObj.defaultPrevented"));
        resizecancelled.setPreventDefault((Map<String, Object>) js.executeScript("return events.resizecancelled.eObj.preventDefault"));
        resizecancelled.setDetached((boolean) js.executeScript("return events.resizecancelled.eObj.detached"));
        resizecancelled.setDetachHandler((Map<String, Object>) js.executeScript("return events.resizecancelled.eObj.detachHandler"));
        resizecancelled.setChartType((String) js.executeScript("return events.resizecancelled.eObj.sender.chartType()"));
        
        Assert.assertTrue(resizecancelled.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(resizecancelled.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(resizecancelled.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(resizecancelled.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(resizecancelled.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(resizecancelled.getDetached()==false, "detached is false");
        Assert.assertTrue(resizecancelled.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(resizecancelled.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        ResizeCancelled.resizecancelledCount();
	}
	
	public static void resizecancelledCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}