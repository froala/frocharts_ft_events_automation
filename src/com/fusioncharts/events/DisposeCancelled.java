package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class DisposeCancelled extends EventsTestBase {
	
	public static EventsBO disposecancelled;
	private static String eventName = "disposecancelled";
	
	@Test()
	public static void disposecancelled()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		disposecancelled = new EventsBO();
		
        disposecancelled.setEventID((long) js.executeScript("return events.disposecancelled.eObj.eventId"));
        disposecancelled.setEventType((String) js.executeScript("return events.disposecancelled.eObj.eventType"));
        disposecancelled.setCancelled((boolean) js.executeScript("return events.disposecancelled.eObj.cancelled"));
        disposecancelled.setStopPropagation((Map<String, Object>) js.executeScript("return events.disposecancelled.eObj.stopPropagation"));
        disposecancelled.setDefaultPrevented((boolean) js.executeScript("return events.disposecancelled.eObj.defaultPrevented"));
        disposecancelled.setPreventDefault((Map<String, Object>) js.executeScript("return events.disposecancelled.eObj.preventDefault"));
        disposecancelled.setDetached((boolean) js.executeScript("return events.disposecancelled.eObj.detached"));
        disposecancelled.setDetachHandler((Map<String, Object>) js.executeScript("return events.disposecancelled.eObj.detachHandler"));
        disposecancelled.setChartType((String) js.executeScript("return events.disposecancelled.eObj.sender.chartType()"));
        
        Assert.assertTrue(disposecancelled.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(disposecancelled.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(disposecancelled.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(disposecancelled.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(disposecancelled.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(disposecancelled.getDetached()==false, "detached is false");
        Assert.assertTrue(disposecancelled.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(disposecancelled.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        DisposeCancelled.disposecancelledCount();
	}
	
	public static void disposecancelledCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}