package com.fusioncharts.events;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fusioncharts.base.EventsTestBase;
import com.fusioncharts.testcases.EventsCountTest;
import com.fusioncharts.util.EventsBO;

public class DataLoaded extends EventsTestBase {

	public static EventsBO dataloaded;
	private static String eventName = "dataloaded";
	
	@Test()
	public static void dataloaded()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		dataloaded = new EventsBO();
		
        dataloaded.setEventID((long) js.executeScript("return events.dataloaded.eObj.eventId"));
        dataloaded.setEventType((String) js.executeScript("return events.dataloaded.eObj.eventType"));
        dataloaded.setCancelled((boolean) js.executeScript("return events.dataloaded.eObj.cancelled"));
        dataloaded.setStopPropagation((Map<String, Object>) js.executeScript("return events.dataloaded.eObj.stopPropagation"));
        dataloaded.setDefaultPrevented((boolean) js.executeScript("return events.dataloaded.eObj.defaultPrevented"));
        dataloaded.setPreventDefault((Map<String, Object>) js.executeScript("return events.dataloaded.eObj.preventDefault"));
        dataloaded.setDetached((boolean) js.executeScript("return events.dataloaded.eObj.detached"));
        dataloaded.setDetachHandler((Map<String, Object>) js.executeScript("return events.dataloaded.eObj.detachHandler"));
        dataloaded.setChartType((String) js.executeScript("return events.dataloaded.eObj.sender.chartType()"));
        
        
        
        Assert.assertTrue(dataloaded.getEventType().equals(eventName), "eventType is event name");
        Assert.assertTrue(dataloaded.getCancelled()==false, "cancelled is false");
        Assert.assertTrue(dataloaded.getStopPropagation().toString().equals("{}"), "stopPropagation is a function");
        Assert.assertTrue(dataloaded.getDefaultPrevented()==false, "defaultPrevented is false");
        Assert.assertTrue(dataloaded.getPreventDefault().toString().equals("{}"), "preventDefault is a function");
        Assert.assertTrue(dataloaded.getDetached()==false, "detached is false");
        Assert.assertTrue(dataloaded.getDetachHandler().toString().equals("{}"), "detachHandler is a function");
        Assert.assertTrue(dataloaded.getChartType().equals("timeseries"), "sender.chartType is timeseries");
        
        DataLoaded.dataloadedCount();
	}
	
	public static void dataloadedCount()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long count = (long) js.executeScript("return getEventCount('"+eventName+"')");
		EventsCountTest.eventCount.put(eventName,(int)count);
	}

}