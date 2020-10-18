package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class BeforePrint extends EventsTestBase {

	public static EventsBO beforeprint;
	private static String eventName = "beforeprint";
	
	@Test()
	public static void beforeprint()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		beforeprint = new EventsBO();
		
        beforeprint.setEventID((long) js.executeScript("return events.beforeprint.eObj.eventId"));
        beforeprint.setEventType((String) js.executeScript("return events.beforeprint.eObj.eventType"));
        beforeprint.setCancelled((boolean) js.executeScript("return events.beforeprint.eObj.cancelled"));
        beforeprint.setStopPropagation((Map<String, Object>) js.executeScript("return events.beforeprint.eObj.stopPropagation"));
        beforeprint.setDefaultPrevented((boolean) js.executeScript("return events.beforeprint.eObj.defaultPrevented"));
        beforeprint.setPreventDefault((Map<String, Object>) js.executeScript("return events.beforeprint.eObj.preventDefault"));
        beforeprint.setDetached((boolean) js.executeScript("return events.beforeprint.eObj.detached"));
        beforeprint.setDetachHandler((Map<String, Object>) js.executeScript("return events.beforeprint.eObj.detachHandler"));
        beforeprint.setChartType((String) js.executeScript("return events.beforeprint.eObj.sender.chartType()"));
        
        Assert.assertTrue(beforeprint.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(beforeprint.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(beforeprint.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(beforeprint.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(beforeprint.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(beforeprint.getDetached()==false, "detached is false");
        Assert.assertTrue(beforeprint.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(beforeprint.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
       
        BeforePrint.beforeprintCount();
	}
	
	public static void beforeprintCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}